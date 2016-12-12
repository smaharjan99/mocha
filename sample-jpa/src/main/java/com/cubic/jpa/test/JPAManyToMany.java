package com.cubic.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CourseEntity;
import com.cubic.jpa.entity.StudentEntity;

public class JPAManyToMany {

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

			StudentEntity student1 = new StudentEntity();
			student1.setStdName("Jim");
			StudentEntity student2 = new StudentEntity();
			student2.setStdName("Dwight");
			CourseEntity course1 = new CourseEntity();
			course1.setCorName("Sales");
			CourseEntity course2 = new CourseEntity();
			course2.setCorName("Marketing");

			student1.getCourses().add(course1);
			student1.getCourses().add(course2);
			student2.getCourses().add(course2);

			course1.getStudents().add(student1);
			course2.getStudents().add(student1);
			course2.getStudents().add(student2);

			em.persist(student1);

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
