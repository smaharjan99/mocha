package com.cubic.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.rest.vo.Product;
import com.cubic.rest.vo.ProductAllResult;
import com.cubic.rest.vo.ProductSearchResult;
import com.cubic.service.ProductService;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Service
public class ProductRest {

	@Autowired
	@Qualifier("jpaPS")
	private ProductService ps;

	@POST
	@Path("/create")
	public Response createProduct(final Product product) {
		String pk = ps.createProduct(product);
		product.setId(pk);
		ResponseBuilder rb = Response.ok().entity(product);
		return rb.build();/*
							 * header("Access-Control-Allow-Origin", "*")
							 * .header("Access-Control-Allow-Methods", "POST")
							 * .header("Access-Control-Allow-Headers",
							 * "Content-Type").build();
							 */
	}

	@GET
	@Path("/all")
	public Response allProduct() {
		List<Product> allResults = ps.allProduct();
		return Response.ok().entity(new ProductAllResult(allResults))
				.build();/*
							 * .header("Access-Control-Allow-Origin", "*")
							 * .header("Access-Control-Allow-Methods",
							 * "GET").header("Access-Control-Allow-Headers",
							 * "Content-Type") .build();
							 */

	}

	@GET
	@Path("/{id}")
	public Response findProduct(@PathParam("id") final String pk) {
		Product result = ps.findProduct(pk);
		return Response.ok().entity(result).build();// .header("Access-Control-Allow-Origin",
													// "*")
		// .header("Access-Control-Allow-Methods",
		// "GET").header("Access-Control-Allow-Headers", "Content-Type")
		// .build();
	}

	/*
	 * @GET
	 * 
	 * @Path("/{upc}") public Response findProductUPC(@PathParam("upc") final
	 * String upc) { List<Product> upcResult = ps.findProductUPC(upc); return
	 * Response.ok().entity(new
	 * ProductUpcResult(upcResult)).header("Access-Control-Allow-Origin", "*")
	 * .header("Access-Control-Allow-Methods",
	 * "GET").header("Access-Control-Allow-Headers", "Content-Type") .build(); }
	 */
	@PUT
	@Path("/modify")
	public Response modifyProduct(final Product product) {
		ps.modifyProduct(product);
		return Response.noContent().build();// .header("Access-Control-Allow-Origin",
											// "*")
		// .header("Access-Control-Allow-Methods",
		// "PUT").header("Access-Control-Allow-Headers", "Content-Type")
		// .build();
	}

	@DELETE
	@Path("/remove/{id}")
	public Response removeProduct(@PathParam("id") final String pk) {
		ps.removeProduct(pk);
		return Response.noContent()
				.build();/*
							 * .header("Access-Control-Allow-Origin", "*")
							 * .header("Access-Control-Allow-Methods",
							 * "DELETE").header("Access-Control-Allow-Headers",
							 * "Content-Type") .build();
							 */
	}

	@GET
	@Path("/search")
	public Response searchProduct(@QueryParam("pName") final String productName) {
		List<Product> searchResults = ps.searchProduct(productName);
		return Response.ok().entity(new ProductSearchResult(searchResults))
				.build();/*
							 * .header("Access-Control-Allow-Origin", "*")
							 * .header("Access-Control-Allow-Methods",
							 * "GET").header("Access-Control-Allow-Headers",
							 * "Content-Type") .build();
							 */
	}

}
