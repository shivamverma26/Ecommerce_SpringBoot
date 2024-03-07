package ecommerce.sprinboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;


@Controller
public class AdminController {
    @GetMapping("/")
    public String index(Model model,
                        HttpSession session,
                        Principal principal) {

        if(principal == null)
            return "redirect:/login";

        session.setAttribute("username", principal.getName());
        return "categories";
    }
}
