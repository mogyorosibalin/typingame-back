package com.codecool.mogyorosibalin.typingameback.repository;

import com.codecool.mogyorosibalin.typingameback.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    ProductType findByType(String type);

}
