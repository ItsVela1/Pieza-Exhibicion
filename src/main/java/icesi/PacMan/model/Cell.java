package icesi.PacMan.model;

public class Cell {

    private int x;
    private int y;
    private CellType type;

    public Cell(int x, int y, CellType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
