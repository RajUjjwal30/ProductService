package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        //calling FakeStore to fetch the product with given ID:
        //http request
        //using restTemplate object
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );
        //converting FakeStoreSto to Product(our return type)


        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){



        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());

        product.setCategory(category);

        return product;
    }


}
