package icesi.PacMan.controller;

import icesi.PacMan.model.Direction;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;


public class GameViewController {

    private GameController gameController; // Controlador lógico
    private ImageView pacmanView;

    @FXML
    private Pane gamePane; // Panel donde vamos a dibujar el juego

    public GameViewController() {
        this.gameController = new GameController();
    }

    @FXML
    public void initialize() {
        pacmanView = new ImageView(
                new Image(getClass().getResource("/images/right.gif").toString())
        );

        pacmanView.setFitWidth(30);
        pacmanView.setFitHeight(30);

        pacmanView.setLayoutX(100);
        pacmanView.setLayoutY(100);

        gamePane.getChildren().add(pacmanView);

        System.out.println("Pac-Man loaded!");

        gamePane.setFocusTraversable(true);
        gamePane.requestFocus();
        gamePane.setOnKeyPressed(this::onKeyPressed);

        new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                gameController.updateGame();
                updateView();
            }
        }.start();
    }

    @FXML
    public void onKeyPressed(javafx.scene.input.KeyEvent event) {

        switch (event.getCode()) {
            case UP -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/up.gif").toString()));
                gameController.setPacManDirection(Direction.UP);
            }
            case DOWN -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/down.gif").toString()));
                gameController.setPacManDirection(Direction.DOWN);
            }
            case LEFT -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/left.gif").toString()));
                gameController.setPacManDirection(Direction.LEFT);
            }
            case RIGHT -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/right.gif").toString()));
                gameController.setPacManDirection(Direction.RIGHT);
            }
        }
    }


    // Movimiento con teclas (lo conectaremos más adelante)
    public void movePacman(Direction direction) {
        gameController.setPacManDirection(direction);
    }


    public void update() {
        gameController.updateGame();
        // Luego: repintar el mapa aquí
    }

    public void updateView() {
        var pac = gameController.getGameModel().getPacMan();
        pacmanView.setLayoutX(pac.getX());
        pacmanView.setLayoutY(pac.getY());
    }

    public GameController getGameController() {
        return gameController;
    }


}
