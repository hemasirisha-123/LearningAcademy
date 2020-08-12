package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.models.HibernateUtil;
import com.dxc.models.Subject;

public class SubjectDAO {
	public void updateSub(Subject user) {

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

	public void deleteSub(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			Subject user = session.get(Subject.class, id);
			session.remove(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

	public void insertSub(Subject user) {

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

	public List<Subject> selectAllSub() {

		List<Subject> users = null;
		List<Class> users1 = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			users = session.createCriteria(Subject.class).list();
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

	public Subject selectSub(int id) {

		Subject user = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			user = session.get(Subject.class, id);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		return user;
	}

}
