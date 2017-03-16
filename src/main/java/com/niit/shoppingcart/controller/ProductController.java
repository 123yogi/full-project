package com.niit.shoppingcart.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CategoryDAO;
//import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ChairDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Chair;

@Controller
public class ProductController 
{
private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ChairDAO chairDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	
	 @RequestMapping("/newChair")
	    public ModelAndView newProduct()
	    {
		    log.debug("Starting of the method newProduct");
		    ModelAndView mv=new ModelAndView("addChair");
		    mv.addObject("suppliers",supplierDAO.getAllSuppliers());
		    mv.addObject("categories",categoryDAO.list());
	    	log.debug("Ending of the method newProduct");
	    	return mv;
	    }
	
	@RequestMapping("/retriveRecords")
	public ModelAndView retriveRecords()
	{  
		log.debug("Starting of the method retriveRecords");
		ModelAndView mv=new ModelAndView("manageProducts");
		log.debug("Ending of the method retriveRecords");
		return mv;
	} 
	
	@ModelAttribute("chair")
    public Chair createChair()
    {
		log.debug("Starting of the method createChair");
    	return new Chair();
    }
	
	 @RequestMapping(value="/storeChair", method = RequestMethod.POST)
	    public String addChairs(HttpServletRequest request,@Validated @ModelAttribute("chair")Chair chair,BindingResult result)
	           {
		 log.debug("Starting of the method addChairs");
		      	if(result.hasErrors())
	        	{
	        		return "addChair";
	        	}
		      	System.out.println(chair.getChairId());
		      	System.out.println(chair.getChairName());
		      	System.out.println(chair.getImage());
	        	String filename=chair.getImg().getOriginalFilename();
	        	chair.setImage(filename);
	        	
	        	try{
	        		byte[] bytes=new byte[chair.getImg().getInputStream().available()];
	        		chair.getImg().getInputStream().read(bytes);
	        		BufferedInputStream buffer=new BufferedInputStream(chair.getImg().getInputStream());
	        		MultipartFile file=chair.getImg();
	        		String path=request.getServletContext().getRealPath("/")+"resources/images";
	        		File rootPath=new File(path);
	        		if(!rootPath.exists())
	        			rootPath.mkdirs();
	        		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
	        		System.out.println("Image path :"+path);
	        		OutputStream os=new FileOutputStream(store);
	        		os.write(bytes);
	        	}
	        	catch(Exception e){
	        		System.out.println(e.getMessage());
	        	}
	        	chairDAO.addChair(chair);
	        	log.debug("Ending of the method addChairs");
	        	//return "ViewAll";
	        	return "manageProducts";
	        }
	 
	    @RequestMapping(value="/list",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showList()
	    {
	    	log.debug("Starting of the method showList");
	    	List list=chairDAO.getAllChairs();
	    	Gson x=new Gson();
	    	String json=x.toJson(list);
	    	log.debug("End of the method showList");
	    	return json;
	    }
	    @RequestMapping(value="editChair",method=RequestMethod.GET)
	    public ModelAndView editChair(@RequestParam int id)
	    {
	    log.debug("Starting of the method editChair");
		 Chair chair=chairDAO.getSingleChair(id);
		 log.debug("End of the method editChair");
		 return new ModelAndView("editChair","chair",chair);
	    }
	    
	    @RequestMapping(value="/updateChair",method=RequestMethod.POST)
	    public ModelAndView updateChair(HttpServletRequest request,@Valid @ModelAttribute("chair")Chair chair,BindingResult result)
	    {
	    	log.debug("Starting of the method updateChair");
	    	String filename=chair.getImg().getOriginalFilename();
	    	
        	chair.setImage(filename);
        	
	    	try{
        		byte[] bytes=new byte[chair.getImg().getInputStream().available()];
        		chair.getImg().getInputStream().read(bytes);
        		BufferedInputStream buffer=new BufferedInputStream(chair.getImg().getInputStream());
        		MultipartFile file=chair.getImg();
        		String path=request.getServletContext().getRealPath("/")+"resources/images";
        		File rootPath=new File(path);
        		if(!rootPath.exists())
        			rootPath.mkdirs();
        		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
        		OutputStream os=new FileOutputStream(store);
        		os.write(bytes);
        	}
        	catch(Exception e){
        		System.out.println(e.getMessage());
        	}
        		        
	    	chairDAO.updateChair(chair);
	    	log.debug("End of the method updateChair");
	    	return new ModelAndView("manageProducts");
	    }
	    
	    @RequestMapping("/delete")
	    public ModelAndView deleteChair(@RequestParam int id)
	    {		 
	    	log.debug("Starting of the method deleteChair");
		    chairDAO.deleteChair(id);
	    	ModelAndView mv=new ModelAndView("manageProducts");
	    	log.debug("End of the method deleteChair");
	    	return mv;
	    }
	    
	    @RequestMapping(value="viewProduct",method=RequestMethod.GET)
	    public ModelAndView viewProduct(@RequestParam int id, @ModelAttribute Chair chairs)
	    {
	    	log.debug("Starting of the method viewProduct");
	    	Chair chair=chairDAO.getSingleChair(id);
	    	log.debug("End of the method viewProduct");
	    	return new ModelAndView("viewProduct","chair",chair);
	    	
	    }
	    @RequestMapping("/displayProducts")
	    public ModelAndView displayProducts()
	    {
	    	log.debug("Starting of the method displayProducts");
	    	ModelAndView mv=new ModelAndView("displayProducts");
	    	mv.addObject("chairs",chairDAO.getAllChairs());
	    	log.debug("Ending of the method displayProducts");
	    	return mv;
	    	
	    }
	    
	
}