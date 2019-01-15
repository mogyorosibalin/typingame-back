package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import com.codecool.mogyorosibalin.typingameback.model.ProductType;
import com.codecool.mogyorosibalin.typingameback.model.Text;
import com.codecool.mogyorosibalin.typingameback.repository.ProductRepository;
import com.codecool.mogyorosibalin.typingameback.repository.ProductTypeRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT })
@RestController
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TextRepository textRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAllByOrderById();
    }

    @GetMapping("/products/{id}/texts")
    public List<Text> getProductTexts(@PathVariable("id") long id) {
        return this.textRepository.findByProductOrderById(productRepository.findById(id));
    }

    @PostMapping("/products/new")
    public List<Product> newProduct(@RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        String type = (String) request.get("type");
        ProductType productType = productTypeRepository.findByType(type);
        if (productType == null) {
            productType = new ProductType(type);
            productTypeRepository.save(productType);
        }
        productRepository.save(new Product((String) request.get("name"), (String) request.get("author"), "", productType));
        return productRepository.findAllByOrderById();
    }

    @PutMapping("/products/{id}/edit")
    public List<Product> editProduct(@PathVariable("id") long id, @RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        Product product = productRepository.findById(id);
        product.setName((String) request.get("name"));
        product.setAuthor((String) request.get("author"));
        String type = (String) request.get("type");
        ProductType productType = productTypeRepository.findByType(type);
        if (productType == null) {
            productType = new ProductType(type);
            productTypeRepository.save(productType);
        }
        product.setProductType(productType);
        productRepository.save(product);
        return productRepository.findAllByOrderById();
    }

}
