package com.tus.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tus.game.dao.GamesRepository;
import com.tus.game.entity.Games;
import com.tus.game.exceptions.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Games", description = "Video Gaming Endpoints")
public class JpaGameController
{
    @Autowired
    private GamesRepository gameRepository;

    @GetMapping("/game")
    @Operation(
            summary = "Finds all games",
            description = "Finds all games"            
            )
    //@Tag(name = "GET", description = "Returns a Game and its information")
    public List<Games> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/game/{id}")
    @Operation(
            summary = "Finds a game by their ID",
            description = "Finds a game by their Id."            
            )
    
    public ResponseEntity< Games > getGameById(@PathVariable(value = "id") Long gameId) throws ResourceNotFoundException {
        Optional<Games> game = gameRepository.findById(gameId);
        if(game.isPresent())
            return ResponseEntity.ok().body(game.get());
        else
            throw new ResourceNotFoundException("Game not found :: " + gameId);
    }

    @PostMapping("/games")
    @Operation(
            summary = "Creates a Game and its information",
            description = "Creates a Game and its information."            
            )
    //@Tag(name = "POST", description = "Creates a Game and its information")
    public Games createGame(@RequestBody Games game) {
        return gameRepository.save(game);
    }

    @DeleteMapping("/games/{id}")
    @Operation(
            summary = "Deletes a Game and its information",
            description = "Deletes a Game and its information"            
            )
    //@Tag(name = "DELETE", description = "Deletes a Game and its information")
    public void deleteGame(@PathVariable(value = "id") Long gameId){
    	gameRepository.deleteById(gameId);
    }
    
    @PutMapping("/games/{id}")
    @Operation(
            summary = "Updates a Game and its information",
            description = "Updates a Game and its information"            
            )
    //@Tag(name = "PUT", description = "Updates a Game and its information")
    public void updateGame(@PathVariable(value = "id") Long gameId){
    	gameRepository.existsById(gameId);
    }
}
