package com.codecool.mogyorosibalin.typingameback.service;

import com.codecool.mogyorosibalin.typingameback.custom_enum.CharFeedback;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Casting {

    public List<CharFeedback> castJsonArrayToCharFeedbackList(JSONArray from) {
        List<CharFeedback> to = new ArrayList<>();
        for (Object item : from) {
            to.add(CharFeedback.getCharFeedback((String) item));
        }
        return to;
    }

}
