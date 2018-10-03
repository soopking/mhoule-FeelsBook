package com.example.mhoule.mhoule_feelsbook;

public class Emotion {
    private String emotion;

    static boolean checkEmotion(Emotion emotion, Emotion toMatch) {
        if (toMatch.getEmotion().equals(emotion.getEmotion())) {
            return true;
        }
        return false;
    }

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
