package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.database;
import com.model.addbook1;
/**
 * Servlet implementation class addbook
 */
@WebServlet("/addbook")
public class addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbook() {
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
		String book_name=request.getParameter("bname");
		String publisher=request.getParameter("publish");
		String auther=request.getParameter("auther");
		String price=request.getParameter("price");
		
		addbook1 book =new addbook1();
		book.setBook_name(book_name);
		book.setPublisher(publisher);
	    book.setAuther(auther);
		book.setPrice(price);
		
		  int flag =database.insertbook(book);
			if(flag ==1) {
				response.sendRedirect("addjsp.jsp");
			}
			   
			else {
				
				response.sendRedirect("error.jsp");
			}
			
		
			
			
			
		
		
		
	}

}
