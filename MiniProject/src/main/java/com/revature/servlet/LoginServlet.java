package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.Users;
import com.revature.services.Validations;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 817105812389880890L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Cache-Control","no-store");	
		System.out.println("LoginServlet- POST");
		
		Users newUser = new Users();
    	String email = req.getParameter("email");
		String password = req.getParameter("password");

		newUser.setEmail(email);
		newUser.setPassword(password);
		
		
		newUser = new Validations().checkLoginWithUserEmailId(newUser);
		System.out.println("User entered" + email + "&" + password);

		
		if(newUser == null){
	     	 //j_session_id_stored in a cookie on the client's browser
			
			 //The parameters: name, and the actual object that you want to store in the session
			//resp.getWriter().write("<h1>Welcome" + username + "&" + password);
			req.getRequestDispatcher("login.html").forward(req, resp);
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("user", newUser);
			if(newUser.getRoleId()==1)
			req.getRequestDispatcher("sindex.html").forward(req, resp);
			else if(newUser.getRoleId()==2)
				req.getRequestDispatcher("tindex.html").forward(req, resp);
		}
	}
	
}
