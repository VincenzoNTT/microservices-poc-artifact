package it.codingjam.supplierservices.resources;

import it.codingjam.supplierservices.dtos.Suppliers;
import it.codingjam.supplierservices.services.SupplierService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/v1/orders/{id}/suppliers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SupplierResource {

    private static final Logger LOGGER = Logger.getLogger(SupplierResource.class.getName());

    @Inject
    private SupplierService orderService;

    @GET
    public Response getOrders(@PathParam("id") Long orderId) {
        LOGGER.log(Level.INFO, "Searching supplier for order id {0}", orderId);
        Suppliers supplierOrders = orderService.getOrderSupplier(orderId);
        return Response.ok(supplierOrders).build();
    }

    @GET
    @Path("/exception")
    public Response generateException(@PathParam("id") Long customerId) {
        throw new IllegalArgumentException("Example stacktrace for ELK");
    }
}
