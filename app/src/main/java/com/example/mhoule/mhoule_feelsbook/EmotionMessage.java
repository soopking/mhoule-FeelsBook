package com.example.mhoule.mhoule_feelsbook;

import java.util.Date;

public class EmotionMessage extends Message {
    private Emotion emotion;

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public EmotionMessage(String text, Date date, Emotion emotion) {
        super(text, date);
        this.emotion = emotion;
    }

    public EmotionMessage(String text, Emotion emotion) {
        super(text);
        this.emotion = emotion;
    }

    @Override
    public String toString() {
        if (getText().isEmpty()) {
            return getDate().toString() + " | " + getEmotion().toString();
        } else {
            return getDate().toString() + " | " + getEmotion().toString() + " | " + getText().toString();
        }

    }
}
