package main.controller;

import java.security.Principal;
//import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import main.model.Customer;
import main.service.CustomerService;

/**
 * 客戶控制器
 * @author sam
 *
 */
@Controller
public class CustomerController {
	
		@Autowired
		RequestMappingInfoHandlerMapping requestMappingInfoHandlerMapping;
	
		@Autowired
		private CustomerService customerService;
		
		/**
		 * @param model
		 * @return
		 */
		@GetMapping("/add-customer")
		public String showForm(Model model) {
			model.addAttribute("customer", new Customer());
			return "customer-form";		
		}
		
		/**
		 * @param customer
		 * @param bindingResult
		 * @return
		 */
		@PostMapping("/process-customer-form")
		public String showCustomerData(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "customer-form";
			}
			customerService.saveOrUpdate(customer);
			return "redirect:show-customer-data";
		}
		
		/**
		 * @param model
		 * @return
		 */
		@GetMapping("/show-customer-data")
		public String getCustomers(Model model) {
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
			return "customers";
		}
		
		/**
		 * @param customerId
		 * @return
		 */
		@GetMapping("/delete-customer/{customerId}")
		public String deleteCustomer(@PathVariable("customerId") long customerId) {
			Customer customer = customerService.getById(customerId);
			if(customer != null) {
				customerService.delete(customerId);
			}
			return "redirect:/show-customer-data";
		}
		
		/**
		 * @param customerId
		 * @param model
		 * @return
		 */
		@GetMapping("/edit-customer/{customerId}")
		public String editCustomer(@PathVariable("customerId") long customerId, Model model) {
			Customer customer = customerService.getById(customerId);
			if(customer != null) {
				model.addAttribute("customer", customer);
				return "customer-form";
			}
			return "redirect:/show-customer-data";
		}
		
		/**
		 * @param customerId
		 * @param principal
		 * @return
		 */
		@GetMapping("/add-user-to-customer/{customerId}")
		public String addUserToCustomer(@PathVariable long customerId, Principal principal) {
			customerService.addUserToCustomer(customerId, principal.getName());
			return "redirect:/show-customer-data";
		}
		
//		@GetMapping("/add-user-to-customer/{customerId}/{userId}")
//		public String addUserToCustomer(@PathVariable long customerId, @PathVariable long userId) {
//			customerService.addUserToCustomer(customerId, userId);
//			return "redirect:/show-customer-data";
//		}
		
		/**
		 * @return
		 */
		@RequestMapping("/customer-home")
		public String getCustomerHome() {
			return "home";
		}
	
	
}



