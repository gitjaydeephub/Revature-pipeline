package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Users;


public class UserInfoServlet extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -6778175109570573186L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("AjaxBankInfoServlet -GET");
		
		HttpSession session = request.getSession();
		
		Users sessionUser = (Users) session.getAttribute("user");
		
		if(sessionUser != null){
		
				System.out.println("---------------JSON Mapping------------------");
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(sessionUser);
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
			}

}
}