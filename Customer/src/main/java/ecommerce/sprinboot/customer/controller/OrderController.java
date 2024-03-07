package ecommerce.sprinboot.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.sprinboot.library.model.Customer;
import ecommerce.sprinboot.library.model.Order;
import ecommerce.sprinboot.library.model.ShoppingCart;
import ecommerce.sprinboot.library.service.CustomerService;
import ecommerce.sprinboot.library.service.OrderService;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Controller
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/check-out")
    public String checkout(Model model, Principal principal){

        if(principal == null){
            return "redirect:/login";
        }

        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
//        if(customer.getPhoneNumber().trim().isEmpty() || customer.getAddress().trim().isEmpty() || customer.getCity().trim().isEmpty() || customer.getCountry().trim().isEmpty() || customer.getPhoneNumber() == null){
        if(customer.getPhoneNumber() == null || customer.getAddress() == null || customer.getFirstName() == null || customer.getLastName() == null || customer.getCity() == null || customer.getCountry() == null) {
            model.addAttribute("customer", customer);
            model.addAttribute("error", "You must fill the information after checkout!");
            return "profile-info";
        }else{
            model.addAttribute("customer", customer);
            ShoppingCart cart = customer.getShoppingCart();

            if (cart == null)
                return "redirect:/products";

            model.addAttribute("cart", cart);
            model.addAttribute("discountPrice", customerService.calculateDiscount(cart.getTotalPrices()));
        }
        model.addAttribute("title", "Order Check Out");
        return "checkout";
    }

    @GetMapping("/order")
    public String order(Principal principal, Model model){

        if (principal == null)
            return "redirect:/login";

        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        List<Order> orderList = customer.getOrders();
        model.addAttribute("orderList", orderList);
        model.addAttribute("title", customer.getFirstName() + " orders");
        model.addAttribute("customer", customer);

        return "my-order";
    }

    @GetMapping("/save-order")
    public String saveOrder(Principal principal, Model model) {

        if (principal == null)
            return "redirect:/login";

        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        ShoppingCart cart = customer.getShoppingCart();

        if (cart == null)
            return "redirect:/products";

        model.addAttribute("title", "Complete Order");
        orderService.saveOrder(cart);

        return "complete-order";
    }

    @RequestMapping(value = "/order-payment/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String orderPayment(@PathVariable("id") Long id,
                               Principal principal,
                               Model model,
                               RedirectAttributes attributes) {
        if(principal == null){
            return "redirect:/login";
        }

        Order order = orderService.get(id);

        if (!Objects.equals(order.getPaymentStatus(), "SUCCESSFUL") && !Objects.equals(order.getOrderStatus(), "ACCEPTED")) {
            attributes.addFlashAttribute("error", "Order not accepted yet or order payment done.");
            return "redirect:/order";
        }

        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        model.addAttribute("title", customer.getFirstName() + " order");
        model.addAttribute("order", order);
        model.addAttribute("customer", customer);

        return "my-order-payment";
    }

    @PostMapping("/order-payment/{id}")
    public String processUpdate(@PathVariable("id") Long id,
                                @ModelAttribute("order") Order order,
                                RedirectAttributes attributes,
                                Principal principal){
        if(principal == null)
            return "redirect:/login";

        if (Objects.equals(order.getPaymentType(), "ONLINE")) {
            if (order.getTransitionId() == null) {
                attributes.addFlashAttribute("error", "Please fill the transition id");
                return "redirect:/order-payment/"+id;
            }
        }

        orderService.updatePayment(order);
        attributes.addFlashAttribute("success", "Payment successful");

        return "redirect:/order";

    }

    @RequestMapping(value = "/cancel-order/{id}", method = {RequestMethod.PUT , RequestMethod.GET})
    public String cancelOrder(@PathVariable("id")Long id, RedirectAttributes attributes){
        try {
            Order order = orderService.get(id);
            if (Objects.equals(order.getOrderStatus(), "ACCEPTED")) {
                attributes.addFlashAttribute("error", "Order is already Accepted");
            } else {
                orderService.cancelOrder(id);
                attributes.addFlashAttribute("success", "Order Successfully Canceled!");
            }
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Failed to Canceled!");
        }
        return "redirect:/order";
    }
}
