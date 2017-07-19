package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Users;
import com.revature.services.Connections;

public class UserDaoImply implements UserDao {

@Override	
public void addUser(com.revature.bean.Users user) {

	String sql = "INSERT INTO users(u_role_id, u_email, u_password, u_fname, u_lname) VALUES(?,?,?,?,?)";
	try(Connection connect = Connections.getConnection();){
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, user.getRoleId());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getFirstName());
		ps.setString(5, user.getLastName());
		ps.executeUpdate();

	}catch (SQLException e) {
		e.printStackTrace();
	}

}


@Override
public Users getUserByEmailId(Users user) {
	Users fetchedUser=null;
	try(Connection connect = Connections.getConnection();){
	
		String sql = "SELECT * FROM users WHERE u_email = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			fetchedUser = new Users(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		}
		return fetchedUser;
	}catch (SQLException e) {
		e.printStackTrace();
	}

	return null;
}

@Override
public Users getUserByUserId(Users user) {
	Users fetchedUser=null;
	try(Connection connect = Connections.getConnection();){
	
		String sql = "SELECT * FROM users WHERE u_id = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, user.getUserId());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			fetchedUser = new Users(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		}
		return fetchedUser;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return fetchedUser;
}

@Override
public List<Users> getAllUsers() {
		
	List<Users> fetchedUsers = new ArrayList<>();
	try(Connection connect = Connections.getConnection();){
		
		String sql = "SELECT * FROM users";
		PreparedStatement ps = connect.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			fetchedUsers.add(new Users(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		return fetchedUsers;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return fetchedUsers;
	
}




@Override
public boolean deleteUserByEmailId(Users user) {
	
	boolean deletedSuccessfully=false;
	
	try(Connection connect = Connections.getConnection();){
	
		String sql = "DELETE FROM users WHERE u_email = ?";
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		int rs = ps.executeUpdate();
		
		if(rs!=0)
		return true;
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return deletedSuccessfully;
	
};

}
