package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Comment;
import main.model.Customer;
import main.service.CommentService;
import main.service.CustomerService;

@Controller
public class CommentController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/add-customer-comment")
	public String showCommentForm(Model model) {
		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);
		model.addAttribute("comment", new Comment());
		return "customer-form-comment";
	}
	
	@PostMapping("/process-customer-form-comment")
	public String addCommentData(@ModelAttribute Comment comment) {
		commentService.save(comment);
		return "home";
	}

}
