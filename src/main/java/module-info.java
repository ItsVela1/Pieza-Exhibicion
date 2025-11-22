module icesi.PacMan {
    requires javafx.controls;
    requires javafx.fxml;

    opens icesi.PacMan.controller to javafx.fxml;
    exports icesi.PacMan.controller;
    exports icesi.PacMan;
    requires javafx.graphics;
}
