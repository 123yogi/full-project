package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;



public class SupplierDAOTest 
{
	@Autowired
	 static SupplierDAO supplierDAO;
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
		
		supplier=(Supplier)context.getBean("supplier");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
	}
    
	@Test
	public void testSaveOrUpdate()
	{
		supplier.setId(7);
		supplier.setSupname("yogesh");
		supplier.setSuplocation("hyd");
		supplier.setCategoryname("round tables");
		Assert.assertEquals("save Test Case",true,supplierDAO.save(supplier));
	}
	@Test
	public void testUpdate()
	{
		supplier.setId(9);
		supplier.setSupname("harini");
		supplier.setSuplocation("bag");
		supplier.setCategoryname("tpoints");
		Assert.assertEquals("update Test Case",true,supplierDAO.update(supplier));
	}
	@Test
	public void listSuppliers()
	{
	 Assert.assertEquals("listSupplier" , 3,supplierDAO.getAllSuppliers().size());
	}
	@Test
	public void getSingleSupplierTest()
	{
		supplier=supplierDAO.getSingleSupplier(9);
		int idNo=supplier.getId();
		Assert.assertEquals("supplier test case",9,idNo);
	}
//	 @Test
//	   public void deleteTestCase()
//	 {
//		   
//		 Assert.assertEquals("delete Test Case",true,supplierDAO.delete(210));
//		  
//		   
//	   }
	}


