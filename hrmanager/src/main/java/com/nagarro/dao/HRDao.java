package com.nagarro.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.models.HRModel;

public class HRDao
{
	public HRModel authentication(String userId,String password)
	{
		HRModel user=null;
		Configuration con = new Configuration().configure().addAnnotatedClass(HRModel.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction t=session.beginTransaction();
    	try
    	{
    		Query q=session.createQuery("from HRModel where userId=:userId and password=:password");
    		q.setParameter("userId",userId);
    		q.setParameter("password",password);
    		user=(HRModel)q.uniqueResult();
    	}
    	catch(HibernateException e)
    	{
    		user=null;
    		System.out.println(e.getMessage());
    	}
    	return user;
	}
}