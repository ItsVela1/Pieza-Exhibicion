package icesi.PacMan.model;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    private List<Cell> nodes;
    private int width;
    private int height;

    public GridGraph() {
        this.nodes = new ArrayList<>();
        this.width = 28; // Típico ancho de Pac-Man
        this.height = 31; // Típico alto de Pac-Man
        initializeGrid();
    }

    private void initializeGrid() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CellType type = (x == 0 || x == width - 1 || y == 0 || y == height - 1)
                        ? CellType.WALL : CellType.BLANK;
                nodes.add(new Cell(x, y, type));
            }
        }
    }

    public Cell getCell(int x, int y) {
        for (Cell cell : nodes) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        addIfValid(neighbours, x, y - 1); // Arriba
        addIfValid(neighbours, x, y + 1); // Abajo
        addIfValid(neighbours, x - 1, y); // Izquierda
        addIfValid(neighbours, x + 1, y); // Derecha

        return neighbours;
    }

    private void addIfValid(List<Cell> neighbours, int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            Cell cell = getCell(x, y);
            if (cell != null && cell.getType() != CellType.WALL) {
                neighbours.add(cell);
            }
        }
    }

    public void addCell(Cell cell) {
        nodes.add(cell);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
