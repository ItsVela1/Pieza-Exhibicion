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
        drawGrid();

        pacmanView = new ImageView(
                new Image(getClass().getResource("/images/right.gif").toString())
        );

        pacmanView.setFitWidth(30);
        pacmanView.setFitHeight(30);

        pacmanView.setLayoutX(100);
        pacmanView.setLayoutY(100);

        gamePane.getChildren().add(pacmanView);

        System.out.println("Pac-Man loaded!");


        gamePane.setOnKeyPressed(this::onKeyPressed);
        gamePane.setOnMouseClicked(e -> gamePane.requestFocus());

        gamePane.requestFocus();

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
            case W -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/up.gif").toString()));
                gameController.setPacManDirection(Direction.W);
            }
            case S -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/down.gif").toString()));
                gameController.setPacManDirection(Direction.S);
            }
            case A -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/left.gif").toString()));
                gameController.setPacManDirection(Direction.A);
            }
            case D -> {
                pacmanView.setImage(new Image(getClass().getResource("/images/right.gif").toString()));
                gameController.setPacManDirection(Direction.D);
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

    private void drawGrid() {
        int cellSize = 40; // Tamaño visual de cada celda

        var grid = gameController.getGameModel().getGrid();

        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {

                var cell = grid.getCell(x, y);

                javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle(cellSize, cellSize);

                rect.setLayoutX(x * cellSize);
                rect.setLayoutY(y * cellSize);

                // Colores según tipo de celda
                switch (cell.getType()) {
                    case WALL -> rect.setFill(javafx.scene.paint.Color.DARKBLUE);
                    case BLANK -> rect.setFill(javafx.scene.paint.Color.BLACK);
                }

                // Borde opcional
                rect.setStroke(javafx.scene.paint.Color.BLACK);
                rect.setStrokeWidth(0.5);

                gamePane.getChildren().add(rect);
            }
        }
    }



}
