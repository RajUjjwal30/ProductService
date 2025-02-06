package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//for telling springboot to use which implementation out of 2 implementations (2nd method is @Qualifier)
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //make a call to db to fetch product with given id;
//using Optional to avoid NPE .
        Optional<Product> productOptional =  productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id "+ productId + " not found");
        }
        //Product product = productOptional.get();
        return productOptional.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("product with given id :" + productId + " not found !");
        }

        Product productInDB = productOptional.get();

        if(product.getTitle() !=  null){
            productInDB.setTitle(product.getTitle());
        }
        if(product.getPrice() != 0.0){
            productInDB.setPrice(product.getPrice());
        }

        return productRepository.save(productInDB);
    }

    @Override
    public Product replaceProduct(long productId, Product product) {
        return null;
    }


    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product addNewProduct(Product product) {

        Category category = product.getCategory();
        if(category.getId() == null){
            //we need to create a new category object in the DB first.

            category = categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product) ;
    }


}
