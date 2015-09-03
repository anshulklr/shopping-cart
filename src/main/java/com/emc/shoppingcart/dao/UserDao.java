package com.emc.shoppingcart.dao;

import java.util.List;

import com.emc.shoppingcart.model.User;

public interface UserDao {
	
	/* 
	 * This is the method to be used to register a
	 * user and save its details
	 */
	public void insertUser(User user);
	
	/*
	 * This is the method to be used to 
	 * find a user by email id. When the user try to login 
	 * this method is to be used
	 */
	public User getUserByEmailId(String emailId);
	
	
	/* This is the method to be used to find 
	 * a user using phone number. When the user 
	 * forgets his/her userid or password
	 * public User getUserByPhoneNumber(Int phoneNumber)*/
	
	/*
	 * This is the method to be used to display 
	 * the list of users to admin
	 */
	public List<User> getAllUsers();
	
	/*
	 * This is the method to be used 
	 * to update the details of the user.
	 */
	public void updateUser(User user, String email);
	
	/*
	 * This is the method to be used 
	 * to delete the admin.
	 */
	public void deleteUser(String email);
}
