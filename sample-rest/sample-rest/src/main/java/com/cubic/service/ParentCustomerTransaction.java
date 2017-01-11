package com.cubic.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;

@Service("pt")
@Transactional(propagation = Propagation.SUPPORTS)
public class ParentCustomerTransaction implements CustomerTransaction {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	@Qualifier("ct")
	private CustomerTransaction childService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void createCustomer() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Parent");
		entity.setLastName("Record");
		em.persist(entity);

		childService.createCustomer();
		// throw new RuntimeException("transaction Exception");
	}

}
