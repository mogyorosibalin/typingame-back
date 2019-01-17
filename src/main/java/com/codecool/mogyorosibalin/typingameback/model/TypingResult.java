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
    @OneToOne
    private Text text;
    private String userHash;
    @ElementCollection
    private List<CharFeedback> chars;
    private long timeMiliSec;
    private Timestamp finishedTime;
    private long points;

    public TypingResult() { }

    public TypingResult(Text text, String userHash, List<CharFeedback> chars, long timeMiliSec, Timestamp finishedTime, long points) {
        this.text = text;
        this.userHash = userHash;
        this.chars = chars;
        this.timeMiliSec = timeMiliSec;
        this.finishedTime = finishedTime;
        this.points = points;
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

    public long getTimeMiliSec() {
        return timeMiliSec;
    }

    public void setTimeMiliSec(long timeMiliSec) {
        this.timeMiliSec = timeMiliSec;
    }

    public Timestamp getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Timestamp finishedTime) {
        this.finishedTime = finishedTime;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

}
