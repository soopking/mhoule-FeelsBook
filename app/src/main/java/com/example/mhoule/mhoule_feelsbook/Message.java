package com.example.mhoule.mhoule_feelsbook;

import java.util.Date;

public abstract class Message {
    private String text;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) throws MessageTooLongException {
        if (text.length() > 100) {
            throw new MessageTooLongException();
        }
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Message(String text, Date date) throws MessageTooLongException {
        setText(text);
        setDate(date);
    }

    public Message(String text) throws MessageTooLongException {
        setText(text);
        setDate(new Date());
    }
    public Message() {
        try {
            setText("");
        } catch (MessageTooLongException e) {
            e.printStackTrace();
        }
        setDate(new Date());
    }

    abstract public String toString();
}
