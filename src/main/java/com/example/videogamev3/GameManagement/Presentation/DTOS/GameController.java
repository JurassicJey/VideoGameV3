package com.example.videogamev3.GameManagement.Presentation.DTOS;

import com.example.videogamev3.GameManagement.BusinessLogic.GameService;
import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/game")
public class GameController {
    private GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{uuid}")
    public GameResponseModel getGameByGameId_uuid(@PathVariable String uuid) {
        GameResponseModel game = gameService.getGameById(uuid);
        return game;
    }

    @GetMapping()
    public List<GameResponseModel> getAllGames() {
        List<GameResponseModel> game = gameService.getAllGames();
        return game;
    }

    @PostMapping
    public GameResponseModel addGame(@RequestBody GameRequestModel gameRequestModel) {
        return gameService.createGame(gameRequestModel);
    }
    @PutMapping
    public GameResponseModel updateGame(@RequestBody GameRequestModel gameRequestModel) {
        return gameService.updateGame(gameRequestModel);
    }
    @DeleteMapping("{uuid}")
    public GameResponseModel deleteGame(@PathVariable String uuid) {
        return gameService.deleteGame(uuid);
    }
    @PostMapping("review/{uuid}")
    public GameResponseModel reviewGame(@PathVariable String uuid, @RequestBody ReviewRequestModel reviewRequestModel) {
        return gameService.addReview(reviewRequestModel, uuid);
    }
}
