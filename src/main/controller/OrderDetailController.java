package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.model.Order;
import main.model.OrderDetail;
import main.service.OrderDetailService;
import main.service.OrderService;

@Controller
public class OrderDetailController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/order-detail-process-form")
    public String processOrderDetailData(@ModelAttribute OrderDetail orderDetail) {
        orderDetailService.saveOrUpdate(orderDetail);
        return "redirect:/show-order";
    }

    @GetMapping("/show-order-detail/{orderId}")
    public String showOrderDetail(@PathVariable long orderId, Model model) {
        Order order = orderService.getById(orderId);
        if(order != null) {
            model.addAttribute("order", order);
            return "order-detail";
        }
        return "redirect:/show-order";
    }

    @GetMapping("/edit-order-detail/{orderId}")
    public String editOrderDetail(@PathVariable long orderId, Model model) {
        Order order = orderService.getById(orderId);
        if(order != null) {
            model.addAttribute("orderDetail", order.getOrderDetails());
            return "order-detail-from";
        }
        System.out.println("test");
        return "redirect:/show-order";
    }

}
