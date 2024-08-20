package com.samsung.basicsecurity.controller;

import com.samsung.basicsecurity.repositories.models.Catalog;
import com.samsung.basicsecurity.repositories.models.Product;
import com.samsung.basicsecurity.services.ProductService;
import com.samsung.basicsecurity.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ProductService productService;

    @GetMapping("/catalogs")
    public String listCatalogs(Model model) {
        List<Catalog> catalogs = catalogService.getAllCatalogs();
        model.addAttribute("catalogs", catalogs);
        return "catalog/list";
    }

    @GetMapping("/catalog/products")
    public String listProductsByCatalog(@RequestParam("catalogId") Long catalogId, Model model) {
        List<Catalog> products = productService.getProductsByCatalog(catalogId);
        Catalog catalog = catalogService.getCatalogById(catalogId);
        model.addAttribute("products", products);
        model.addAttribute("catalog", catalog);
        return "catalog/products";
    }

    @GetMapping("/catalog/all")
    public String listAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("catalog", "All Products"); // To identify the "All" catalog
        return "catalog/products";
    }
}
