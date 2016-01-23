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
	</head>	
	<body>			
		<div id='cssmenu'>
			<ul>
			    <li class='active'><form action="ServletToJSP">			
					<input type="submit" value="Home">						
				</form></li>
			    <li class='last'><form action="ServletToAdd">
			    	<input type="hidden" name="doCheckout" value="1">			
					<input type="submit" value="Checkout">						
				</form>	
				</li>
				<li class='last'><form action="ServletToAdd">
			    	<input type="hidden" name="clearSession" value="1">			
					<input type="submit" value="Clear Chart">						
				</form>	
				</li>
			   <li>
			   		<form action="ServletSearch">			
						<input type="text" name="search" size="30px" placeholder="Search...">
						<input type="submit" value="GO">						
					</form>	
			</li>
			</ul>		
		</div>
		
		
		<!--
		<%Object onCart = request.getAttribute("onCart");%>
		<% if(onCart != null) { %>
			<c:forEach items="${onCart}" var="product"> 
				<h4>${product.name}</h4>
				<img src="${product.imageURL}" height="42" width="42">
				<p>$ ${product.price}</p>
			</c:forEach>
		<% session.setAttribute("onCart", onCart);
		}else{%> 
			<h1>NO DATA</h1>		
		<%}%> 
		-->
		

						
		
		<c:forEach items="${productList}" var="product"> 
				<div class="productDiv" style="display: inline; float: left; padding-right:5px; width: 200px; height: 300px; background-color:#FFFFFF; border-style: solid;">
					<ul style="list-style: none;text-align: center;">
					<li>				
					<h4>${product.name}</h4>
					</li>
					<li>
					<img src="${product.imageURL}" height="42" width="42">
					</li>
					<li>
					<p>$ ${product.price}</p>
					</li>
					<li>
					<form action="ServletToAdd">
						<input type="hidden" name="prod" value="${product.name}">
						<input type="hidden" name="price" value="${product.price}">
						<input type="hidden" name="image" value="${product.imageURL}">
						<input type="submit" value="Add">
					</form>
					</li>
					</ul>
				</div>
	 
		</c:forEach>
	
			 
	</body>	
</html>