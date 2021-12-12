package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.database;
import com.model.book;

/**
 * Servlet implementation class registerContl
 */
@WebServlet("/registerContl")
public class registerContl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerContl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	String username =request.getParameter("uname");
	String password =request.getParameter("pass");
	int mobile_no =Integer.parseInt(request.getParameter("number"));
    String email =request.getParameter("email");
	
    System.out.println("username-->"+username);
	System.out.println("password-->"+password);
	System.out.println("mobile_no-->"+mobile_no);
	System.out.println("email--->"+email);
	
	       
	 book b = new book();
	 b.setUsername(username);
	 b.setPassword(password);
	 b.setEmail(email);
	 b.setMobile_no(mobile_no);
	
	   int flag =  database.insert(b);
	if(flag ==1) {
		response.sendRedirect("login.jsp");
	}
	   
	else {
		
		response.sendRedirect("error.jsp");
	}
	
	}

}
