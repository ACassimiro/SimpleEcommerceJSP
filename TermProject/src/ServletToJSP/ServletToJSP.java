package ServletToJSP;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Files.Product;
import Files.ProductsController;

import java.util.ArrayList;

// http://www.java-samples.com/showtutorial.php?tutorialid=552
public class ServletToJSP extends HttpServlet { 
	
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  { 
	// HttpSession session = request.getSession();
	// session.invalidate();
	ArrayList<Product> myProductList = ProductsController.getProducts(null);
	request.setAttribute("productList", myProductList);
    RequestDispatcher rd = request.getRequestDispatcher("productPage.jsp");
    rd.forward(request, response);
  }  
}