<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="welcome.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  action='addbook' method='post'>
<table border='5' align='center'>
<tr><td>BOOKNAME</td>
<td><input type='text' name='bname' value=''/></td></tr>
<tr><td>PUBLISHER</td>
<td><input type='text' name='publish' value=''/></td></tr>

<tr><td>AUTHER</td>
<td><input type='text' name='auther' value=''/></td></tr>
<tr>

<tr><td>PRICE</td>
<td><input type='text' name='price' value=''/></td></tr>
<td colspan='2' align='center'>
 
 <input type='submit'  value='ADDBOOK'/>
</td></tr>

</table>
</form>
</body>
</html>