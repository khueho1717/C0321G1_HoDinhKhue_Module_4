package com.example.complete_cart.controller;


import com.example.complete_cart.model.entity.Cart;
import com.example.complete_cart.model.entity.Product;
import com.example.complete_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/show/{id}")
    public ModelAndView showProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/show");
        Optional<Product> product=productService.findById(id);
        modelAndView.addObject("product", product.get());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("add")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("roll")){
            cart.divProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("remove")){
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        model.addAttribute("product",productOptional.get());
        cart.addProduct(productOptional.get());
        return "show";
    }

}
