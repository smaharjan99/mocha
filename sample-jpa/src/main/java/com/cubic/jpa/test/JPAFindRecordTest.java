package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPAFindRecordTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			CustomerEntity entity = em.find(CustomerEntity.class, new Long(1002));
			System.out.println(entity);
			System.out.println("connected");

		} catch (Exception e) {

			e.printStackTrace();
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
