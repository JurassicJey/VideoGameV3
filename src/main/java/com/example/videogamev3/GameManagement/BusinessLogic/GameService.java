package com.example.videogamev3.GameManagement.BusinessLogic;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameRepository;
import com.example.videogamev3.GameManagement.DataMapper.GameRequestMapper;
import com.example.videogamev3.GameManagement.DataMapper.GameResponseMapper;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameResponseModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {
    private GameResponseMapper gameResponseMapper;
    private GameRepository gameRepository;
    private GameRequestMapper gameRequestMapper;

    public GameService(GameResponseMapper gameResponseMapper) {
        this.gameRepository =  gameRepository;
        this.gameRequestMapper = gameRequestMapper;
        this.gameResponseMapper = gameResponseMapper;
    }


    public GameResponseModel getGameById(String uuid){
        Game game = gameRepository.findGameByGameId_uuid(uuid);
        GameResponseModel responseModel = gameResponseMapper.gameToGameResponseModel(game);
        return responseModel;
    }

    public List<GameResponseModel> getAllGames(){
        List<Game> games = gameRepository.findAll();
        return gameResponseMapper.gameToGameResponseModel(games);
    }

    public GameResponseModel createGame(GameRequestModel gameRequestModel){
        return gameResponseMapper.gameToGameResponseModel(gameRepository.save(gameRequestMapper.gameRequestModelToGame(gameRequestModel)));
    }

    public GameResponseModel updateGame(GameRequestModel gameRequestModel){
        return gameResponseMapper.gameToGameResponseModel(gameRepository.save(gameRequestMapper.gameRequestModelToGame(gameRequestModel)));
    }

    public GameResponseModel deleteGame(String uuid){
        Game game = gameRepository.findGameByGameId_uuid(uuid);
        return gameResponseMapper.gameToGameResponseModel(game);
    }


}
