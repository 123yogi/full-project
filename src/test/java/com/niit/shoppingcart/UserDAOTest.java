package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

public class UserDAOTest 
{
	@Autowired
	 static UserDAO userDAO;
	@Autowired
	 static User user;
	@Autowired
	 static Login login;
	@Autowired
	static	AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		login=(Login)context.getBean("login");
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}

	@Test
	public void testSaveorUpdate()
	{
		user.setId(14);
		user.setName("harish");
		user.setPassword("harish123");
		user.setConfirmpassword("harish123");
		user.setMail("harish.g@gmail.com");
		user.setPhone("9090909090");
		user.setStreetName("bhagat nagar");
		user.setApartmentNumber("8-90");
		user.setCity("hyd");
		user.setCountry("india");
		user.setZipCode("509886");
		user.setState("telangana");
		user.setEnabled(true);
		Assert.assertEquals("save Test Case",true,userDAO.saveUser(user));
	}

	@Test
	public void testSave()
	{
	login.setId(10);
	login.setUsername("subbu");
	login.setPassword("subbu");
	login.setRole("ROLE_USER");
	login.setStatus(true);
	userDAO.save(login);
		
	}
}

