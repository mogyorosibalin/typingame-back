package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.ProductType;
import com.codecool.mogyorosibalin.typingameback.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@RestController
public class ProductTypeRestController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/product-types")
    public List<ProductType> getProductTypes() {
        return productTypeRepository.findAll();
    }

}
