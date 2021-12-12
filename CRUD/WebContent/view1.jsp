<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="welcome.jsp"%>
    <%@page import="com.dao.*"%>
<%@page import="com.model.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>VIEW BOOK</h5>

<%

List<addbook1> book =  database.returnbook();
%> 

<table id="example" class="display" style="width:100%" border='5' align='center'>
        <thead>
            <tr>
                            <th>Id</th>
							<th>Book Name</th>
							<th>publisher </th>
							<th>Price</th>
							<th>Auther</th>
							<th>UPDATE</th>
							<th>DELETE</th>
						
            </tr>
        </thead>
        <tbody>
            <tr>
            
                       <%
							
						for(addbook1 b: book)
                         {
	 
						 %>
						       <td><%=b.getId() %></td>
						          <td><%=b.getBook_name()%></td>
						           <td><%=b.getPublisher()%></td>
						            <td><%=b.getPrice()%></td>
						             <td><%=b.getAuther()%></td> 
						          <td><a href='update.jsp?id=<%=b.getId()%>'>update book</a></td>
						          <td><a href='delete.jsp?id=<%=b.getId()%>'>delete book</a></td> 
                 
            </tr>
            
                 <%
					 }	
					
				  %>
            
            
        </tbody>
        <tfoot>
           
        </tfoot>
    </table>
            
</body>
</html>