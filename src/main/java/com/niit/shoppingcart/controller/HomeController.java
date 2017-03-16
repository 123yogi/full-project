package com.niit.shoppingcart.controller;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ChairDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Chair;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public ModelAndView onLoad() {
		log.debug("Starting of the method onLoad");
		ModelAndView mv = new ModelAndView("index");
		log.debug("Ending of the method onLoad");
		return mv;
	}

	@RequestMapping("/loginPage")
	public ModelAndView loginHere() {
		log.debug("Starting of the method loginHere");
		ModelAndView mv = new ModelAndView("loginPage");
		log.debug("Ending of the method loginHere");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logOutPage() {
		log.debug("Starting of the method logOutPage");
		ModelAndView mv = new ModelAndView("index");
		log.debug("Ending of the method logOutPage");
		return mv;
	}

	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginError(ModelMap model) {
		log.debug("Starting of the method loginError");
		return new ModelAndView("loginPage", "error", true);
	}

	// @RequestMapping("/landPage")
	// public ModelAndView landPage()
	// {
	// log.debug("starting of the method landPage");
	// ModelAndView mv=new ModelAndView("index");
	// log.debug("Ending of the method landPage");
	// return mv;
	// }

}
