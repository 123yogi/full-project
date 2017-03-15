package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO 
{
	public boolean saveOrUpdate(Category category);
	public List<Category> list();
	public boolean updateCategory(Category category);
	public Category get(int id);
	public boolean deleteCategory(String id);
}
