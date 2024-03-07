package ecommerce.sprinboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.sprinboot.library.model.Complain;
import ecommerce.sprinboot.library.service.ComplainService;

import java.security.Principal;
import java.util.List;

@Controller
public class ComplainController {

    @Autowired
    private ComplainService complainService;


    @GetMapping("/complains")
    public String getComplains(Model model, Principal principal) {

        if (principal == null)
            return "redirect:/login";

        List<Complain> complains = complainService.listAll();
        model.addAttribute("complains", complains);
        model.addAttribute("title", "All Complains");
        model.addAttribute("size", complains.size());

        return "complains";
    }

    @RequestMapping("/complain-update-status/{id}")
    public String complainUpdateStatus(@PathVariable("id") long id, RedirectAttributes attributes, Principal principal) {

        if (principal == null)
            return "redirect:/login";

        complainService.updateStatus(id);
        attributes.addFlashAttribute("success", "Your Complain Status is updated successfully!");
        return "redirect:/complains";
    }
}
