package com.cubic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.dao.inventory.CustomerDB;
import com.cubic.rest.exception.CustomerNotFoundException;
import com.cubic.rest.exception.InvalidDataException;
import com.cubic.rest.vo.Customer;

@Service("InMemoryCS")
public class CustomerServiceInMemoryImpl implements CustomerService {

	@Override
	public String createCustomer(final Customer customer) {
		validateInfo(customer);
		return CustomerDB.get().add(customer);

	}

	@Override
	public void modifyCustomer(Customer customer) {
		validateInfo(customer);
		validateCustomerExists(customer.getId());
		CustomerDB.get().update(customer);

	}

	@Override
	public void removeCustomer(final String id) {
		if (StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Invalid Data. ID is either null or empty");
		}
		CustomerDB.get().remove(id);

	}

	@Override
	public Customer findCustomer(final String id) {
		Customer customer = CustomerDB.get().find(id);

		validateCustomerExists(id);

		return customer;

	}

	@Override
	public List<Customer> searchCustomer(String firstName, String lastName) {
		return CustomerDB.get().search(firstName, lastName);
	}

	private void validateInfo(final Customer customer) {
		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Invalid data in the system");
		}
	}

	private void validateCustomerExists(final String id) {
		if (StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Invalid data in the system");
			// throw new IllegalArgumentException("Invalid data in the system");
		}
		Customer customer = CustomerDB.get().find(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found in the system");
		}

	}

}
