package it.nttdata.ecosystem.filters.enablers;

import org.springframework.context.annotation.Import;

import it.nttdata.ecosystem.filters.config.LoggingFiltersConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LoggingFiltersConfig.class)
public @interface EnableLoggingInfo {
}
