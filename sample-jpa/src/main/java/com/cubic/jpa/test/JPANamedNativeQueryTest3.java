package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPANamedNativeQueryTest3 {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();

			Query query = em.createNamedQuery(QueryConstants.CUSTOMER_COUNT);
			Long result = (Long) query.getSingleResult();

			// System.out.println(result.getClass().getName());
			System.out.println(result);

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
