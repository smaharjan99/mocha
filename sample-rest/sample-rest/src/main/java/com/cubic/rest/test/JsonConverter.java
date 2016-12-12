package com.cubic.rest.test;

import java.beans.XMLEncoder;

import org.codehaus.jackson.map.ObjectMapper;

import com.cubic.rest.vo.Customer;

public class JsonConverter {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Customer cust = new Customer();
		cust.setFirstName("John");
		cust.setLastName("Steinbeck");

		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(cust));

		new XMLEncoder(System.out).writeObject(cust);
	}
}
