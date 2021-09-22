<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/stylesheet.css">

</head>
<body bgcolor="magenta">
<font  color="black"  size="5">
please enter a valid book id !!!
<form:form  action="/savereturn_book" modelAttribute="model">
bookid:
<form:input path="id"/><br/>
<form:button>submit</form:button>
</form:form>

</font>
</body>
</html>