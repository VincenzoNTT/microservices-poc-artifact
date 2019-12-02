package it.nttdata.ecosystem.orderservices.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.nttdata.ecosystem.orderservices.dtos.Customer;

@FeignClient(value = "customer-services", qualifier = "customerResource", fallback = CustomerResource.CustomerResourceFallback.class)
public interface CustomerResource {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/customers/{id}")
    Customer getCustomer(@PathVariable("id") Long id);

    @Service
    @RefreshScope
    class CustomerResourceFallback implements CustomerResource {

        @Value("${fallback.customer.id}")
        private Long fallbackCustomerId;

        @Override
        public Customer getCustomer(Long id) {
            Customer customer = new Customer();
            customer.setId(fallbackCustomerId);
            return customer;
        }
    }
}
