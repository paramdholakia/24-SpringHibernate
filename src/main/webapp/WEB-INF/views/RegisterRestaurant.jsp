<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.validation.ObjectError"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Restaurant</title>
</head>

<style>
    span{
        color: red;
    	font-weight: bold;
    	
    }
</style>

<body>
    <h1>Register Restaurant</h1>
    
    <form action="saveRestaurant" method="POST">
    <label>Restaurant Name</label> 
    <input type="text" name="restaurantName" value="${restaurantEntity.restaurantName}" />
    <span>
        <c:if test="${bindingResult.hasFieldErrors('restaurantName')}">
            ${bindingResult.getFieldError("restaurantName").defaultMessage}
        </c:if>
    </span>
    <br /> 

    <label>Restaurant Address</label> 
    <input type="text" name="restaurantAddress" value="${restaurantEntity.restaurantAddress}" /> 
    <span>
        <c:if test="${bindingResult.hasFieldErrors('restaurantAddress')}">
            ${bindingResult.getFieldError("restaurantAddress").defaultMessage}
        </c:if>
    </span>
    <br /> 

    <label>Restaurant Category</label> 
    <input type="text" name="restaurantCategory" value="${restaurantEntity.restaurantCategory}" /> 
    <span>
        <c:if test="${bindingResult.hasFieldErrors('restaurantCategory')}">
            ${bindingResult.getFieldError("restaurantCategory").defaultMessage}
        </c:if>
    </span>
    <br />

    <input type="submit" value="Save" />
</form>

    
    <a href="listRestaurants">View Restaurant List</a>
    
</body>
</html>
