package com.clueless.ClueLess;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClueLess {

    List<Message> messages = new ArrayList<Message>();

    Message m1 = new Message(1, "Player 1 has moved into a new room.");
    Message m2 = new Message(1, "Player 1 has made an accusation.");
    Message m3 = new Message(1, "Player 1 was right.");

    @GetMapping("/message/{id}")
    public ResponseEntity getMessages (@PathVariable("id") Long id) {
        return new ResponseEntity<>(List.of(m1, m2, m3), HttpStatus.OK);
    }

    @PostMapping(path = "/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postMessage (@RequestBody  Message m) {
        return new ResponseEntity<>(m, HttpStatus.OK);
    }
}
