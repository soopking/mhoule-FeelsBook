package com.example.mhoule.mhoule_feelsbook;

import java.util.ArrayList;
import java.util.Collections;

public class MessageHolder extends ArrayList<Message> {

    public MessageHolder() {
        addAll(MessageDatabase.getFromDatabase());
        sort();
    }

    private void saveToFile() {
        MessageDatabase.setDatabase(this);
    }

    @Override
    public boolean add(Message message) {
        Boolean result = super.add(message);
        sort();
        saveToFile();
        return result;
    }

    private void sort() {
        Collections.sort(this, new MessageComparator());
    }

    @Override
    public void add(int index, Message element) {
        this.add(element);
    }

    @Override
    public Message remove(int index) {
        Message result = super.remove(index);
        saveToFile();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = super.remove(o);
        saveToFile();
        return result;
    }

    public void replaceMessage(Message message, int index) {
        remove(index);
        add(message);
    }
}
