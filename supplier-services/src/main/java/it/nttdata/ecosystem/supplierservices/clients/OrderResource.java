package it.codingjam.supplierservices.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.codingjam.supplierservices.dtos.Order;

@FeignClient(value = "order-services", qualifier = "orderResource", fallback = OrderResource.OrderResourceFallback.class)
public interface OrderResource {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/order/{id}")
    Order getOrder(@PathVariable("id") Long id);

    @Service
    @RefreshScope
    class OrderResourceFallback implements OrderResource {

        @Value("${fallback.order.id}")
        private int fallbackOrderId;

        @Override
        public Order getOrder(Long id) {
        	Order order = new Order();
            order.setArticleCode(fallbackOrderId);
            return order;
        }
    }
}
