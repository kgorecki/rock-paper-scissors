package com.bintohimo.rockpaperscissorslizardspock.controllers;

import com.bintohimo.rockpaperscissorslizardspock.Game;
import com.bintohimo.rockpaperscissorslizardspock.GameResult;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${url.path}")
public class GameController {

    @RequestMapping(value = "${url.path.rockPaperScissors}", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public @ResponseBody
    ResponseEntity RockPaperScissors(@RequestParam(value="choice") String choice) {
        choice = StringUtils.capitalize(choice.toLowerCase());
        Game game = new Game(choice, Game.GameType.RockPaperScissors);
        return generateResult(game, choice);
    }

    @RequestMapping(value = "${url.path.rockPaperScissorsLizardSpock}", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public @ResponseBody
    ResponseEntity RockPaperScissorsLizardSpock(@RequestParam(value="choice") String choice) {
        choice = StringUtils.capitalize(choice.toLowerCase());
        Game game = new Game(choice, Game.GameType.RockPaperScissorsLizardSpock);
        return generateResult(game, choice);
    }

    private ResponseEntity generateResult(Game game, String choice) {
        GameResult gameResult;
        try {
            gameResult = game.getResult();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        String message = "";
        switch (gameResult.gameResultType) {
            case Win: message = "WON!"; break;
            case Lose: message = "LOSE!"; break;
            case Draw: message = "DREW!"; break;
        }

        JSONObject jsonReply = new JSONObject();
        jsonReply.put("result", "You " + message);
        jsonReply.put("your-choice", choice);
        jsonReply.put("opponents-choice", gameResult.value);
        jsonReply.put("human-readable", "You " + message + " You chosen: " + choice + " Opponent chosen: " + gameResult.value);

        return ResponseEntity.ok(jsonReply.toString());
    }
}
