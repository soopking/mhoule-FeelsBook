package com.example.mhoule.mhoule_feelsbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MessageHolder extends ArrayList<EmotionMessage> {
    private File contextDirPath;

    public MessageHolder(File contextDirPath) {
        this.contextDirPath = contextDirPath;
        addAll(MessageDatabase.getFromDatabase(contextDirPath));
        sort();
    }

    private void saveToFile() {
        MessageDatabase.setDatabase(contextDirPath, this);
    }

    @Override
    public boolean add(EmotionMessage message) {
        Boolean result = super.add(message);
        sort();
        saveToFile();
        return result;
    }

    private void sort() {
        Collections.sort(this, new MessageComparator());
    }

    @Override
    public void add(int index, EmotionMessage element) {
        this.add(element);
    }

    @Override
    public EmotionMessage remove(int index) {
        EmotionMessage result = super.remove(index);
        saveToFile();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = super.remove(o);
        saveToFile();
        return result;
    }

    @Override
    public void clear() {
        super.clear();
        saveToFile();
    }

    public void replaceMessage(EmotionMessage message, int index) {
        remove(index);
        add(message);
    }
}
