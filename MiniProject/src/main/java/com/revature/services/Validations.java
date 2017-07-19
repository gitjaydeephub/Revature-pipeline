package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bean.Users;

public class Validations {

	public static Users checkLoginWithUserId(Users checkUser)
	{
		Users user = null;
		try(Connection conn = Connections.getConnection()){
				
				String sql1="Select * FROM users WHERE u_id = ? and u_password = ?";
				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.setInt(1,checkUser.getUserId());
				ps.setString(2, checkUser.getPassword());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				 return new Users(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)); 
				}
				else 
					return user;
					
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return user;			
		
	}
	
	
	public static Users checkLoginWithUserEmailId(Users checkUser)
	{
		Users user = null;
		try(Connection conn = Connections.getConnection()){
				
				String sql1="Select * FROM users WHERE u_email = ? and u_password = ?";
				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.setString(1,checkUser.getEmail());
				ps.setString(2, checkUser.getPassword());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
				 return new Users(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)); 
				}
					
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return user;			
		
	}

}
