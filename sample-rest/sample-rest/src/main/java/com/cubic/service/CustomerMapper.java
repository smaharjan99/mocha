package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.entity.CustomerEntity;
import com.cubic.rest.vo.Customer;

@Component
public class CustomerMapper {

	public Customer mapToCustomer(final CustomerEntity entity) {
		Customer result = new Customer();
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setId(entity.getPk().toString());
		return result;
	}

	public CustomerEntity mapToCustomerEntity(final CustomerEntity entity, final Customer customer) {

		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		return entity;
	}

	public List<Customer> mapToCustomerList(final List<CustomerEntity> entities) {
		List<Customer> results = new ArrayList<Customer>();
		if (entities != null && !entities.isEmpty()) {
			for (CustomerEntity entity : entities) {
				results.add(mapToCustomer(entity));
			}
		}
		return results;

	}

}
