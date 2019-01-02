package com.codecool.mogyorosibalin.typingameback.model;

import com.codecool.mogyorosibalin.typingameback.custom_enum.CharFeedback;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class TypingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Text text;
    private String userHash;
    @ElementCollection
    private List<CharFeedback> chars;
    private long timeSec;
    private Timestamp finishedTime;

    public TypingResult() { }

    public TypingResult(Text text, String userHash, List<CharFeedback> chars, long timeSec, Timestamp finishedTime) {
        this.text = text;
        this.userHash = userHash;
        this.chars = chars;
        this.timeSec = timeSec;
        this.finishedTime = finishedTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public List<CharFeedback> getChars() {
        return chars;
    }

    public void setChars(List<CharFeedback> chars) {
        this.chars = chars;
    }

    public long getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(int timeSec) {
        this.timeSec = timeSec;
    }

    public Timestamp getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Timestamp finishedTime) {
        this.finishedTime = finishedTime;
    }

}
