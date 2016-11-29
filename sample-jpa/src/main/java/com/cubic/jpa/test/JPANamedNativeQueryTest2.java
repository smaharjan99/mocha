package com.cubic.jpa.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPANamedNativeQueryTest2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();

			Query query = em.createNamedQuery(QueryConstants.CUSTOMER_NATIVE_SELECT_NAME);
			// TypedQuery<Object[]> query = (TypedQuery<Object[]>)
			// em.createNamedQuery(QueryConstants.CUSTOMER_NATIVE_SELECT_NAME);

			@SuppressWarnings("unchecked")
			List<Object[]> results = query.getResultList();

			for (Object[] eachRow : results) {
				BigDecimal pk = (BigDecimal) eachRow[0];
				String firstName = (String) eachRow[1];
				System.out.println(pk + "==> " + firstName);

			}

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
