package com.santiago.chat.chat;

import java.awt.*;

public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    public ChatMessage() {
    }

    public ChatMessage(String content, String sender, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
    public static class Builder {
        private MessageType type;
        private String sender;
        private String content;

        public Builder type(MessageType type) {
            this.type = type;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(this);
        }
    }
}
