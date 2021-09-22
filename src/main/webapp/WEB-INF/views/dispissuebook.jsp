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
<tr><th bgcolor="green">BookId</th><th bgcolor="green">student id</th><th bgcolor="green">book name</th><th bgcolor="green">author name</th><th bgcolor="green">deportment</th></tr>
<c:forEach items="${model}"  var="c"><tr>
<td bgcolor="yellow"><c:out value="${c.bookid}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.studentid}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.bookname}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.authorname}"></c:out></td>
<td bgcolor="yellow"><c:out value="${c.deportment}"></c:out></td>
</tr>
</c:forEach>
</table>
<button><a href="add_issuebook">Issue book</a></button>
<button><a href="list_books">goback library</a></button>
</font>
</body>
</html>