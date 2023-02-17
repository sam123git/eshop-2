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

import main.model.Orders;
import main.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/addOrder")
	public String showForm(Model model) {
		model.addAttribute("orders", new Orders());
		return "form";
	}
	
	@PostMapping("/processForm")
	public String showOrderData(@Valid @ModelAttribute Orders orders, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		orderService.saveOrUpdate(orders);
		return "redirect:showOffer";
	}
	
	@GetMapping("/showOffer")
	public String getOrders(Model model) {
		List<Orders> orderss = orderService.getAll();
		model.addAttribute("orderss", orderss);
		return "orders";
	}
	
	@GetMapping("/deleteOrder/{ord_num}")
	public String deleteOrder(@PathVariable long ord_num) {
		Orders orders = orderService.getById(ord_num);
		if(orders != null) {
			orderService.delete(ord_num);
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/editOrder/{ord_num}")
	public String editOrder(@PathVariable long ord_num, Model model) {
		Orders orders = orderService.getById(ord_num);
		if(orders != null) {
			model.addAttribute("orders", orders);
			return "form";
		}
		return "redirect:/showOffer";
	}

}
