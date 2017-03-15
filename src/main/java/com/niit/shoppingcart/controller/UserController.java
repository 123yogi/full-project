package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Chair;
import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController 
{
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDAO userDAO;
	
	
	    @RequestMapping("/newUser")
	    public String showUserForm()
	    {       	
	    	log.debug("starting of the method showUserForm");
	    	return "registerUserPage";	    
	    }
	 @ModelAttribute("user")
	    public User loginUser()
	    {
		    log.debug("starting of the method loginUser");
		    return new User();
	    }
	 
	 @RequestMapping("/adminPage")
	 public ModelAndView enterAdminPage()
	 {
		 log.debug("starting of the method enterAdminPage");
		 return new ModelAndView("adminPage");
	 }
	 
	    @RequestMapping(value="/register" ,method=RequestMethod.GET)
		public ModelAndView registerPage()
		{
			log.debug("Starting of the method registerPage");
			return new ModelAndView("registerUserPage","user",new User());
			
		}
	    
		@RequestMapping(value="/register" ,method=RequestMethod.POST )
		public String registerActionPage(@ModelAttribute("user") @Validated User user, BindingResult result)
		{
			log.debug("Starting of the method registerActionPage");
			if (result.hasErrors()) 
			{			
				return "registerUserPage";
			}
			else
			{
			  userDAO.saveUser(user);	
			  log.debug("Ending of the method registerActionPage");
			  return "loginPage";		
			}		
		}	
		
		
	 
	 @RequestMapping(value="validate", method=RequestMethod.GET)
	    public ModelAndView validate(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception
		{  
	    	log.debug("starting of the method checkUserOne");
	    	if(request.isUserInRole("ROLE_ADMIN"))
	    	{
	    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	    String name = auth.getName(); 
	    		session=request.getSession(true);
	    	    session.setAttribute("loggedInUser",name);
	    	    ModelAndView modelAndView=new ModelAndView("adminPage");
	    	    return modelAndView; 
	    	}	   
	    	else
	    	{
	    	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
 	            String name = auth.getName(); 
 	            session=request.getSession(true);
 	          	session.setAttribute("loggedInUser",name);
		    	ModelAndView modelAndView=new ModelAndView("manageProducts");
		    	log.debug("Ending of the method landPage");
		    	return modelAndView; 
           }
		}
	   
	   @RequestMapping(value = "/storeUser", method = RequestMethod.POST)
	    public String addUser(@Valid @ModelAttribute("user")User user,BindingResult result)
	   {
		   log.debug("starting of the method checkUserOne");	       	
	    	if(result.hasErrors()) 
	    	{
	    		
	    		return "registerUserPage";
	    	}
	    	
	    	userDAO.saveUser(user);
	    	Login login=new Login();
	    	login.setId(user.getId());
	    	login.setUsername(user.getName());
	    	login.setPassword(user.getPassword());
	    	login.setStatus(user.isEnabled());
	    	userDAO.save(login);
	    	log.debug("Ending of the method checkUserOne");
	    	return "index";
	       }
	   
	   
	   
}