<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
	<form action="insertServlet" method="post">
		Product Name : <input type="text" name="p_name"><br><br>
		Product Price : <input type="text" name="p_price"><br><br>
		Product Quantity <input type="text" name="p_qty"><br><br>
		<input type="submit" name="Add" value="Add">
	</form>

</body>
</html>