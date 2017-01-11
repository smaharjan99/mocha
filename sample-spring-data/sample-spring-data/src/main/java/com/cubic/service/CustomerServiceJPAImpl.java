package com.cubic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cubic.entity.AddressEntity;
import com.cubic.entity.CustomerEntity;
import com.cubic.repo.CustomerRepo;
import com.cubic.rest.exception.CustomerNotFoundException;
import com.cubic.rest.exception.InvalidDataException;
import com.cubic.rest.vo.Customer;

@Service
@Transactional
public class CustomerServiceJPAImpl implements CustomerService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(CustomerServiceJPAImpl.class);

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private CustomerMapper mapper;

	public String createCustomer(final Customer customer) {
		CustomerEntity entity = mapper.mapToCustomerEntity(new CustomerEntity(), customer);
		validateInfo(customer);
		entity = repo.save(entity);
		return entity.getPk().toString();
	}

	public void modifyCustomer(Customer customer) {
		validateId(customer.getId());
		CustomerEntity entity = repo.findOne(new Long(customer.getId()));
		if (entity != null) {
			entity = mapper.mapToCustomerEntity(entity, customer);
			entity = repo.save(entity);
		} else {
			throw new CustomerNotFoundException("Customer Not Found in the data");
		}
	}

	public void removeCustomer(final String id) {
		validateId(id);
		repo.delete(new Long(id));
	}

	public Customer findCustomer(final String id) {
		// logger.debug("Entering CusteomerServicePAImpl.findCustomer");
		validateId(id);

		CustomerEntity entity = repo.findOne(new Long(id));

		if (entity == null) {
			throw new CustomerNotFoundException("Customer Not Found in the data");
		}
		List<AddressEntity> customerAddr = entity.getAddressList();
		if (customerAddr != null) {
			for (AddressEntity addr : customerAddr) {

			}
		}
		// Customer customer = CustomerDB.get().find(id);
		// validateCustomerExists(id);
		return mapper.mapToCustomer(entity);

	}
	/*
	 * public Customer findCustomer(final String id) { // logger.debug(
	 * "Entering CusteomerServicePAImpl.findCustomer"); validateId(id);
	 * 
	 * CustomerEntity entity = repo.findOne(new Long(id));
	 * 
	 * if (entity == null) { throw new CustomerNotFoundException(
	 * "Customer Not Found in the data"); }
	 * 
	 * // Customer customer = CustomerDB.get().find(id); //
	 * validateCustomerExists(id); return mapper.mapToCustomer(entity);
	 * 
	 * }
	 */

	private void validateId(final String id) {
		if (StringUtils.isEmpty(id) || !id.trim().matches("\\d+")) {
			throw new InvalidDataException("Invalid ID to find the customer");
		}
	}

	public List<Customer> searchCustomer(String firstName, String lastName) {
		firstName = StringUtils.isEmpty(firstName) ? "%" : firstName.trim() + "%";
		lastName = StringUtils.isEmpty(lastName) ? "%" : lastName.trim() + "%";
		List<CustomerEntity> results = repo.searchCustomer(firstName, lastName);
		return mapper.mapToCustomerList(results);

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
		/*
		 * Customer customer = CustomerDB.get().find(id); if (customer == null)
		 * { throw new CustomerNotFoundException(
		 * "Customer not found in the system"); }
		 */

	}

}
