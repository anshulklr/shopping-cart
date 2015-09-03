package com.emc.shoppingcart.service;

import java.util.List;
import java.util.Map;

import com.emc.shoppingcart.model.User;

public interface UserService {
	public Map<String,Object> Login(String Username, String Password);
	public void createUser(User user);
	public void createAdmin(User user);
	public void deleteAdmin(String email);
	public List<User> displayAllUser();
	public void updateUser(User user , String email);
}
