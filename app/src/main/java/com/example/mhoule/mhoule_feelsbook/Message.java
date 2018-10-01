package com.example.mhoule.mhoule_feelsbook;

import java.util.Date;

public abstract class Message {
    private String text;
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Message(String text, Date date) {
        setText(text);
        setDate(date);
    }

    public Message(String text) {
        setText(text);
        setDate(new Date());
    }
    public Message() {
        setText("");
        setDate(new Date());
    }

    abstract public String toString();
}
