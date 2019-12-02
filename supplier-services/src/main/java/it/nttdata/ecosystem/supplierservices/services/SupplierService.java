package it.nttdata.ecosystem.supplierservices.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import it.nttdata.ecosystem.supplierservices.clients.OrderResource;
import it.nttdata.ecosystem.supplierservices.dtos.Order;
import it.nttdata.ecosystem.supplierservices.dtos.Supplier;
import it.nttdata.ecosystem.supplierservices.dtos.Suppliers;

@Service
public class SupplierService {

    private Map<Integer, List<Supplier>> data = new HashMap<>();

    public SupplierService() {
        data.put(1234, Collections.singletonList(newSupplier(1234, "Motorola")));
        data.put(5433, Collections.singletonList(newSupplier(5433, "Coca Cola")));
        data.put(1234, Collections.singletonList(newSupplier(1234, "Apple")));
    }

    @Inject
    @Named("orderResource")
    private OrderResource orderResource;

    public Suppliers getOrderSupplier(Long orderId) {
        Order order = orderResource.getOrder(orderId);
        return new Suppliers(order, data.get(order.getArticleCode()));
    }

    private Supplier newSupplier(int articleCode, String name) {
        Supplier supplier = new Supplier();
        supplier.setArticleCode(articleCode);
        supplier.setName(name);
        return supplier;
    }
}
