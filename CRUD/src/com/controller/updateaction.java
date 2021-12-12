package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.database;
import com.model.addbook1;

/**
 * Servlet implementation class updateaction
 */
@WebServlet("/updateaction")
public class updateaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateaction() {
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
		int id =Integer.parseInt(request.getParameter("id"));
		String book_name=request.getParameter("bname");
		String publisher=request.getParameter("publish");
		String auther=request.getParameter("auther");
		String price=request.getParameter("price");
		
		System.out.println("book_name-->"+book_name);
		System.out.println("publisher-->"+publisher);
		System.out.println("auther-->"+auther);
		System.out.println("price-"+price);
		
		addbook1 book =new addbook1();
      	book.setId(id);
		book.setBook_name(book_name);
		book.setPublisher(publisher);
	    book.setAuther(auther);
		book.setPrice(price);
		
		try {
			database.updatebook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("view1.jsp");
		 
				
		
		
		
		
	}

}
