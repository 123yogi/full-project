package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

public class CategoryDAOTest 
{
	@Autowired
    static CategoryDAO categoryDAO;
	@Autowired
	static Category category;	
	@Autowired
	 static Supplier supplier;	
	@Autowired
	static	AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		category=(Category)context.getBean("category");
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	@Test
	public void testSaveOrUpdate() 
	{
		category.setId(5);
		category.setName("round doors1");
		category.setDescription("good");
		categoryDAO.saveOrUpdate(category);
	}

	@Test
	public void testList() 
	{
		Assert.assertEquals("listCategory" , 4,categoryDAO.list().size());
	}

	@Test
	public void testUpdate()
	{
		category.setId(5);
		category.setName("round tables");
		category.setDescription("good");
		categoryDAO.updateCategory(category);
		
	}

	@Test
	public void testGet() 
	{
		category=categoryDAO.get(5);
		int idNo=category.getId();
		Assert.assertEquals("category test case",5,idNo);
	}

//	@Test
//	public void testDelete() 
//	{
//		categoryDAO.deleteCategory("246");
//	}

}
