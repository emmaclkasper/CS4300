<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="shopping.Item" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="data" class="shopping.DBQuery" scope = "session" />

<title>Insert title here</title>
</head>
<body>

	<% 
		if(request.getParameter("addItem") != null)
		{
			//Item addItem = new Item();		
		}
	
	
		if (request.getParameter("addItem") != null) {
			Item updateItem = new Item();
			updateItem.setName(request.getParameter("name"));
			updateItem.setPrice(Float.parseFloat(request.getParameter("price")));
			updateItem.setDescription(request.getParameter("description"));
			updateItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		///last ws here
			data.addItem(updateItem.get,updateItem.getName(), updateItem.getPrice(), updateItem.getDescription(),
					updateItem.getQuantity());
		}
	%>
	<h1>Add Items</h1>
	<form method="post">
	<table>
		<tr>
			<td>Name:	</td>
			<td><input type="text" name="name"></input></td>
		</tr>
		
		<tr>
			<td>Price:	</td>
			<td><input type="text" name="price"></input></td>
		</tr>	
		
		<tr>
			<td>Description:	</td>
			<td><input type="text" name="description"></input></td>
		</tr>
		<tr>
			<td>Quantity:	</td>
			<td><input type="text" name="quantity"></input></td>
		</tr>	
	
		<tr>
			<td><input type="submit" value="add" name="addItem"></input></td>
		</tr>
	</table>
	</form>
</body>
</html>