package com.cubic.service;

import java.util.List;

import com.cubic.rest.vo.Customer;

public interface CustomerService {

	String createCustomer(final Customer customer);

	void modifyCustomer(final Customer customer);

	void removeCustomer(final String id);

	Customer findCustomer(final String id);

	List<Customer> searchCustomer(final String firstName, final String lastName);

}
