package com.cubic.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.dao.inventory.CustomerDB;
import com.cubic.entity.CustomerEntity;
import com.cubic.entity.QueryConstants;
import com.cubic.rest.exception.CustomerNotFoundException;
import com.cubic.rest.exception.InvalidDataException;
import com.cubic.rest.vo.Customer;

@Service("jpaCS")
@Transactional
public class CustomerServiceJPAImpl implements CustomerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public String createCustomer(final Customer customer) {
		// new CustomerEntity();

		CustomerEntity entity = mapper.mapToCustomerEntity(new CustomerEntity(), customer);
		validateInfo(customer);
		em.persist(entity);
		return entity.getPk().toString();
	}

	@Override
	public void modifyCustomer(Customer customer) {
		// validateInfo(customer);
		// validateCustomerExists(customer.getId());
		CustomerEntity entity = em.find(CustomerEntity.class, new Long(customer.getId()));

		if (entity == null) {
			throw new CustomerNotFoundException("Customer Not Found in the data");
		}
		entity = mapper.mapToCustomerEntity(entity, customer);
		// return mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		// return entity.getPk().toString();
		// CustomerDB.get().update(customer);

	}

	@Override
	public void removeCustomer(final String id) {
		CustomerEntity entity = em.find(CustomerEntity.class, new Long(id));
		if (StringUtils.isEmpty(id)) {
			throw new InvalidDataException("Invalid Data. ID is either null or empty");
		}
		em.remove(entity);

	}

	@Override
	public Customer findCustomer(final String id) {
		validateId(id);

		CustomerEntity entity = em.find(CustomerEntity.class, new Long(id));

		if (entity == null) {
			throw new CustomerNotFoundException("Customer Not Found in the data");
		}
		// Customer customer = CustomerDB.get().find(id);
		// validateCustomerExists(id);
		return mapper.mapToCustomer(entity);

	}

	private void validateId(final String id) {
		if (StringUtils.isEmpty(id) || !id.trim().matches("\\d+")) {
			throw new InvalidDataException("Invalid ID to find the customer");
		}
	}

	@Override
	public List<Customer> searchCustomer(String firstName, String lastName) {
		// List<Customer> results = null;
		firstName = StringUtils.isEmpty(firstName) ? "%" : firstName.trim() + "%";
		lastName = StringUtils.isEmpty(lastName) ? "%" : lastName.trim() + "%";
		TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstants.CUSTOMER_SEARCH, CustomerEntity.class);
		query.setParameter(1, firstName);
		query.setParameter(2, lastName);
		List<CustomerEntity> searchResults = query.getResultList();
		return mapper.mapToCustomerList(searchResults);
		// return CustomerDB.get().search(firstName, lastName);
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
