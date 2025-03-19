package com.example.videogamev3.GameManagement.BusinessLogic;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameRepository;
import com.example.videogamev3.GameManagement.DataAccess.Review;
import com.example.videogamev3.GameManagement.DataAccess.ReviewRepository;
import com.example.videogamev3.GameManagement.DataMapper.GameRequestMapper;
import com.example.videogamev3.GameManagement.DataMapper.GameResponseMapper;
import com.example.videogamev3.GameManagement.DataMapper.ReviewMapper;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameResponseModel;
import com.example.videogamev3.GameManagement.Presentation.DTOS.ReviewRequestModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private GameResponseMapper gameResponseMapper;
    private GameRepository gameRepository;
    private GameRequestMapper gameRequestMapper;
    private ReviewMapper reviewMapper;

    public GameService(GameResponseMapper gameResponseMapper, GameRepository gameRepository, GameRequestMapper gameRequestMapper, ReviewMapper reviewMapper) {
        this.gameRepository =  gameRepository;
        this.gameRequestMapper = gameRequestMapper;
        this.gameResponseMapper = gameResponseMapper;
        this.reviewMapper = reviewMapper;
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
        gameRepository.delete(game);
        return gameResponseMapper.gameToGameResponseModel(game);
    }

    public GameResponseModel addReview(ReviewRequestModel reviewRequestModel, String gameId){
        Game game = gameRepository.findGameByGameId_uuid(gameId);
        Review review = reviewMapper.reviewRequestModelToReview(reviewRequestModel);

        List<Review> reviews = game.getReviews();
        if (reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);

        game.setReviews(reviews);

        gameRepository.save(game);
        return gameResponseMapper.gameToGameResponseModel(game);
    }


}
