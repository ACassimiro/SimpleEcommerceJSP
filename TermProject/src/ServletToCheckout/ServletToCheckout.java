package ServletToCheckout;

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
import java.util.HashMap;
import java.util.Map;

// http://www.java-samples.com/showtutorial.php?tutorialid=552
public class ServletToCheckout extends HttpServlet { 
	
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  { 
	  	HttpSession session = request.getSession();
	  	
	ArrayList<Product> myProductList;
	if(session.getAttribute("onCart") == null){
		myProductList = new ArrayList<Product>();
    } else {
    	myProductList = (ArrayList<Product>) session.getAttribute("onCart");
    }
	
	Map<String, Integer> mapProd = new HashMap<String, Integer>();
	
	
	double price = 0.0;
	for (int i = 0; i < myProductList.size();i++) {
		Product p = myProductList.get(i);
		if (mapProd.get(p.getName()) != null) {
			
			mapProd.put(p.getName(), mapProd.get(p.getName()) + 1);
		} else {
			mapProd.put(p.getName(), 1);
		}
		
		price += p.getPrice();
	}
	
	ArrayList<Product> listAmount = new ArrayList<Product>();
	
	for (int i = 0; i < myProductList.size();i++) {
		Product p = myProductList.get(i);
		if (mapProd.get(p.getName()) != null) {
			p.setAmount(mapProd.get(p.getName()));
			p.setPrice(p.getPrice() * (double) p.getAmount());
			listAmount.add(p);
			mapProd.remove(p.getName());
		}
	}
	
	request.setAttribute("productList", listAmount);
	request.setAttribute("price", price);
    RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
    rd.forward(request, response);
  }  
}