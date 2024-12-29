package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeStoreProductService implements ProductService {

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }


}
