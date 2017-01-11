package com.cubic.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.entity.CustomerEntity;

@Service("ct")
@Transactional(propagation = Propagation.SUPPORTS)
public class ChildCustomerTransaction implements CustomerTransaction {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void createCustomer() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Child");
		entity.setLastName("Record");
		em.persist(entity);
	}

}
