package com.niit.shoppingcart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Chair;
import com.niit.shoppingcart.model.User;

@Controller
public class CategoryController
{
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@RequestMapping("/category")
	public ModelAndView startCategory()
	{  
		       log.debug(" Starting of the method startCategory");
		       ModelAndView mv=new ModelAndView("category");
		       log.debug(" End of the method listCategories");
		       return mv; 
	}
	@ModelAttribute("category")
    public Category createCategory()
    {
		log.debug(" Starting of the method createCategory");
		return new Category();
    }
	@RequestMapping(value = "/manage_categories", method = RequestMethod.GET)
	public String listCategories(Model model) 
	{
		log.debug(" Starting of the method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug(" End of the method listCategories");
		return "category";
	}
	
	
	@RequestMapping(value = "/manage_category_add", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model)
	{
		log.debug(" Starting of the method addCategory");
		
		if (categoryDAO.saveOrUpdate(category) == true)
		{			
			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} 
		else
		{
			model.addAttribute("msg", "not able created/updated the caetgory");
		}
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("isAdminClickedCategories", "true");
		log.debug(" End of the method addCategory");
		return "category";
	}

	@RequestMapping("manage_category_edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) 
	{
		log.debug(" Starting of the method editCategory");
		category = categoryDAO.get(id);
		model.addAttribute("category", category);
		log.debug(" End of the method editCategory");
		return "forward:/manage_categories";
	}
	
	@RequestMapping("manage_category_remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, Model model) throws Exception 
	    {
		log.debug(" Starting of the method deleteCategory");
		boolean flag = categoryDAO.deleteCategory(id);

		String msg = "Successfully done the operation";
		if (flag != true) {
			msg = "The operation could not success";
		}
		
		model.addAttribute("msg", msg);
		log.debug(" End of the method deleteCategory");
		return "forward:/manage_categories";
	}

}
	
