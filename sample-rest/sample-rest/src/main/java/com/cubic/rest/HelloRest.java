package com.cubic.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/helloworld")
public class HelloRest {

	@GET
	public String hello() {
		return "Come join us!!";
	}
}
