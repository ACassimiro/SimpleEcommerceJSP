package Files;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsController {
	
	public static ArrayList<Product> getProducts (String name){
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
            URL url = ProductsController.class.getResource("products.txt");
            File file = new File(url.getPath());
            
            Scanner input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineData = line.split("-");
                if (lineData.length == 3) {
                	Product prod = new Product(lineData[0], Double.parseDouble(lineData[1]), "images/" + lineData[2]);
                	
                	if (name != null && name != "") {
                		if (lineData[0].toLowerCase().indexOf(name.toLowerCase()) != -1) {
                			products.add(prod);
                		}
                		
                	} else {
                		products.add(prod);
                	}
                }
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return products;
		
	}

}
