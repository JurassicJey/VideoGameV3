package com.example.videogamev3.GameManagement.DataAccess;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private GameId gameId;
    private String title;
    private double price;
    private LocalDateTime releaseDate;
    private String description;
    private String publisher;
    private String developer;
    private Genre genre;
    @OneToMany(mappedBy="game")
    private List<Review> reviews;
}
