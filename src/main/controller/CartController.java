package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import main.model.Cart;
import main.service.CartService;

/**
 * 購物車控制器
 * @author sam
 *
 */

@Controller
public class CartController {
	
	@Autowired
	RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;

	@Autowired
    private CartService cartService;
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/show-cart")
	public String showCart(Model model) {
        List<Cart> carts = cartService.getAll();
		model.addAttribute("carts", carts);
		return "cart";
	}
	
	/**
	 * @param cartId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit-cart/{cartId}")
    public String editCart(@PathVariable long cartId, Model model) {
        Cart cart = cartService.getById(cartId);
		if(cart != null) {
			model.addAttribute("cart", cart);
			return "cart-form";
		}
		return "redirect:/show-cart";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/add-cart")
	public String addCart(Model model) {
		model.addAttribute("cart", new Cart());
		return "cart-form";
	}
	
	/**
	 * @param cart
	 * @return
	 */
	@PostMapping("/process-cart-form")
	public String showCartDetail(Cart cart) {
		return "cart-form";
	}
	
	/**
	 * @param cartId
	 * @return
	 */
	@GetMapping("/delete-cart/{cartId}")
	public String deleteCart(@PathVariable long cartId) {
        Cart cart = cartService.getById(cartId);
		if (cart != null) {
            cartService.delete(cartId);
		}
		return "redirect:/show-cart";
	}
}
