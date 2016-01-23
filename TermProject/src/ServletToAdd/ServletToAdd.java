package ServletToAdd;

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
public class ServletToAdd extends HttpServlet { 
	
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  { 
    
	ArrayList<Product> myProductList = ProductsController.getProducts(null);
	request.setAttribute("productList", myProductList);
	HttpSession session = request.getSession();
    ArrayList<Product> cart;
    
    if(request.getParameter("clearSession") != null){
    	session.invalidate();
        response.sendRedirect("ServletToJSP");
        return;
	}
    
	if(request.getParameter("doCheckout") != null){
		 if(session.getAttribute("onCart") == null){
	    	cart = new ArrayList<Product>();
	     } else {
	     	cart = (ArrayList) session.getAttribute("onCart");
	     }
		 request.setAttribute("onCart", cart);
		    		
		RequestDispatcher rd = request.getRequestDispatcher("ServletToCheckout");
	    rd.forward(request, response);
	}
	    
    if(session.getAttribute("onCart") == null){
    	cart = new ArrayList<Product>();
    } else {
    	cart = (ArrayList) session.getAttribute("onCart");
    }
    
    
    Product entry = new Product(request.getParameter("prod"), Double.parseDouble(request.getParameter("price")), request.getParameter("image"));
    
    cart.add(entry);    
    
    request.setAttribute("onCart", cart);
    
    RequestDispatcher rd = request.getRequestDispatcher("productPage.jsp");
    rd.forward(request, response);
  }  
}