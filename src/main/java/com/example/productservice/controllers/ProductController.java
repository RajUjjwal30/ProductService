package com.example.productservice.controllers;


import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {

    //instance of (object of) the FakeStoreProductService in the controller
    //instead of FakeStoreProductService .... we will make object of the Interface for loose coupling
    //but, we can not instantiate an Interface
    //dependency injection
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }


    @GetMapping()
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
}
