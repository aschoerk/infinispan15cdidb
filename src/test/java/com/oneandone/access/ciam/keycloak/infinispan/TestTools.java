package com.oneandone.access.ciam.keycloak.infinispan;

import io.agroal.api.AgroalDataSource;
import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import io.agroal.api.security.NamePrincipal;
import io.agroal.api.security.SimplePassword;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import org.h2.jdbcx.JdbcDataSource;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@ApplicationScoped
public class TestTools {

    @DSQualifier("testH2")
    @Produces
    @Singleton
    public DataSource createDataSource() throws SQLException {
        AgroalDataSourceConfigurationSupplier dataSourceConfiguration = new AgroalDataSourceConfigurationSupplier()
                .connectionPoolConfiguration(cp -> cp
                        .connectionFactoryConfiguration(cf -> cf
                                .jdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;LOCK_MODE=3;DB_CLOSE_ON_EXIT=FALSE;TRACE_LEVEL_SYSTEM_OUT=0")
                                .connectionProviderClass(org.h2.Driver.class)
                                .principal(new NamePrincipal("sa"))
                                .credential(new SimplePassword(""))
                        )
                        .initialSize(5)
                        .minSize(5)
                        .maxSize(20)
                        .flushOnClose(false)
                        .enhancedLeakReport(true)
                );

        return AgroalDataSource.from(dataSourceConfiguration);
    }

    @Produces
    public EmbeddedCacheManager createCacheManager() throws IOException {
        return new DefaultCacheManager("infinispan-config.xml");
    }

}
