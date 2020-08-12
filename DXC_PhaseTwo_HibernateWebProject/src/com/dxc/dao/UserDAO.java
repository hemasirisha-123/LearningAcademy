package com.dxc.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import com.dxc.models.HibernateUtil;
import com.dxc.models.User;

public class UserDAO {

	public void saveUser(User user) {
        Transaction transaction = null;
        try {
        	//Session session = HibernateUtil.getSessionFactory().openSession();
        	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        	 
        	Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
             transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	 public boolean validate(String userName, String password) {

	        Transaction transaction = null;
	        User user = null;
	        try {
	        	Session session = HibernateUtil.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
	                .uniqueResult();

	            if (user != null && user.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }

	}

