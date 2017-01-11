package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.rest.vo.Customer;
import com.cubic.rest.vo.CustomerSearchResult;
import com.cubic.service.CustomerService;

@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

// @Named
@Service
public class CustomerRest {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRest.class);

	// @Inject
	@Autowired // inject for Spring, Dependency injection
	@Qualifier("jpaCS")
	private CustomerService cs;

	@POST
	@Path("/create")
	/*
	 * @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 * 
	 * @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 */
	public Response createCustomer(final Customer customer) {
		logger.debug("Entering Customer.createCustomer");
		String pk = cs.createCustomer(customer);
		logger.info("Long ID={}", pk);
		customer.setId(pk);
		// customer.setId(UUID.randomUUID().toString()).setDesc("New Customer");
		ResponseBuilder rb = Response.ok().entity(customer);

		/*
		 * if (customer.getLastName().startsWith("J")) { rb =
		 * rb.type(MediaType.APPLICATION_XML); }
		 */
		logger.debug("Exiting Customer.createCustomer");
		return rb.build();
	}

	@PUT
	@Path("/modify")
	/*
	 * @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 * 
	 * @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	 */
	public Response modifyCustomer(final Customer customer) {
		logger.debug("Entering Customer.modifyCustomer");

		cs.modifyCustomer(customer);
		ResponseBuilder rb = Response.ok();
		logger.debug("Exiting Customer.modifyCustomer");

		return Response.noContent().build();
	}

	@GET
	@Path("/{id}")
	public Response findCustomer(@PathParam("id") final String pk) {
		logger.debug("Entering Customer.findCustomer");
		Customer result = cs.findCustomer(pk);
		logger.debug("Exiting Customer.findCustomer");

		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/remove/{id}")
	public Response removeCustomer(@PathParam("id") final String pk) {
		logger.debug("Entering Customer.removeCustomer");

		cs.removeCustomer(pk);
		logger.debug("Exiting Customer.removeCustomer");

		return Response.noContent().build();
	}

	@GET
	@Path("/search")
	public Response searchCustomer(@QueryParam("fName") final String firstName,
			@QueryParam("lName") final String lastName) {
		logger.debug("Entering Customer.searchCustomer");
		logger.info("Search Criteria: First Name={}, Last Name={}", firstName, lastName);

		List<Customer> searchResults = cs.searchCustomer(firstName, lastName);
		logger.info("Results Size={}", searchResults.size());

		logger.debug("Exiting Customer.searchCustomer");

		return Response.ok().entity(new CustomerSearchResult(searchResults)).build();
	}

	@GET
	@Path("/search/{searchStr}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response searchCustomer(@PathParam("searchStr") final String searchStr) {
		List<Customer> searchResults = cs.searchCustomer(searchStr, searchStr);

		return Response.ok().entity(new CustomerSearchResult(searchResults)).build();
	}

	@GET
	@Path("/msearch")
	public Response searchCustomerByMatrix(@MatrixParam("fName") final String firstName,
			@MatrixParam("lName") final String lastName) {
		List<Customer> searchResults = cs.searchCustomer(firstName, lastName);

		return Response.ok().entity(new CustomerSearchResult(searchResults)).build();
	}
}
