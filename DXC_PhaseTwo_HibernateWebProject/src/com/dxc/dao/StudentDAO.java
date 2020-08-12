package com.dxc.dao;

import java.io.IOException;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.models.HibernateUtil;
import com.dxc.models.Student;
import com.dxc.models.User;


public class StudentDAO {
	public void updateStudent(Student user) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}

	}

	public void deleteStudent(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Student user = session.get(Student.class, id);
			session.remove(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

	public void insertStudent(Student user) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

	public List<Student> selectAllStudent() {

		List<Student> users = null;
		List<Class> users1 = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
		    users = session.createCriteria(Student.class).list();
			users1.getClass();
			System.out.println(users1);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		return users;
	}

	public Student selectStudent(int id) {

		Student user = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			user = session.get(Student.class, id);
		    transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		return user;
	}

}
