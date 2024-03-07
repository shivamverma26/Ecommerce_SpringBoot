package ecommerce.sprinboot.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ecommerce.sprinboot.library.dto.CategoryDto;
import ecommerce.sprinboot.library.dto.ProductDto;
import ecommerce.sprinboot.library.model.Category;
import ecommerce.sprinboot.library.model.Customer;
import ecommerce.sprinboot.library.model.ShoppingCart;
import ecommerce.sprinboot.library.service.CategoryService;
import ecommerce.sprinboot.library.service.CustomerService;
import ecommerce.sprinboot.library.service.ProductService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String index(Model model, Principal principal, HttpSession session){

        if(principal != null){
            session.setAttribute("username", principal.getName());
            Customer customer = customerService.findByUsername(principal.getName());
            ShoppingCart cart = customer.getShoppingCart();

            if (cart == null)
                session.setAttribute("totalItems", "0");
            else
                session.setAttribute("totalItems", cart.getTotalItems());

        }else{
            session.removeAttribute("username");
        }

        List<Category> categories = categoryService.findAll();
        List<ProductDto> productDtos = productService.findAll();
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        model.addAttribute("categoriesSeperate", categoryDtoList);
        model.addAttribute("categories", categories);
        model.addAttribute("products", productDtos);
        model.addAttribute("title", "JGPS - Jona General Purpose Shop");
        return "index";
    }
}
