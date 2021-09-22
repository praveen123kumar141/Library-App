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
<body >
 <font color="black" size="4">
<table  border="2"  width="40%" height="40%">
<tr><th bgcolor="green">BookId</th><th bgcolor="green">book name</th><th bgcolor="green">author name</th><th bgcolor="green">dept</th></tr>
<c:forEach items="${model}"  var="c"><tr>
<td bgcolor="yellow"><c:out value="${c.bookid}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.bookname}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.authorname}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.deportment}"></c:out></td>
<td bgcolor="red" ><a href="edit_book?code=${c.bookid}">EDIT</a></td>
<td bgcolor="red"><a href="delete_book?code=${c.bookid}">DELETE</a></td></tr>
</c:forEach>
</table>
<button><a href="add_book">ADD NEW BOOK</a></button>
<button><a href="list_issuebooks">issue book</a>
<button><a href="return_book">return book</a></button>
<button><a href="liblog_out">log out</a></button>
</font>
</body>
</html>