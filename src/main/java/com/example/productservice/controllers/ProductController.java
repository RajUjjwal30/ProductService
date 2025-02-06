package com.example.productservice.controllers;


import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//while injecting the bean using @Qualifier(Best to use) to tell springboot to use which implementation
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        ResponseEntity<Product> response = new ResponseEntity<>(
                    productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return response;
    }


    @GetMapping()
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
          productService.deleteProduct(productId);
    }

    //Patch --> http:localhost/8080/products/1(id)  --> we are sending the req body also (the product which we want to update and the updated value)
    @PatchMapping("/{id}")
    public Product updateProduct( @PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {

        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleArithmeticException(){
//
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "Arithmetic Exception has occurred, inside the Product Controller !",
//                HttpStatus.INTERNAL_SERVER_ERROR
//        ) ;
//
//        return response;
//    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

}
