package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;

public class JPASampleQueryTest2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		// EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			TypedQuery<CustomerEntity> query = em.createQuery("select c from CustomerEntity c where c.pk=?",
					CustomerEntity.class);
			query.setParameter(1, new Long(1004));
			CustomerEntity entity = query.getSingleResult();
			System.out.println(entity);

			/*
			 * List<CustomerEntity> customers = query.getResultList(); for
			 * (CustomerEntity entity : customers) { System.out.println(entity);
			 * }
			 */

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
