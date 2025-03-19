package com.example.videogamev3.GameManagement.Presentation.DTOS;

import com.example.videogamev3.GameManagement.DataAccess.GameId;
import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.DataAccess.Review;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameRequestModel {
    private String uuid;
    private String title;
    private double price;
    private String description;
    private String publisher;
    private String developer;
    private String genre;
}
