package com.clueless.ClueLess;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public Room (Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @JsonProperty("x")
    int x;

    @JsonProperty("y")
    int y;
}
