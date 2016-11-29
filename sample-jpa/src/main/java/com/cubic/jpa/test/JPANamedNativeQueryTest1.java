package com.cubic.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;

public class JPANamedNativeQueryTest1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstants.CUSTOMER_NATIVE_ALL,
					CustomerEntity.class);

			List<CustomerEntity> results = query.getResultList();

			for (CustomerEntity entity : results) {
				System.out.println(entity);
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
