package edu.eci.cvds.backingbean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameConfiguration addProperty(GameConfiguration gameConfiguration) {
        return gameRepository.save(gameConfiguration);
    }
    
    public GameConfiguration getGameConfiguration(String property) {
        return gameRepository.findById(property).get();
    }
    
    public List<GameConfiguration> getAllProperties() {
        return gameRepository.findAll();
    }
    
    public GameConfiguration updateProperty(GameConfiguration gameConfiguration) {
        if(gameRepository.existsById(gameConfiguration.getProperty())) {
            return gameRepository.save(gameConfiguration);
        }
        return null;
    }
    
    public void deleteProperty(String property) {
        gameRepository.deleteById(property);
    }

}
