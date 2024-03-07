package ecommerce.sprinboot.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.sprinboot.library.model.Customer;
import ecommerce.sprinboot.library.service.CustomerService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/account")
    public String accountHome(Model model , Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        model.addAttribute("title", customer.getFirstName() + " account");

        model.addAttribute("customer", customer);

        return "profile-info";
    }

    @RequestMapping(value = "/update-infor", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCustomer(
            @ModelAttribute("customer") Customer customer,
            Model model,
            RedirectAttributes redirectAttributes,
            Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        Customer customerSaved = customerService.saveInfor(customer);

        redirectAttributes.addFlashAttribute("customer", customerSaved);

        model.addAttribute("customer", customerSaved);


        return "redirect:/account";
    }
}
