package com.cubic.dao.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.util.StringUtils;

import com.cubic.rest.vo.Customer;

public class CustomerDB {

	private final static CustomerDB instance = new CustomerDB();

	private Map<String, Customer> customerDB = new HashMap<String, Customer>();

	private CustomerDB() {
	}

	public static CustomerDB get() {
		return instance;
	}

	public String add(final Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		customerDB.put(customer.getId(), customer);
		return customer.getId();
	}

	public void update(final Customer customer) {
		Customer existing = customerDB.get(customer.getId());
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setDesc(customer.getDesc());
		// return null;

	}

	public void remove(final String id) {
		customerDB.remove(id);
	}

	public Customer find(final String id) {
		return customerDB.get(id);
	}

	public List<Customer> search(String firstName, String lastName) {
		firstName = (firstName == null) ? "" : firstName.trim().toLowerCase();
		lastName = (lastName == null) ? "" : lastName.trim().toLowerCase();
		List<Customer> results = new ArrayList<Customer>();
		for (Customer cust : customerDB.values()) {
			if (matches(firstName, cust.getFirstName()) || matches(lastName,
					cust.getLastName()))/*
										 * (cust.getFirstName().toLowerCase().
										 * startsWith(firstName) ||
										 * cust.getLastName().toLowerCase().
										 * startsWith(lastName))
										 */ {
				results.add(cust);
			}
		}
		return results;
	}

	private Boolean matches(String searchStr, final String name) {
		boolean flag = (!StringUtils.isEmpty(searchStr));
		return (flag && name.trim().toLowerCase().startsWith(searchStr));
	}

}
