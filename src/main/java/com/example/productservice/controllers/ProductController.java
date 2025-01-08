package com.example.productservice.controllers;


import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

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

    public Product deleteProduct(Long productId){
        return null;
    }

    //Patch --> http:localhost/8080/products/1(id)  --> we are sending the req body also (the product which we want to update and the updated value)
    @PatchMapping("/{id}")
    public Product updateProduct( @PathVariable("id") Long id, @RequestBody Product product){

        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product){
        return null;
    }

}
