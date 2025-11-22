package icesi.PacMan.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MainMenu {

    @FXML
    private Button startButton;

    @FXML
    private Button pauseGameButton;

    @FXML
    private Button resumeGameButton;

    @FXML
    private Button exitGameButton;

    @FXML
    private void handleStartGameButtonAction() {
        System.out.println("El juego esta iniciando....");
    }
}

