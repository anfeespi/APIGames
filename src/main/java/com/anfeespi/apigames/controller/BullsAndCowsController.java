package com.anfeespi.apigames.controller;

import com.anfeespi.apigames.dto.BullsAndCowsMove;
import com.anfeespi.apigames.dto.Response;
import com.anfeespi.apigames.service.BullsAndCowsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bnc")
@SecurityRequirement(name = "bearer-key")
/**
 * TODO:
 * - Documentation
 * - Login
 * - Persistence
 * - Continue Game
 * - Spring Security
 * - Languages
 */
public class BullsAndCowsController {
    @Autowired
    private BullsAndCowsService bullsAndCowsService;

    @PostMapping("/create")
    public ResponseEntity<Response> beginGame(@RequestBody String player) {
        boolean status = bullsAndCowsService.create(player);
        return ResponseEntity.
                status(status ? HttpStatus.ACCEPTED : HttpStatus.INTERNAL_SERVER_ERROR).
                body(new Response(status ? "Game initialized successful" : "There's an error"));
    }

    @PostMapping("/play")
    public ResponseEntity<Response> play(@RequestBody BullsAndCowsMove move) {
        int[] response = bullsAndCowsService.play(move.playerTry());

        return ResponseEntity.status(HttpStatus.OK).
                body(new Response(response[0] == 4 ? "You won!" : "There are "+response[0]+" bulls and "+response[1]+" cows."));
    }

}
