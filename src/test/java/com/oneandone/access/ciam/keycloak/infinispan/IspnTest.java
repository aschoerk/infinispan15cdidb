package com.oneandone.access.ciam.keycloak.infinispan;

import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.infinispan.Cache;
import org.infinispan.lifecycle.ComponentStatus;
import org.infinispan.manager.EmbeddedCacheManager;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(WeldJunit5Extension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class IspnTest {

    public static final int WAITTIME = 5000;
    @DSQualifier("testH2")
    @Inject
    DataSource ds;

    @Inject
    EmbeddedCacheManager cacheManager;


    public static final int ENTRIES_TO_CREATE = 10;
    public static final int ENTRIES_TO_CREATE_DURING_WAIT = 20;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        if (!TestTools.POSTGRES_INFINISPAN.isRunning()) {
            TestTools.POSTGRES_INFINISPAN.start();
        }
    }

    @AfterAll
    @SneakyThrows
    static void afterAll() {
        TestTools.POSTGRES_INFINISPAN.stop();
    }

    @SneakyThrows
    @Test
    void testDbConnection() {
        try (var conn = ds.getConnection();
             var stmt = conn.createStatement()) {
                stmt.execute("create table tablex (a varchar)");
                stmt.execute("insert into tablex (a) values ('test')");

            try (ResultSet rs = stmt.executeQuery("select * from tablex")) {
                assertTrue(rs.next());
            }
        }
    }

    @SneakyThrows
    @Test
    @Disabled
    public void canUseDerivedFromStringKeyedJdbcStoreByXml() {
        Cache<Object, String> cache = cacheManager.getCache("cache_derived");
        cache.put("key", "value");
        assertThat("value").isEqualTo(cache.get("key"));
        closeAndClear(cache);
    }

    @SneakyThrows
    @Test
    public void canUseStringKeyedJdbcStoreByXml() {
        Cache<Object, String> cache = cacheManager.getCache("cache_org");
        cache.put("key", "value");
        assertThat("value").isEqualTo(cache.get("key"));
        closeAndClear(cache);
    }

    @SneakyThrows
    @Test
    @Disabled
    void canExpireInDerivedFromStringKeyedJdbcStoreByXml() {
        testCacheExpiration("cache_derived");
    }

    @SneakyThrows
    @Test
    void canExpireInStringKeyedJdbcStoreByXml() {
        testCacheExpiration("cache_org");
        testCacheExpiration("cache_org_2");
    }

    @SneakyThrows
    @Test
    void canExpireIn2StringKeyedJdbcStoresByXml() {
        String cache1Name = "cache_org";
        Cache<Object, String> cache1 = initCache(cache1Name);
        String cache2Name = "cache_org_2";
        Cache<Object, String> cache2 = initCache(cache2Name);
        expireEntriesInDb(cache1Name);
        expireEntriesInDb(cache2Name);

        waitAndWorkCache(2500, cache1);
        waitAndWorkCache(2500, cache2);
        final var count1 = countEntriesInDb(cache1Name);
        assertThat(count1).isEqualTo(ENTRIES_TO_CREATE_DURING_WAIT);
        final var count2 = countEntriesInDb(cache2Name);
        assertThat(count2).isEqualTo(ENTRIES_TO_CREATE_DURING_WAIT);
        closeAndClear(cache1);
        closeAndClear(cache2);
    }


    private static void closeAndClear(Cache<Object, String> cache1) {
        cache1.clear();
        cache1.stop();
    }

    private void testCacheExpiration(String cacheName) throws SQLException {
        var cache = initCache(cacheName);
        expireEntriesInDb(cacheName);
        waitAndWorkCache(WAITTIME, cache);
        final var count = countEntriesInDb(cacheName);
        assertThat(count).isEqualTo(ENTRIES_TO_CREATE_DURING_WAIT);  // inserts where double this
        closeAndClear(cache);
        assertThat(cache.getStatus()).isEqualTo(ComponentStatus.TERMINATED);
    }


    private void waitAndWorkCache(int waittime, Cache<Object, String> cache) {
        final long start = System.currentTimeMillis();
        while (((System.currentTimeMillis() - start) < waittime) && (countEntriesInDb(cache.getName()) != ENTRIES_TO_CREATE_DURING_WAIT)) {
            assertThat(cache.getStatus()).isEqualTo(ComponentStatus.RUNNING);

            for (int i = ENTRIES_TO_CREATE; i < (ENTRIES_TO_CREATE + ENTRIES_TO_CREATE_DURING_WAIT); i++) {
                cache.put("key" + i, "value" + i);
                cache.get("key" + (i - ENTRIES_TO_CREATE));
            }
        }
    }

    private @NotNull Cache<Object, String> initCache(String cacheName) {
        Cache<Object, String> cache = cacheManager.getCache(cacheName);
        assertThat(cache.getStatus()).isEqualTo(ComponentStatus.RUNNING);
        for (int i = 0; i < ENTRIES_TO_CREATE; i++) {
            cache.put("key" + i, "value" + i);
        }

        for (int i = 0; i < ENTRIES_TO_CREATE; i++) {
            String v = cache.get("key" + i);
            assertThat(v).isEqualTo("value" + i);
        }
        var count = countEntriesInDb(cacheName);
        assertThat(count).isEqualTo(ENTRIES_TO_CREATE);
        assertThat(cache.getStatus()).isEqualTo(ComponentStatus.RUNNING);
        return cache;
    }

    private void expireEntriesInDb(String cacheName) throws SQLException {
        try (Connection conn = ds.getConnection()) {
            int res;
            try (Statement stmt = conn.createStatement()) {
                res = stmt.executeUpdate(String.format("update \"ispn_%s\" set ts = ts - 7200000", cacheName));
            }
            assertThat(res).isEqualTo(ENTRIES_TO_CREATE);
        }
    }

    @SneakyThrows
    private int countEntriesInDb(String cacheName) {
        var count = 0;
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(String.format("select id, data, ts, seg from \"ispn_%s\"", cacheName))) {
            while (rs.next()) {
                InputStream inputStream = rs.getBinaryStream(2);
                assertThat(inputStream.available()).isPositive();
                String keyStr = rs.getString(1);
                assertThat(keyStr).isNotNull();
                long timestamp = rs.getLong(3);
                assertThat(timestamp).isBetween(System.currentTimeMillis() - 10000000, System.currentTimeMillis() + 10000000);
                count++;
            }
        }
        return count;
    }

}
