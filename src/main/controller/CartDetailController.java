package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import javassist.expr.NewArray;
import main.model.Cart;
import main.model.CartDetail;
import main.model.Order;
import main.repository.CartRepository;
import main.service.CartDetailService;
import main.service.CartService;

/**
 * 購物車控制器
 * @author sam
 *
 */
@Controller
public class CartDetailController {
	
	@Autowired
	RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;

	@Autowired
	private CartDetailService cartDetailService;
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/show-cart-detail")
	public String showCartDetail(Model model) {
		List<CartDetail> carts = cartDetailService.getAll();
		model.addAttribute("cartDetails", carts);
		return "cart-detail";
	}
	
	/**
	 * @param orderId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit-cart-detail/{cartDetailId}")
	public String editCartDetail(@PathVariable long orderId, Model model) {
		CartDetail cartDetail = cartDetailService.getById(orderId);
		if(cartDetail != null) {
			model.addAttribute("cartDetail", cartDetail);
			return "cart-detail-form";
		}
		return "redirect:/show-cart-detail";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/add-cart-detail")
	public String addCartDetail(Model model) {
		model.addAttribute("cartDetail", new Cart());
		return "cart-detail-form";
	}
	
	/**
	 * @param cartDetail
	 * @return
	 */
	@PostMapping("/process-cart-detail-form")
	public String showCartDetail(CartDetail cartDetail) {
		return "cart-detail-form";
	}
	
	/**
	 * @param cartDetailId
	 * @return
	 */
	@GetMapping("/delete-cart-detail/{cartDetailId}")
	public String deleteCartDetail(@PathVariable long cartDetailId) {
		CartDetail cartDetail = cartDetailService.getById(cartDetailId);
		if (cartDetail != null) {
			cartDetailService.delete(cartDetailId);
		}
		return "redirect:/show-cart-detail";
	}
}
