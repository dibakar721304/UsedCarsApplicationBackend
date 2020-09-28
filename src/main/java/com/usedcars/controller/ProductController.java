package com.usedcars.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usedcars.model.Vehicles;
import com.usedcars.service.ProductService;

@RestController
@RequestMapping("/api/vehicles")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
@CrossOrigin
    @GetMapping(value = { "", "/" })
    public @NotNull List<Vehicles> getProducts() {
        return productService.getAllProducts();
    }
}