package ecommerce.sprinboot.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.sprinboot.library.model.Category;
import ecommerce.sprinboot.library.service.CategoryService;

import java.security.Principal;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String categories(Model model, Principal principal){

        if(principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("size", categories.size());
        model.addAttribute("title", "JGPS - Category");
//        model.addAttribute("categoryNew", new Category());
        return "categories";
    }

    @GetMapping("/new-category")
    public String newCategoryPage(Model model, Principal principal) {
        if(principal == null){
            return "redirect:/login";
        }
        model.addAttribute("title", "JGPS - New Category");
        model.addAttribute("categoryNew", new Category());
        return "new-category";
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String add(@ModelAttribute("categoryNew") Category category, RedirectAttributes attributes){
        try {
            categoryService.save(category);
            attributes.addFlashAttribute("success", "Added successfully");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to add because duplicate name");
        }
        catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/categories";
    }

    @RequestMapping("/editCategory/{id}")
    public ModelAndView showEditCategoryPage(@PathVariable("id") long id, Model model, Principal principal) {
            ModelAndView modelAndView;
        if(principal != null) {
            modelAndView = new ModelAndView("update-category");
            Category category = categoryService.findById(id);
            modelAndView.addObject(category);
            model.addAttribute("title", category.getName() + " Edit");
            return modelAndView;
        } else {
            return (new ModelAndView("sign-in"));
        }
    }

    @GetMapping("/update-category")
    public String update(Category category, RedirectAttributes attributes, Principal principal){

        if(principal == null){
            return "redirect:/login";
        }

        try {
            categoryService.update(category);
            attributes.addFlashAttribute("success","Updated successfully");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to update because duplicate name");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/hide-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String hide(Long id, RedirectAttributes attributes){
        try {
            categoryService.hideById(id);
            attributes.addFlashAttribute("success", "Hide successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to Hide");
        }
        return "redirect:/categories";
    }

    @RequestMapping(value = "/visible-category", method = {RequestMethod.PUT, RequestMethod.GET})
    public String visible(Long id, RedirectAttributes attributes){
        try {
            categoryService.enabledById(id);
            attributes.addFlashAttribute("success", "Visible successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to visible");
        }
        return "redirect:/categories";
    }

    @RequestMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            categoryService.deleteById(id);
            attributes.addFlashAttribute("success", "Delete successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to delete");
        }

        return "redirect:/categories";
    }
}
