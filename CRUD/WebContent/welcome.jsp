<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>



Welcome <%=session.getAttribute("username") %>

<table border='0' align='center' width='80%'>
 <tr>
 <td><a href='add.jsp'>ADDBOOK</a></td>
 <td><a href='view1.jsp'>VIEWBOOK</a></td>

 </tr>
 
</table>













</body>
</html>