package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Login;
import com.niit.shoppingcart.model.User;



@Component
public interface UserDAO 
{		
		public boolean saveUser(User user);
		public boolean save(Login login);		
		
}
