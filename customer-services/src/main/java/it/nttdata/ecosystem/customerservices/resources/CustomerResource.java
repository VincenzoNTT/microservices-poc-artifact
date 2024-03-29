package it.nttdata.ecosystem.customerservices.resources;

import it.nttdata.ecosystem.customerservices.dtos.Customer;
import it.nttdata.ecosystem.customerservices.dtos.Customers;
import it.nttdata.ecosystem.customerservices.services.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/v1/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private static final Logger LOGGER = Logger.getLogger(CustomerResource.class.getName());

    @Inject
    private CustomerService customerService;

    @GET
    public Customers getAll() {
        return customerService.getAll();
    }

    @GET
    @Path("/{id}")
    public Customer getById(@PathParam("id") Long id) {
        LOGGER.log(Level.INFO, "Searching customer by id {0}", id);
        return customerService.getAll().getCustomers().stream()
                .filter(c -> id.equals(c.getId()))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }
}
