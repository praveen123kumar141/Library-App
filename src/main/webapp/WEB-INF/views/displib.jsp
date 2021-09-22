<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/stylesheet.css">

</head>
<body bgcolor="red">
 <font color="black" size="4">
<table  border="2"  width="40%" height="40%">
<tr><th bgcolor="green">LibraienId</th><th bgcolor="green">username</th><th bgcolor="green">libraien name</th><th bgcolor="green">password</th></tr>
<c:forEach items="${model}"  var="c"><tr>
<td bgcolor="yellow"><c:out value="${c.id}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.username}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.libname}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.pass}"></c:out></td>
<td bgcolor="red" ><a href="edit_lib?code=${c.id}">EDIT</a></td>
<td bgcolor="red"><a href="delete_lib?code=${c.id}">DELETE</a></td></tr>
</c:forEach>
</table>
<button><a href="add_lib">ADD NEW LIBRAIEN</a></button>
<button><a href="log_out">logout</a></button>
</font>
</body>
</html>