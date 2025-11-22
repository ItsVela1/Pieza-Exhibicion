package icesi.PacMan.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class YouLose {
    @FXML
    private Text scoreText;

    @FXML
    private Button restartButton;

    @FXML
    private void handleRestart() {
        System.out.println("Reiniciando...");
    }
}