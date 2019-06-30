package com.sutiboot;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sutiboot.domain.Department;
import com.sutiboot.domain.Employee;
import com.sutiboot.util.HibernateUtil;

public class MainTest {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Employee employee1 = new Employee();
			employee1.setName("Balram");
			employee1.setDisignation("Manager");

			Employee employee2 = new Employee();
			employee2.setName("Nandini");
			employee2.setDisignation("Software Engineer");

			Employee employee3 = new Employee();
			employee3.setName("Mounika");
			employee3.setDisignation("Associate  Engineer");

			Department department = new Department();
			department.setDepartmentName("IT Department");
			department.getEmployees().add(employee1);
			department.getEmployees().add(employee2);
			department.getEmployees().add(employee3);

			session.persist(department);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtil.shutdown();
	}
}
