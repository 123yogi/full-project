package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Chair;
public interface ChairDAO 
{
	public boolean addChair(Chair chair);
	public boolean updateChair(Chair chair);
	public List getAllChairs();
	public Chair getSingleChair(int id);
	public void deleteChair(int id);

}
