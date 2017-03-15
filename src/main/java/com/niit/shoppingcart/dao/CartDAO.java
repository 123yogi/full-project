package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.model.CartItem;
@Component
public interface CartDAO 
{
	public boolean add(CartItem cartItem);
	public CartItem get(int id);
	public List getAllItems();
	public void remove(int id);
	public void removeAll();
	//public void update(int cartItemId,int quantity);
	
}

