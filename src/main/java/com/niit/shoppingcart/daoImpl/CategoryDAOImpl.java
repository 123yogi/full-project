package com.niit.shoppingcart.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Chair;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	
	@Autowired
    SessionFactory sessionFactory;
		
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() 
	{
		logger.debug("Starting of the method calling list");
		@SuppressWarnings("unchecked")
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Category> listCategory = (List<Category>) 
		          session.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		     tx.commit();
		     logger.debug("End of the method calling list");
			return listCategory;
	}

		
	@Transactional
	public boolean saveOrUpdate(Category category) 
	{
		logger.debug("Starting of the method saveOrUpdate");		
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean updateCategory(Category category) 
	{
		logger.debug("Starting of the method update");
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	
	@Transactional
	public Category get(int id) 
	{
		logger.debug("Starting of the method get");
		Session session=sessionFactory.openSession();
		Category category=(Category)session.load(Category.class,id);
		logger.debug("End of the method get");
		return category;
	}
	
	@Transactional
	public boolean deleteCategory(String id) 
	{
		logger.debug("Starting of the method delete");
		Category CategoryToDelete = new Category();
		int idNo=Integer.parseInt(id);
		CategoryToDelete.setId(idNo);
		try 
		    {
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
			return true;
			} 
		catch (Exception e) 
		    {
			e.printStackTrace();
			logger.error("Exception occured while saving category");
			logger.error(e.getMessage());
			return false;
		    }
	 }
}