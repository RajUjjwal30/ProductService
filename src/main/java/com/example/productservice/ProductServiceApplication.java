package com.example.productservice;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication



public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);


        Product product = new Product();

        product.setPrice(56.0);
        
        System.out.println(product.getPrice());
    }


}
