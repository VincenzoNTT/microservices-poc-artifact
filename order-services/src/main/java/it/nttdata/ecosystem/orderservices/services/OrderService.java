package it.nttdata.ecosystem.orderservices.services;

import it.nttdata.ecosystem.orderservices.clients.CustomerResource;
import it.nttdata.ecosystem.orderservices.dtos.Customer;
import it.nttdata.ecosystem.orderservices.dtos.Order;
import it.nttdata.ecosystem.orderservices.dtos.Orders;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private Map<Long, List<Order>> data = new HashMap<>();

    public OrderService() {
        data.put(1L, Collections.singletonList(newOrder(1234, 1)));
        data.put(2L, Collections.singletonList(newOrder(5433, 2)));
        data.put(3L, Collections.singletonList(newOrder(1234, 2)));
        data.put(3L, Collections.singletonList(newOrder(5433, 1)));
    }

    @Inject
    @Named("customerResource")
    private CustomerResource customerResource;

    public Orders getCustomerOrders(Long customerId) {
        Customer customer = customerResource.getCustomer(customerId);
        return new Orders(customer, data.get(customer.getId()));
    }

    private Order newOrder(int article, int quantity) {
        Order order = new Order();
        order.setArticleCode(article);
        order.setQuantity(quantity);
        return order;
    }
}
