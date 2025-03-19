package com.example.videogamev3.GameManagement.DataAccess;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ReviewId reviewId;
    private String comment;
    private String rating;
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name="game_id", nullable = true)
    private Game game;
}
