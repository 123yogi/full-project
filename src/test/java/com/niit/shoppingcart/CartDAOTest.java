package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.CartItem;
import com.niit.shoppingcart.model.Category;

public class CartDAOTest 
{
	@Autowired
    static CartDAO cartDAO;
	@Autowired
	static CartItem cartItem;
	@Autowired
	static	AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		cartItem=(CartItem)context.getBean("cartItem");
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	
	@Test
	public void testAdd() 
	{
		//cartItem.setCartItemId(900);
		cartItem.setChairId(202);
		cartItem.setChairName("nil kamal4");
		cartItem.setChairPrice(9000);
		cartItem.setChairStyle("modern");
		cartItem.setQuantity(1);
		cartItem.setChairDesc("good");
		Assert.assertEquals("save Test Case",true,cartDAO.add(cartItem));
	}

	@Test
	public void testGet() 
	{
		cartItem=cartDAO.get(32);//cartitemid
		int idNo=cartItem.getChairId();
		Assert.assertEquals("cart test case",10, idNo);//10 chairid
		
	}

	@Test
	public void testGetAllItems()
	{
		Assert.assertEquals("listCart" , 8,cartDAO.getAllItems().size());
	}

	

//	@Test
//	public void testRemove() 
//	{
//		cartDAO.remove(17);
//		
//	}

//	@Test
//	public void testRemoveAll() 
//	{
//		cartDAO.removeAll();
//	}

	
}
