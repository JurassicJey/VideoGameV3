package com.example.videogamev3.GameManagement.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;

public interface GameRepository extends JpaRepository<Game, String> {
    ScopedValue<Object> findGameByGameId_Uuid(String gameIdUuid);

    Game findGameByGameId_uuid(String gameIdUuid);
}
