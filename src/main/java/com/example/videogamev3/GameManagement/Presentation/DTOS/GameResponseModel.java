package com.example.videogamev3.GameManagement.Presentation.DTOS;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameId;
import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.DataAccess.Review;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseModel {
    private String id;
    private String title;
    private double price;
    private String releaseDate;
    private String description;
    private String publisher;
    private String developer;
    private String genre;
    private List<Review> reviews;
    private List<Game> userGames;
}
