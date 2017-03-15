package com.niit.shoppingcart.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcart.dao.ChairDAO;
import com.niit.shoppingcart.model.Chair;
@Repository("chairDAO")
@Transactional
public class ChairDAOImpl implements ChairDAO
{
	private static final Logger logger = LoggerFactory.getLogger(ChairDAOImpl.class);
	@Autowired
    private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean addChair(Chair chair)
	{
		logger.debug("Starting of the method calling addChair");
		try 
	    {
		sessionFactory.getCurrentSession().saveOrUpdate(chair);
		logger.debug("Ending of the method addChair");
		return true;
	    } 
	    catch (HibernateException e) 
	     {
		e.printStackTrace();
		return false;
	     }		
	}
	@Transactional
	public boolean updateChair(Chair chair) 
	 {
		logger.debug("Starting of the method calling updateChair");
		try 
	    {
		sessionFactory.getCurrentSession().update(chair);
		logger.debug("Ending of the method addChair");
		return true;
	    } 
	    catch (HibernateException e) 
	     {
		e.printStackTrace();
		return false;
	     }		
	 }
	@Transactional
	public List getAllChairs()
	{
	logger.debug("Starting of the method calling getAllChairs");
	Session session=sessionFactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	List blist=session.createQuery("from Chair").list();
	tx.commit();
	
	logger.debug("End of the method getAllChairs");
	return blist;
}
	@Transactional
public Chair getSingleChair(int id)
	{
	logger.debug("Starting of the method getSingleChair");
	Session session=sessionFactory.openSession();
	Chair chair=(Chair)session.load(Chair.class, id);
	logger.debug("End of the method getSingleChair");
	return chair;
}

public void deleteChair(int id)
{
	logger.debug("Starting of the method deleteChair");
	Session session=sessionFactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	Chair chair=(Chair)session.load(Chair.class, id);
	session.delete(chair);
	tx.commit();	
	session.close();
	logger.debug("End of the method deleteChair");
		
}

}




