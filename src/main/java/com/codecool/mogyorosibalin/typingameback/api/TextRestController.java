package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.Product;
import com.codecool.mogyorosibalin.typingameback.model.Text;
import com.codecool.mogyorosibalin.typingameback.model.TypingResult;
import com.codecool.mogyorosibalin.typingameback.repository.ProductRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TypingResultRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
public class TextRestController {

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TypingResultRepository typingResultRepository;

    @GetMapping("/texts/random")
    public Text getTextByRandom() {
        return textRepository.findRandom();
    }

    @PostMapping("/texts/new")
    public Text newText(@RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        Product product = productRepository.findById((long) request.get("productId"));
        String textString = (String) request.get("text");
        Text text = new Text(product, textString);
        textRepository.save(text);
        return text;
    }

    @PutMapping("/texts/{id}/edit")
    public Text editText(@PathVariable("id") long id, @RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        String textString = (String) request.get("text");
        Text text = textRepository.findById(id);
        text.setText(textString);
        textRepository.save(text);
        return text;
    }

    @DeleteMapping("/texts/{id}/delete")
    public String deleteText(@PathVariable("id") long id) {
        List<TypingResult> typingResults = typingResultRepository.findByTextId(id);
        for (TypingResult typingResult : typingResults) {
            this.typingResultRepository.delete(typingResult);
        }
        textRepository.delete(textRepository.findById(id));
        return null;
    }

}
