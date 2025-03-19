package com.example.videogamev3.GameManagement.DataAccess;


import com.example.videogamev3.UserManagement.DataAccess.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @EmbeddedId
    private GameId gameId;
    private String title;
    private double price;
    private LocalDateTime releaseDate;
    private String description;
    private String publisher;
    private String developer;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @JsonManagedReference
    @OneToMany(mappedBy="game", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_game_id", nullable = true)
    private User gameOwner;
}
