package com.clueless.ClueLess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    public Message (int id, String message) {
        this.id = id;
        this.message = message;
    }

    @JsonProperty("id")
    private int id;

    @JsonProperty("message")
    private String message;
}