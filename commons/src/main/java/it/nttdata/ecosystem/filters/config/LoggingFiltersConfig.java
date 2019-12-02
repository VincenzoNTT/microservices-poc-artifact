package it.nttdata.ecosystem.filters.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import it.nttdata.ecosystem.filters.mdc.PrincipalLoggerFilter;
import it.nttdata.ecosystem.filters.mdc.RequestRemoteIpLoggerFilter;
import it.nttdata.ecosystem.filters.mdc.UriMetricsLoggerFilter;

import javax.servlet.Filter;

public class LoggingFiltersConfig {

    @Bean
    public FilterRegistrationBean principalLoggerFilter() {
        return getFilterRegistrationBean(new PrincipalLoggerFilter(), 1);
    }

    @Bean
    public FilterRegistrationBean requestRemoteIpLoggerFilter() {
        return getFilterRegistrationBean(new RequestRemoteIpLoggerFilter(), 2);
    }

    @Bean
    public FilterRegistrationBean uriMetricsLoggerFilter() {
        return getFilterRegistrationBean(new UriMetricsLoggerFilter(), 3);
    }

    private FilterRegistrationBean getFilterRegistrationBean(Filter filter, int order) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setOrder(order);
        registration.setFilter(filter);
        return registration;
    }
}
