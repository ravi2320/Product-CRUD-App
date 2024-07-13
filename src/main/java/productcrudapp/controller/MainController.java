package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productdao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productdao.getAllProducts();
		m.addAttribute("products", products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	} 
	
	@RequestMapping(value = "/handel-product", method = RequestMethod.POST)
	public RedirectView handleForm(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productdao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int pid, HttpServletRequest request) {
		this.productdao.deleteProduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//update handler
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable("productId") int pid, Model model) {
		Product product = this.productdao.getProduct(pid);
		model.addAttribute("product", product);
		return "update_product_form";
		
	}
}
