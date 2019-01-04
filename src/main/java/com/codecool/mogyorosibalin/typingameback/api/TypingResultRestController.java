package com.codecool.mogyorosibalin.typingameback.api;

import com.codecool.mogyorosibalin.typingameback.model.TypingResult;
import com.codecool.mogyorosibalin.typingameback.repository.TextRepository;
import com.codecool.mogyorosibalin.typingameback.repository.TypingResultRepository;
import com.codecool.mogyorosibalin.typingameback.service.Casting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS, RequestMethod.POST })
@RestController
public class TypingResultRestController {

    @Autowired
    private TypingResultRepository typingResultRepository;

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private Casting casting;

    @PostMapping("/typing-results/save")
    public List<TypingResult> saveTypingResult(@RequestBody String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject request = (JSONObject) parser.parse(body);
        typingResultRepository.save(new TypingResult(
                textRepository.findById((long) request.get("textId")),
                (String) request.get("userHash"),
                casting.castJsonArrayToCharFeedbackList((JSONArray) request.get("chars")),
                Math.round((long) request.get("time") / 1000),
                new Timestamp(System.currentTimeMillis())
        ));
        return typingResultRepository.findByUserHash((String) request.get("userHash"));
    }

    @GetMapping("/typing-results/{userHash}")
    public List<TypingResult> getTypingResults(@PathVariable("userHash") String userHash) {
        return typingResultRepository.findByUserHash(userHash);
    }

}
