package com.ctli.it.library;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestEnvironment {
	Environment value() default Environment.E2E;
}
