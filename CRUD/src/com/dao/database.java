package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.addbook1;

import com.model.book;

public class database {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/book?autoReconnect=true&useSSL=false";
		static final String USER = "root";
		static final String PASS = "root";
		//id, name, publisher, auther, price
		
		public static Connection makeConnection()
		{
			Connection con = null;
			try 
			{
				Class.forName(JDBC_DRIVER);
				con = DriverManager.getConnection(DB_URL, USER, PASS);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return con;
		}
		
		
		public static int insert(book b)
		{
			
			int flag = 0;
			Connection con = makeConnection();
			PreparedStatement pstm = null;
			try
			{
				
		String sql = "insert  into addbook (username, password, mobile_no, email) values(?,?,?,?)"; 
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, b.getUsername());
				pstm.setString(2, b.getPassword());
			    pstm.setInt(3, b.getMobile_no());
				pstm.setString(4, b.getEmail());
				
			    int i = pstm.executeUpdate();
				if (i == 1)
				flag = 1;
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			finally 
			{
				if (con != null) 
				{
					try
					{
						con.close();
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				if (pstm != null)
				{
					try
					{
						pstm.close();
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			}
			return flag;
		}	
	
		
		public static int userLogin(book b) 
		{
				int id= 0;
				
				String sql = "select * from addbook where username=? and password=?";
				
				Connection con = makeConnection();
				
				PreparedStatement pstm = null;
				
				ResultSet rs = null;
				try
				
				{
					pstm = con.prepareStatement(sql);
					pstm.setString(1, b.getUsername());
					pstm.setString(2, b.getPassword());
				
					rs = pstm.executeQuery();
					
					while (rs.next())
						
					{
						id = rs.getInt("id");
			
						
					}
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					if (con != null)
					{
						try
						{
							con.close();
						}
						catch (SQLException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (pstm != null)
					{
						try
						{
							pstm.close();
						}
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (rs != null)
					{
						try
						{
							rs.close();
						} 
						catch (SQLException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				return id;
			}	
		public static int insertbook(addbook1 book)
		{
			
			int flag = 0;
			Connection con = makeConnection();
			PreparedStatement pstm = null;
			try
			{
				
		String sql = "insert  into addbook1 (name, publisher, auther, price) values(?,?,?,?)"; 
				pstm = con.prepareStatement(sql);
				
				pstm.setString(1, book.getBook_name());
				pstm.setString(2, book.getPublisher());
			    pstm.setString(3, book.getAuther());
				pstm.setString(4, book.getPrice());
			
			    int i = pstm.executeUpdate();
				if (i == 1)
				flag = 1;
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			finally 
			{
				if (con != null) 
				{
					try
					{
						con.close();
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				if (pstm != null)
				{
					try
					{
						pstm.close();
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			}
			return flag;
		}	
		
		
		public static List<addbook1> returnbook() 
	
		{
		List <addbook1> list = new ArrayList<addbook1>();
		
		String sql = "select * from addbook1;";
		Connection con = makeConnection();
		try 
		{
		 PreparedStatement pstm1 = con.prepareStatement(sql);
		 
		 ResultSet rs = pstm1.executeQuery();
		 
		 while (rs.next()) 
		  {
			  
			 addbook1 l = new addbook1();
			
			 
			l.setId(rs.getInt("id"));
		    l.setBook_name(rs.getString("name"));
		    l.setAuther(rs.getString("auther"));
		    l.setPublisher(rs.getString("publisher"));
		    l.setPrice(rs.getString("price"));		
			list.add(l);	
					
				}
				
				} catch (SQLException e) {
				
				     
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
		return list;
			
		}	
		
		   
		public static void delete(int id) 
		{
	
		String sql = "delete from addbook1 where id =?";
		Connection con = makeConnection();
		try 
		{
			PreparedStatement pstm1 = con.prepareStatement(sql);
		    pstm1.setInt(1, id);
		    pstm1.executeUpdate();
				
		 } catch (SQLException e) {
				
				     
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
				}

		}	
		
		public static List<addbook1> getdatawithid(int id ) 
		{
		List<addbook1> addbooklist = new ArrayList<addbook1>();
		
		String sql = "select *from addbook1 where id=?";
		Connection con = makeConnection();
		
		try 
		
		{
			PreparedStatement pstm1 = con.prepareStatement(sql);
		    
			pstm1.setInt(1,id);
		    
		    ResultSet rs = pstm1.executeQuery();
		    
		    while(rs.next())
		    {
		    
		    	addbook1 a = new addbook1();
		    	
		         a.setBook_name(rs.getString("name"));
		         a.setPublisher(rs.getString("publisher"));
		         a.setAuther(rs.getString("auther"));
		         a.setPrice(rs.getString("price"));
		
		    	
		    	
		         addbooklist.add(a);
		    
		    }
		    
		    
		   } catch (SQLException e) {
				
				     
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
		return addbooklist;

			
		}
		
		
		public static boolean updatebook( addbook1 b) throws SQLException {
	        boolean rowUpdated;
			String UPDATE_USERS_SQL = "update addbook1 set name = ?,publisher= ?, auther =?,price=? where id = ?;";

	        try 
	        
	        (Connection con = makeConnection(); PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, b.getBook_name());
	            statement.setString(2, b.getPublisher());
	            statement.setString(3, b.getAuther());
	            statement.setString(4, b.getPrice());
	            statement.setInt(5, b.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
}


