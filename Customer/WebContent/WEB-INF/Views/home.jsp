<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body>
<div align="center">
            <h1>Customer List</h1>
            <h3><a href="/Customer/newCustomer">New Customer</a></h3>
            <table border="1">
                <th>id</th>
                <th>fName</th>
                <th>lName</th>
                <th>address</th>
                <th>Actions</th>
                 
                <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.fname}</td>
                    <td>${customer.lname}</td>
                    <td>${customer.address}</td>
                    <td>
                        <a href="/Customer/updateCustomerById?id=${customer.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Customer/deleteCustomer?id=${customer.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
            <p>Get Customer by id</p>
	<form action="getCustomerById">
		<input type="text" name="id" />
		<button value="submit">Get details</button>
	</form>
	<p>${customerInfo.fname}</p>
	<p>${customerInfo.lname}</p>
	<p>${customerInfo.address}</p>
	<br><br>
        </div>
</body>
</html>