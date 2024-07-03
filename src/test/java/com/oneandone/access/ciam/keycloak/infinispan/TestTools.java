package com.oneandone.access.ciam.keycloak.infinispan;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.h2.jdbcx.JdbcDataSource;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.postgresql.ds.PGSimpleDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;
import java.io.IOException;

@ApplicationScoped
public class TestTools {
    static final DockerImageName compatiblePostgres = DockerImageName.parse("registry.1und1.cloud/mirror/library/postgres:14")
            .asCompatibleSubstituteFor("postgres:14.9-alpine3.18");

    static final PostgreSQLContainer<?> POSTGRES_INFINISPAN = new PostgreSQLContainer<>(compatiblePostgres)
            .withLogConsumer(outputFrame -> System.out.println("[Postgres Infinispan]: " + outputFrame.getUtf8StringWithoutLineEnding()));


    @DSQualifier("testPG")
    @Produces
    public DataSource createPGDataSource() {
        if (!POSTGRES_INFINISPAN.isRunning()) {
            POSTGRES_INFINISPAN.start();
        }
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setURL(POSTGRES_INFINISPAN.getJdbcUrl());
        ds.setUser(POSTGRES_INFINISPAN.getUsername());
        ds.setPassword(POSTGRES_INFINISPAN.getPassword());
        return ds;
    }

    @DSQualifier("testH2")
    @Produces
    public DataSource createH2DataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:infinispan;DB_CLOSE_DELAY=-1;TRACE_LEVEL_SYSTEM_OUT=0");
        ds.setUser("sa");
        ds.setPassword("");
        return ds;
    }

    @Produces
    public EmbeddedCacheManager createCacheManager() throws IOException {
        return new DefaultCacheManager("infinispan-config.xml");
    }

}
