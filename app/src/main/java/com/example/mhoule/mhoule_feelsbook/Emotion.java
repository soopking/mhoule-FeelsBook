package com.example.mhoule.mhoule_feelsbook;

public abstract class Emotion {
    private String emotion;

    public Emotion() {
        this.emotion = getEmotion();
    }

    abstract public String getEmotion();

    @Override
    public String toString() {
        return emotion;
    }
}
