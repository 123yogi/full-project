package com.niit.shoppingcart.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;



@Repository("userDAO")
@Component
@Transactional
public class UserDAOImpl implements UserDAO
{
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
@Autowired
private SessionFactory sessionFactory;


public UserDAOImpl(SessionFactory sessionFactory)
{
	
	try 
	{
		this.sessionFactory = sessionFactory;
		logger.info(" The connection is established properly..");
	} catch (Exception e) 
	{
		logger.error("Not able to prepare connection.  Please check application" + "context java file");
		e.printStackTrace();
	}

}

public UserDAOImpl() 
{
	
}

@Transactional
public boolean saveUser(User user) 
{
	logger.debug("Starting of the method saveUser");
	try {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		logger.debug("Ending of the method : saveUser ");
		return true;
	} catch (HibernateException e) 
	{
		e.printStackTrace();
		return false;
	}
	
	}
			

}
	