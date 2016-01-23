<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
	pageEncoding="ISO-8859-1"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="style.css">
		<title> Term Project   </title>
		
				<style>
				ul#menu {
					border: 5px solid black;
					width: 600px;
					padding-left: 15px;
					background-color: white;	
				    padding: 0;
				}
				
				ul#menu li {
					padding: 15px;
				    display: inline;
				}
				
				ul#menu li a {
				    display: inline;
				    text-align: center;
  					line-height: 3em;
				    text-decoration: none;
				    border-radius: 4px 4px 0 0;
				}

				label{
				    float: left;
				    clear: left;
				    width: 250px;
				}
				input {
				  display: inline-block;
				  float: left;
				}
				
				#prodImg {
					margin-top: 15px;
				}
				
				#products {
					background-color: white;
					margin-top: 30px;
					padding-top: 15px;
					padding-left: 15px;
					height: 390px;
					width: 300px;
					border: 5px solid black;
				}
</style>
	</head>	
	<body>		
		<div id='cssmenu'>
			<ul>
			   <li class='active'><form action="ServletToJSP">			
			<input type="submit" value="Home">						
		</form>		</li>
			</ul>
		</div>
		
		<h1>Welcome to the checkout page</h1>
		
		<h2>Your Shopping List</h2>
		
		<p>Total: $ ${price}</p>
		<c:forEach items="${productList}" var="product"> 
					<ul id="menu">
					
					<li>
					<img src="${product.imageURL}" height="42" width="42">
					</li>
					
					<li>				
					<a>${product.name}</a>
					</li>

					<li>
					<a>$ ${product.price}</a>
					</li>
					
					<li>
					<a> ${product.amount}</a>
					</li>
					
					</ul>
		</c:forEach>
		
		<form id='products' action="PDFServlet" method="post" target="_blank">
			<label>First name: </label><input type="text" name="FirstName" size="35"><br>
			<label>Last name: </label><input type="text" name="LastName" size="35"><br>
			<label>Address: </label><input type="text" name="Address" size="35"><br>
			<label>City: </label><input type="text" name="City" size="35"><br>
			<label>State: </label><input type="text" name="State" size="35"><br>
			<label>Zip code: </label><input type="text" name="Zipcode" size="35"><br>
			<label>Country:</label> <input type="text" name="Country" size="35"><br>
			<label>Phone number: </label><input type="text" name="PhoneNumber" size="35"><br>
			<label>Email: </label><input type="text" name="Email" size="35"><br/>
			
			<label></label><input type="submit" value="Confirm Purchase">
		</form>
	
			 
	</body>	
</html>