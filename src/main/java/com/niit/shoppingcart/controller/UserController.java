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
import org.springframework.webflow.engine.model.Model;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Chair;
import com.niit.shoppingcart.model.User;

@Controller
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDAO userDAO;

	@ModelAttribute("user")
	public User loginUser() {
		log.debug("starting of the method loginUser");
		return new User();
	}

	@RequestMapping(value = "/register")
	public ModelAndView registerPage() {
		log.debug("Starting of the method registerPage");
		return new ModelAndView("registerUserPage");

	}

	@RequestMapping(value = "/storeUser", method = RequestMethod.POST)
	public String addUser(@Validated @ModelAttribute("user") User user, BindingResult result) {
		log.debug("starting of the method checkUserOne");
		if (result.hasErrors()) {

			return "registerUserPage";
		}

		userDAO.saveUser(user);
		log.debug("Ending of the method checkUserOne");
		return "index";
	}

	@RequestMapping(value = "validate", method = RequestMethod.GET)
	public ModelAndView validate(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		log.debug("starting of the method checkUserOne");
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", name);
			ModelAndView modelAndView = new ModelAndView("adminPage");
			return modelAndView;
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", name);
			ModelAndView modelAndView = new ModelAndView("manageProducts");
			log.debug("Ending of the method landPage");
			return modelAndView;
		}
	}

}