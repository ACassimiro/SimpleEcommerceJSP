package ServletToJSP;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Files.Product;
import Files.ProductsController;

public class ServletSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
		  {
		    // reading the user input
		    String searchString= request.getParameter("search");    
		    ArrayList<Product> myProductList = ProductsController.getProducts(searchString);
			request.setAttribute("productList", myProductList);
		    RequestDispatcher rd = request.getRequestDispatcher("productPage.jsp");
		    rd.forward(request, response);
		  }
}
