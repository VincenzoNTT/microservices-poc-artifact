package it.nttdata.ecosystem.orderservices.dtos;

import java.util.List;

public class Orders {

    private Customer customer;

    private List<Order> orders;

    public Orders(Customer customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }
    
    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
