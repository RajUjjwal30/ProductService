package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //ProductRepository extends JpaRepository<>, here ProductRepo and Jpa do not know about each other
    // so, in <,> this we need to give the model. it takes 2 inputs. 1st model name with which jpa
    //wants to interact and 2nd Primary key of this table.
    //why Long not long --> using wrapper class so that we can use methods on top of it;

    //Product Repo should contain all the methods(CRUD) related to Product model

    List<Product> findByPriceIsGreaterThan(Double price);
    //select * from products where price > ?

    List<Product> findProductByTitleLike(String word);
    //select * from products where title like '%iphone%'

    List<Product> findProductByTitleLikeIgnoreCase(String word);

    List<Product> findTop5ByTitleContains(String word);

    List<Product> findProductsByTitleContainsIgnoreCaseAndPriceGreaterThan(String word, Double price);

    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll(Sort sort);


    //HQL(Hibernate Query Language)
            //what will be the return type when you are only selecting id and title ??
                //if you want to pass parameter then :x
    @Query("select p.id as id , p.title as title from Product p ")// :x
    List<ProductWithIdAndTitle> randomSearchMethod();// x
}

/*
1.Repository should be an Interface.
2.Repository should extend JPARepository.
 */
