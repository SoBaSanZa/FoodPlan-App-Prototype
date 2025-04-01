package com.example.foodplan;
public class Message {
    public static final String SENT_BY_ME = "sent_by_me";
    public static final String SENT_BY_BOT = "sent_by_bot";

    private String message;
    private String sentBy;

    public Message(String message, String sentBy) {
        this.message = message;
        this.sentBy = sentBy;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }
}
