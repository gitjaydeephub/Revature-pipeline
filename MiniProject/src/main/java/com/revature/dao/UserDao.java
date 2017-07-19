package com.revature.dao;

import java.util.List;

import com.revature.bean.Users;

public interface UserDao {
	
		//CREATE
		public void addUser(Users user);
		
		//READ
		public Users getUserByEmailId(Users user);
		public Users getUserByUserId(Users user);
		public List<Users> getAllUsers(); 
		
		//DELETE
		public boolean deleteUserByEmailId(Users user);

	
}
