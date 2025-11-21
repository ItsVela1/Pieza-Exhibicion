package icesi.PacMan.model;

public class Cell {

    private int x;
    private int y;
    private CellType type;
    private Food food;

    public Cell(int x, int y, CellType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public CellType getType() { return type; }
    public Food getFood() { return food; }
    public void setFood(Food food) { this.food = food; }

}
