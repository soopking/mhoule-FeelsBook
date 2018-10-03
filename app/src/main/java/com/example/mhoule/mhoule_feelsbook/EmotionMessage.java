package com.example.mhoule.mhoule_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmotionMessage extends Message {
    private Emotion emotion;

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public EmotionMessage(String text, Date date, Emotion emotion) throws MessageTooLongException {
        super(text, date);
        this.emotion = emotion;
    }

    public EmotionMessage(String text, Emotion emotion) throws MessageTooLongException {
        super(text);
        this.emotion = emotion;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);

        if (getText().isEmpty()) {
            return simpleDateFormat.format(this.getDate()) + " | " + getEmotion().toString();
        } else {
            return simpleDateFormat.format(this.getDate()) + " | " + getEmotion().toString() + " | " + getText();
        }

    }

    @Override
    public boolean equals(Object obj) {
        EmotionMessage emotionMessage;
        if (obj.getClass().equals(this.getClass())) {
            emotionMessage = (EmotionMessage) obj;
            return emotionMessage.emotion.equals(this.emotion) && super.equals(emotionMessage);
        }
        return false;
    }
}
