package it.nttdata.ecosystem.supplierservices.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.nttdata.ecosystem.supplierservices.dtos.Suppliers;
import it.nttdata.ecosystem.supplierservices.services.SupplierService;

@Path("/v1/orders/{id}/suppliers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SupplierResource {

	private static final Logger LOGGER = Logger.getLogger(SupplierResource.class.getName());

	@Inject
	private SupplierService supplierService;

	@GET
	public Response getOrders(@PathParam("id") Long orderId) {
		LOGGER.log(Level.INFO, "Searching supplier for order id {0}", orderId);
		Suppliers supplierOrders = supplierService.getOrderSupplier(orderId);
		return Response.ok(supplierOrders).build();
	}

	@GET
	@Path("/exception")
	public Response generateException(@PathParam("id") Long customerId) {
		throw new IllegalArgumentException("Example stacktrace for ELK");
	}
}
