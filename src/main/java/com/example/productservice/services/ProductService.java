package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

     Product getSingleProduct(Long productId) throws ProductNotFoundException;

     List<Product> getAllProducts();

     Product updateProduct(Long productId, Product product) throws ProductNotFoundException;

     Product replaceProduct(long productId, Product product);

     void deleteProduct(Long productId);

     Product addNewProduct(Product product);

}
