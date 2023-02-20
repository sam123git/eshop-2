package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Customer;
import main.model.CustomerDetails;
import main.service.CustomerDetailsService;
import main.service.CustomerService;

@Controller	
public class CustomerDetailsController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@GetMapping("/show-customer-details/{customerId}")
	public String showCustomerDetail(@PathVariable long customerId, Model model) {
		Customer customer = customerService.getByIdWithComments(customerId);
		if(customer != null) {
			customerService.addCustomerDetailsIfNotExists(customer);
			model.addAttribute("customer", customer);
			return "customer-details";
		}
		return "redirect:/show-customer-data";
	}
	
	@GetMapping("/edit-customer-details/{customerId}")
	public String editCustomerDetails(@PathVariable long customerId, Model model) {
		Customer customer = customerService.getById(customerId);
		if(customer != null) {
			customerService.addCustomerDetailsIfNotExists(customer);
			model.addAttribute("customerDetails", customer.getCustomerDetails());
			return "form-customer-details";
		}
		return "redirect:/show-customer-data";
	}
	
	@PostMapping("/process-form-customer-details")
	public String processCustomerDetailsData(@ModelAttribute CustomerDetails customerDetails) {
		customerDetailsService.saveOrUpdate(customerDetails);
		return "redirect:/show-customer-data";
	}

}
