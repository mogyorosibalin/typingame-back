package com.codecool.mogyorosibalin.typingameback.repository;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderById();

    Product findById(long id);
    Product findByName(String name);

}
