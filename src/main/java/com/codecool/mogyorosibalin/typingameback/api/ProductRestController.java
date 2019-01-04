package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import com.codecool.mogyorosibalin.typingameback.model.Text;
import com.codecool.mogyorosibalin.typingameback.repository.ProductRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TextRepository textRepository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}/texts")
    public List<Text> getProductTexts(@PathVariable("id") long id) {
        return this.textRepository.findByProduct(productRepository.findById(id));
    }

}
