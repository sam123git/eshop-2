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

import main.model.Order;
import main.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/add-order")
	public String showForm(Model model) {
		model.addAttribute("order", new Order());
		return "order-form";
	}
	
	@PostMapping("/order-process-form")
	public String showOrderData(@Valid @ModelAttribute Order order, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "order-form";
		}
		orderService.saveOrUpdate(order);
		return "redirect:show-order";
	}

	@GetMapping("/show-order")
	public String getOrders(Model model) {
		List<Order> orders = orderService.getAll();
		model.addAttribute("orders", orders);
		return "orders";
	}

	@GetMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable long orderId) {
		Order order = orderService.getById(orderId);
		if(order != null) {
			orderService.delete(orderId);
		}
		return "redirect:/show-order";
	}

	@GetMapping("/edit-order/{orderId}")
	public String editOrder(@PathVariable long orderId, Model model) {
		Order order = orderService.getById(orderId);
		if(order != null) {
			model.addAttribute("order", order);
			return "order-form";
		}
		return "redirect:/show-order";
	}

}
