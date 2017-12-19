<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
</head>
<body>
<form:form action="saveCustomer" method="post" modelAttribute="customer">
        
                
                <form:hidden path="id"/><br>
                FName:
                <form:input path="fname" /><br>
                LName:
                <form:input path="lname" /><br>
                Address:
                <form:input path="address" /><br>
                
           <input type="submit" value="Save">
           
        
        </form:form>
    </div>
</body>
</html>