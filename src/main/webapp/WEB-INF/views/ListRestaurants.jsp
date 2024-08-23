<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entity.RestaurantEntity"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant List</title>
</head>


<style>
	a{
		text-decoration: none;
		color : black;
	}
</style>

<body>
	
	<h1>Restaurant List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Restaurant ID</th>
				<th>Restaurant Name</th>
				<th>Restaurant Address</th>
				<th>Restaurant Category</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				// Get the list of restaurants from the model
				List<RestaurantEntity> restaurants = (List<RestaurantEntity>) request.getAttribute("restaurants");
				
				for (RestaurantEntity restaurant : restaurants) {
					out.println("<tr>");
					out.println("<td>" + restaurant.getId() + "</td>");
					out.println("<td>" + restaurant.getRestaurantName() + "</td>");
					out.println("<td>" + restaurant.getRestaurantAddress() + "</td>");
					out.println("<td>" + restaurant.getRestaurantCategory() + "</td>");
					out.println("<td><a href='editRestaurant?id=" + restaurant.getId() + "'>Edit</a> | <a href='deleteRestaurant?id=" + restaurant.getId() + "'>Delete</a></td>");
					out.println("</tr>");
				}
			%>
		</tbody>
	</table>
	
	<a href="newrestaurant">Add Restaurant</a>
	
</body>
</html>
