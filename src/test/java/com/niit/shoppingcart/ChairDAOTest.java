package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ChairDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Chair;
import com.niit.shoppingcart.model.Supplier;

public class ChairDAOTest 
{
	@Autowired
    static ChairDAO chairDAO;
	@Autowired
	static Chair chair;	
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
		
		chair=(Chair)context.getBean("chair");
		supplier=(Supplier)context.getBean("supplier");
		
		category=(Category)context.getBean("category");
		chairDAO=(ChairDAO)context.getBean("chairDAO");
	}
//	@Test
//   public void testAddChair() 
//	{
//		category.setId(13);
//		category.setName("round glass");
//		category.setDescription("not bad");
//		supplier.setId(128);
//		supplier.setSupname("gopal");
//		supplier.setSuplocation("hyd");
//		supplier.setCategoryname("round glass");
//		chair.setChairId(291);
//		chair.setChairName("nil kamal123");
//		chair.setChairPrice(2000);
//		chair.setChairStyle("modern");
//		chair.setChairDesc("good");
//		chair.setCapacity("standard");
//		chair.setPrimaryMeterial("plastic");
//		chair.setWarranty("one year");
//		chair.setCategory(category);
//		chair.setSupplier(supplier);
//		chair.setImage("C://Users/yogi/Desktop/chairs/nil.jpg");
//		
//		//chair.setImg("null");
//		chairDAO.addChair(chair);
//	}

//	@Test
//	public void testUpdateChair() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testGetAllChairs() 
	{
		Assert.assertEquals("listChairs" , 3,chairDAO.getAllChairs().size());
	}

	@Test
	public void testGetSingleChair() 
	{
		chair=chairDAO.getSingleChair(10);
		int idNo=chair.getChairId();
		Assert.assertEquals("chair test case",10, idNo);
    }

//	@Test
//	public void testDeleteChair() {
//		fail("Not yet implemented");
//	}

}
