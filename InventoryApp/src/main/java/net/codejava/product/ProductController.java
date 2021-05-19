package net.codejava.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.category.Category;
import net.codejava.category.CategoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		List<Category> listCategories = categoryRepo.findAll();
		
		model.addAttribute("product", new Product());
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(Product product) {
		productRepo.save(product);
		
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Product> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		return "products";
		
	}

}
