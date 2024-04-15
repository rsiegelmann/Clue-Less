package com.clueless.ClueLess;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClueLess {

    List<Message> messages = new ArrayList<Message>();

    Message m1 = new Message(1, "Player 1 has moved into a new room.");
    Message m2 = new Message(1, "Player 2 has made an accusation.");
    Message m3 = new Message(1, "Player 3 was right and won the game!");

    Room r0 = new Room(3, 0);
    Room r1 = new Room(0, 3);
    Room r2 = new Room(1, 4);
    Room r3 = new Room(4, 1);
    Room r4 = new Room(3, 4);
    Room r5 = new Room(4, 4);

    int playerTurn = 0;

    List <Room> board = Arrays.asList(r0, r1, r2, r3, r4, r5);

    @GetMapping(path = "/message/{id}")
    @ResponseBody
    public ResponseEntity getMessages (@PathVariable("id") Long id) {
        System.out.println("Player " + id + " has requested the current game state.");
        return new ResponseEntity<>(List.of(m1, m2, m3), HttpStatus.OK);
    }

    @PostMapping(path = "/message",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postMessage (@RequestBody  Message m) {
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping(path = "/board")
    @ResponseBody
    public ResponseEntity getBoard () {
        System.out.println ("Returning board.");
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping(path = "/board/{id}/{x}/{y}")
    @ResponseBody
    public ResponseEntity updateBoard (@PathVariable("id") int id, @PathVariable("x") int x, @PathVariable("y") int y) {
        board.set(id, new Room(x, y));

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/player")
    @ResponseBody
    public ResponseEntity updateBoard () {
        return new ResponseEntity(playerTurn, HttpStatus.OK);
    }

    @GetMapping(path = "/player/{player}")
    @ResponseBody
    public ResponseEntity updateBoard (@PathVariable("player") int player) {
        this.playerTurn = player;

        return new ResponseEntity(HttpStatus.OK);
    }
}
