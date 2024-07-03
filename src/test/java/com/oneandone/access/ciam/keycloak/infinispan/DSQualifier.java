package com.oneandone.access.ciam.keycloak.infinispan;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

import java.io.Serial;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface DSQualifier {
    String value();

    public static class DSQualifierLiteral
            extends AnnotationLiteral<DSQualifier> implements DSQualifier {
        @Serial
        private static final long serialVersionUID = -2602080452490638021L;
        private String name;

        public DSQualifierLiteral(String name) {
            this.name = name;
        }

        public String value() {
            return this.name;
        }
    }
}
