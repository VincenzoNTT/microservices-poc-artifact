package it.nttdata.ecosystem.supplierservices;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import it.nttdata.ecosystem.supplierservices.resources.SupplierResource;

@ServletComponentScan
@EnableFeignClients
@SpringBootApplication
public class SupplierServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierServicesApplication.class, args);
    }

    @Bean
    public ResourceConfig resourceConfig() {
        return new ResourceConfig() {{
            packages(SupplierResource.class.getPackage().getName());
            register(LoggingFeature.class);
        }};
    }
}
