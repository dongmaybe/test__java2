package com.samsung.basicsecurity.controller;

import org.springframework.ui.Model;
import com.samsung.basicsecurity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String listProducts(Model model, @RequestParam(required = false) String search) {
        if (search != null) {
            model.addAttribute("products", productService.searchProducts(search));
        } else {
            model.addAttribute("products", productService.getAllProducts());
        }
        model.addAttribute("catalogs", productService.getAllCatalogs());
        return "product/list";
    }
}
