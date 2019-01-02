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
        for (int i = 0; i < from.size(); i++) {
            to.add(CharFeedback.fromInteger(Math.toIntExact((long)from.get(i))));
        }
        return to;
    }

}
