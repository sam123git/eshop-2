package main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import main.model.Cart;
import main.model.Product;
import main.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;

    @Autowired
    private ProductService productService;

	@GetMapping(value = "showProduct")
	public String getProduct(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "product";
	}
	
	@GetMapping(value = "add-product")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
	@PostMapping(value = "process-product-form")
	public String showProductData(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "product-form";
		}
		productService.saveOrUpdate(product);
		return "redirect:show-products";
	}
	
	@GetMapping(value = "show-products")
	public String getProducts(Model model) {
        List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "product";
	}

    @GetMapping(value = "edit-products/{productId}")
    public String editProduct(@PathVariable long productId, Model model) {
        Product brand = productService.getById(productId);
        if (brand != null) {
            model.addAttribute("product", brand);
            return "product-form";
        }
        return "redirect:/show-product";
    }

    @GetMapping(value = "add-product-to-cart")
    public String addBrand(Model model) {
        model.addAttribute("product", new Cart());
        return "product-form";
    }

    @PostMapping(value = "process-product-brand-form")
    public String showBrandDetail(Product product) {
        return "product-form";
    }

    @GetMapping(value = "delete-product/{productId}")
    public String deleteProduct(@PathVariable long productId) {
        Product cart = productService.getById(productId);
        if (cart != null) {
            productService.delete(productId);
        }
        return "redirect:/show-product";
    }
}
