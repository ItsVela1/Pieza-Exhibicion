module icesi.PacMan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens icesi.PacMan to javafx.fxml;
    exports icesi.PacMan;
}