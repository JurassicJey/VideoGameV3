package com.example.videogamev3.GameManagement.DataAccess;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameId {
    private String uuid;
}
