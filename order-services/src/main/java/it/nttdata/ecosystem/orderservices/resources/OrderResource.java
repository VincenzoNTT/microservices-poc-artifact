package it.nttdata.ecosystem.orderservices.resources;

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

import it.nttdata.ecosystem.orderservices.dtos.Orders;
import it.nttdata.ecosystem.orderservices.services.OrderService;

@Path("/v1/customers/{id}/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    private static final Logger LOGGER = Logger.getLogger(OrderResource.class.getName());

    @Inject
    private OrderService orderService;

    @GET
    public Response getOrders(@PathParam("id") Long customerId) {
        LOGGER.log(Level.INFO, "Searching orders for customer id {0}", customerId);
        Orders customerOrders = orderService.getCustomerOrders(customerId);
        return Response.ok(customerOrders).build();
    }
    
    
    
    @GET
    @Path("/exception")
    public Response generateException(@PathParam("id") Long customerId) {
        throw new IllegalArgumentException("Example stacktrace for ELK");
    }
}
