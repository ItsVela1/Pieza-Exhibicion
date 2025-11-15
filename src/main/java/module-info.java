module icesi.PacMan {
    requires javafx.controls;
    requires javafx.fxml;


    opens icesi.PacMan to javafx.fxml;
    exports icesi.PacMan;
}