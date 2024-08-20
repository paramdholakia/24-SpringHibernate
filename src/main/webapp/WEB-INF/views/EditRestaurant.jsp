<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Restaurant</title>
</head>
<body>

	<h1>Edit Restaurant</h1>
	<form action="updateRestaurant" method="post">
		<input type="hidden" name="id" value="${restaurant.id}" />
		<table>
			<tr>
				<td>Restaurant Name:</td>
				<td><input type="text" name="restaurantName"
					value="${restaurant.restaurantName}" /></td>
			</tr>
			<tr>
				<td>Restaurant Address:</td>
				<td><input type="text" name="restaurantAddress"
					value="${restaurant.restaurantAddress}" /></td>
			</tr>
			<tr>
				<td>Restaurant Category:</td>
				<td><input type="text" name="restaurantCategory"
					value="${restaurant.restaurantCategory}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Restaurant" /></td>
			</tr>
		</table>
	</form>

	<a href="listRestaurants">View Restaurant List</a>


</body>
</html>