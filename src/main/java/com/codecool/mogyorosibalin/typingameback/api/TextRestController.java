package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.Text;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@RestController
public class TextRestController {

    @Autowired
    private TextRepository textRepository;

    @GetMapping("/texts/random")
    public Text getTextByRandom() {
        return textRepository.findRandom();
    }

}
