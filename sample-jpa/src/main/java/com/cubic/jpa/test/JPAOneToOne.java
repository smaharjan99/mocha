package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerDetailEntity;
import com.cubic.jpa.entity.CustomerEntity;

public class JPAOneToOne {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			System.out.println("connected");
			CustomerEntity entity = createCustomer();
			CustomerDetailEntity customerInfo = createCustomerInfo();
			entity.setCustomerInfo(customerInfo);
			customerInfo.setCust(entity);
			System.out.println("Before persist = " + entity);
			em.persist(entity);
			System.out.println("After persist = " + entity);

			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.setRollbackOnly();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}

	private static CustomerEntity createCustomer() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Jack");
		entity.setLastName("sparrow");

		return entity;
	}

	private static CustomerDetailEntity createCustomerInfo() {
		CustomerDetailEntity detail = new CustomerDetailEntity();
		detail.setDescription("This is not right");
		return detail;

	}
}
