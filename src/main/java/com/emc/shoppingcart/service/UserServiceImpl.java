package com.emc.shoppingcart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shoppingcart.dao.ProductDaoImpl;
import com.emc.shoppingcart.dao.UserDao;
import com.emc.shoppingcart.model.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public Map<String,Object> Login(String Username, String Password) {
        // TODO Auto-generated method stub
        User user;
        Map<String,Object> mapA = new HashMap();

        
        try{
               user=userDao.getUserByEmailId(Username);
               System.out.println(user.getFname());
               if(user.getPasword().equals(Password))
               {
                      //System.out.println("hi");
                      mapA.put("User", user);
               }
               
        }
        catch(Exception e){
               System.out.println(e.getMessage());
               mapA.put("ErrorMessage", e);
        }
        return mapA;
        
  }

	
	@Override
	public void createUser(User user) {
		
		System.out.println(user.getFname());
		
		//user.setRoleId(3);
		userDao.insertUser(user);
			
	}
	
	@Override
	public void createAdmin(User user) {
		
		//user.setRoleId(2);
		userDao.insertUser(user);
		
	}

	@Override
	public void deleteAdmin(String email, int roleId) {
		
		userDao.deleteUser(email,roleId);
		
	}

	@Override
	public List<User> displayAllUser(int roleId) {
		List<User> userlist = userDao.getAllUsers(roleId);
		return userlist;
	}

	@Override
	public void updateUser(User user, String email) {
		
		userDao.updateUser(user, email);
		
	}


}
