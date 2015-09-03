package com.emc.shoppingcart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject; 

	@Override
	public void insertUser(User user) {
		
		String sql = "INSERT INTO USERS " +
				"(FNAME,LNAME,EMAILID,ADDRESSLINE1,ADDRESSLINE2,CITY,STATE,COUNTRY,PINCODE,PASSWORD,ROLEID)"
				+ " VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";
		System.out.println(user.getFname());
		
		jdbcTemplateObject.update(sql, user.getFname(),user.getLname(),user.getEmailId(),user.getAddressLine1()
				,user.getAddressLine2(),user.getCity(),user.getState(),user.getCountry(),user.getPincode(),
				user.getPasword(),user.getRoleId());
		
		return;
		
	}

	@Override
	public User getUserByEmailId(String emailId) {
		
		String sql="SELECT * FROM USERS WHERE EMAILID=?";
		User user=(User) jdbcTemplateObject.queryForObject(sql,new Object[]{emailId},new BeanPropertyRowMapper<User>(User.class));
		
		
		return user;
	
	}

	@Override
	public List<User> getAllUsers(int roleId) {
		
		String sql = "SELECT * FROM Users where roleId=?";  
		  List<User> userlist= jdbcTemplateObject.query(sql,new Object[]{roleId},new BeanPropertyRowMapper(User.class));  
		  return userlist; 
	}

	@Override
	public void updateUser(User user , String email ) {

		String sql = "update users set FNAME = ?, LNAME = ?, ADDRESSLINE1 = ?, ADDRESSLINE2 = ?, CITY = ?, STATE = ?, COUNTRY = ?, PINCODE = ?, PASSWORD = ? where emailId=? ";
		jdbcTemplateObject.update(sql, user.getFname(), user.getLname(),  user.getAddressLine1(), user.getAddressLine2(), user.getCity(), user.getState(), user.getCountry(), user.getPincode(), user.getPasword(), email);
		System.out.println("Updated user details");
		
		
	}

	@Override
	public void deleteUser(String email,int roleId) {
		String sql = "delete from users where emailId=? and roleId=?";
		jdbcTemplateObject.update(sql, email,roleId);
		
		System.out.println("Product deleted");
		
	}

}
