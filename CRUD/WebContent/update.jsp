<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@page import="com.dao.*"%>
 <%@page import="com.model.*"%>
<%@page import="java.util.List"%>
<title>Insert title here</title>
</head>
<body>
<h5>UPDATE BOOK DATA</h5>
<form  action='updateaction' method='post'>
<% 

int selected_id = Integer.parseInt(request.getParameter("id"));
List<addbook1> book = database.getdatawithid(selected_id);

%>
<%
for(addbook1 a:book ){
	
%>
<table border='5' align='center'>
<tr><td>ID</td>
<td><input type='number' name='id' value='<%=selected_id%>'/></td></tr>
<tr><td>BOOKNAME</td>
<td><input type='text' name='bname' value='<%=a.getBook_name()%>'/></td></tr>
<tr><td>PUBLISHER</td>
<td><input type='text' name='publish' value='<%=a.getPublisher() %>'/></td></tr>

<tr><td>AUTHER</td>
<td><input type='text' name='auther' value='<%=a.getAuther()%>'/></td></tr>
<tr>

<tr><td>PRICE</td>
<td><input type='text' name='price' value='<%=a.getPrice() %>'/></td></tr>
<td colspan='2' align='center'>
 
 <%
 }
 
 %>
 <input type='submit'  value='UPDATE BOOK'/>
</td></tr>

</table>
</form>
</body>
</html>