package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPAUpdateRecordTest {

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
			CustomerEntity entity = em.find(CustomerEntity.class, new Long(1002));
			System.out.println("Before persist = " + entity);
			entity.setLastName("McCartney");
			entity.setFirstName("Paul");
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

}
