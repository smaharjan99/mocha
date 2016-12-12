package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.AddressEntity;
import com.cubic.jpa.entity.CustomerEntity;

public class JPAOneToMany {

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
			AddressEntity addr1 = addAddress();
			AddressEntity addr2 = addAddress2();

			entity.getAddressList().add(addr1);
			entity.getAddressList().add(addr2);
			addr1.setCustomer(entity);
			addr2.setCustomer(entity);
			System.out.println("Before persist = " + entity);
			em.persist(entity);
			et.commit();
			System.out.println("After persist = " + entity);

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

	private static AddressEntity addAddress() {
		AddressEntity addr1 = new AddressEntity();
		addr1.setStreet("3001 space dr");
		addr1.setCity("Irving");
		addr1.setState("TX");
		addr1.setZipcode("75038");
		return addr1;

	}

	private static AddressEntity addAddress2() {
		AddressEntity addr2 = new AddressEntity();
		addr2.setStreet("3121 Wak rd");
		addr2.setCity("Dallas");
		addr2.setState("TX");
		addr2.setZipcode("75210");
		return addr2;

	}

	private static CustomerEntity createCustomer() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Happy");
		entity.setLastName("Madison");
		return entity;
	}

}
