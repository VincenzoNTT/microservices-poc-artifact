package it.nttdata.ecosystem.supplierservices.dtos;

import java.util.List;

public class Suppliers {

    private Order order;

    private List<Supplier> suppliers;

    public Suppliers(Order order, List<Supplier> suppliers) {
        this.order = order;
        this.suppliers = suppliers;
    }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}   
}
