package com.example.mhoule.mhoule_feelsbook;

public class Emotion {
    private String emotion;

    public Emotion() {
        this.emotion = getEmotion();
    }

    public String getEmotion() {
        return emotion;
    };

    @Override
    public String toString() {
        return emotion;
    }
}
