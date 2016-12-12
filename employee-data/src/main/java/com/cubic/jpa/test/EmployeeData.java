package com.cubic.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.EmployeeEntity;

public class EmployeeData {

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
			EmployeeEntity entity = new EmployeeEntity();
			while (entity.getEditNum() != 8) {
				entity.menu();
				switch (entity.getEditNum()) {
				case 1:
					entity.addData();
					entity.setName(entity.getName());
					entity.setGender(entity.getGender());
					entity.setAge(entity.getAge());
					entity.setAddress(entity.getAddress());
					entity.setSalary(entity.getSalary());
					entity.setDepartment(entity.getDepartment());

					System.out.println("before persist = " + entity);
					em.persist(entity);
					System.out.println("After persist = " + entity);
					et.commit();
					break;
				case 2:
					entity.updateData();
					EmployeeEntity en = em.find(EmployeeEntity.class, new Long(entity.getPk()));
					en.setName(en.getName());
					en.setGender(en.getGender());
					en.setAge(en.getAge());
					en.setAddress(en.getAddress());
					en.setSalary(en.getSalary());
					en.setDepartment(en.getDepartment());
					em.persist(en);
					System.out.println("After persist = " + en);
					break;
				case 3:
					entity.removeData();
					EmployeeEntity enti = em.find(EmployeeEntity.class, new Long(entity.getPk()));
					System.out.println("Before persist = " + entity);
					em.remove(enti);
					et.commit();
					break;
				case 4:
					break;
				case 5:
					TypedQuery<EmployeeEntity> query = em.createQuery("select e from EmployeeEntity e",
							EmployeeEntity.class);
					List<EmployeeEntity> employees = query.getResultList();
					for (EmployeeEntity ent : employees) {
						System.out.println(ent);
					}
					break;
				case 6:
					System.out.println("Exit the Program");
					System.exit(0);
					et.commit();
					break;
				}
			}
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
