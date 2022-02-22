package com.tus.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tus.game.dao.GamesRepository;
import com.tus.game.entity.Games;
import com.tus.game.exceptions.ResourceNotFoundException;

@RestController
public class JpaGameController
{
    @Autowired
    private GamesRepository gameRepository;

    @GetMapping("/games")
    public List<Games> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/games/{id}")
    public ResponseEntity< Games > getGameById(@PathVariable(value = "id") Long gameId) throws ResourceNotFoundException {
        Optional<Games> game = gameRepository.findById(gameId);
        if(game.isPresent())
            return ResponseEntity.ok().body(game.get());
        else
            throw new ResourceNotFoundException("Game not found :: " + gameId);
    }

    @PostMapping("/games")
    public Games createGame(@RequestBody Games game) {
        return gameRepository.save(game);
    }

    @DeleteMapping("/games/{id}")
    public void deleteGame(@PathVariable(value = "id") Long gameId){
    	gameRepository.deleteById(gameId);
    }
}
