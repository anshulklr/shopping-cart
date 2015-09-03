package com.emc.shoppingcart;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emc.shoppingcart.dao.ProductDao;
import com.emc.shoppingcart.dao.ProductDaoImpl;
import com.emc.shoppingcart.dao.UserDaoImpl;
import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.model.User;
import com.emc.shoppingcart.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	ProductDao product;
	@Autowired
	UserService createService ;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		/*Product product1=new Product(2,"testproduct1",1,10,100,"test product1");
		product.insertProduct(product1);
		*/
		//Product product1=new Product();
		List<Product> CrunchifyList = new ArrayList<Product>();
		CrunchifyList = product.getAllProducts();
		for (Product prod : CrunchifyList) {
			System.out.println(prod.getpName());
		}
		//product.deleteProduct(1);
		
		/*Product product2=new Product(2,"testproduct2",2,50,1000,"test product1");
		product.updateProduct(product2,2);
*/		
		
		//User user=new User("utkarsh", "bhardwaj", "utkarsh@admin.com", "bangalore", "", "bangalore", "karnataka", "India", 1234,"admin",2);
		
		//createService.createAdmin(user);
		return "home";
	}
	
	/*@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "submitLogin";
	}*/
	
}
