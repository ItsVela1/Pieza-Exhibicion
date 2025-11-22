package icesi.PacMan.controller;

import icesi.PacMan.model.GameModel;
import icesi.PacMan.model.Direction;


public class GameController {
    private GameModel gameModel;

    public GameController() {
        this.gameModel = new GameModel();
    }

    public void updateGame(){
        gameModel.update();
    }

    public void setPacManDirection(Direction direction){
        gameModel.getPacMan().setDirection(direction);
    }

    public void restartGame(){
        gameModel.reset();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}

