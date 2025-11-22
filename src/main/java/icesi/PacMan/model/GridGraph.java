package icesi.PacMan.model;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {
    private List<Cell> nodes;
    private int width;
    private int height;

    public GridGraph() {
        this.nodes = new ArrayList<>();
        this.width = 15;
        this.height = 15;
    }

    public void initializeSimpleGrid() {
        nodes.clear();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CellType type = CellType.BLANK;

                // Bordes con pared
                if (x == 0 || x == width - 1 || y == 0 || y == height - 1) {
                    type = CellType.WALL;
                }

                // Paredes internas
                else if ((x == 7 && y > 2 && y < 12) || (y == 7 && x > 2 && x < 12)) {
                    type = CellType.WALL;
                }

                Cell cell = new Cell(x, y, type);
                nodes.add(cell);
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

        // Solo movimientos horizontales y verticales
        checkAndAddNeighbour(neighbours, x, y - 1); // Arriba
        checkAndAddNeighbour(neighbours, x, y + 1); // Abajo
        checkAndAddNeighbour(neighbours, x - 1, y); // Izquierda
        checkAndAddNeighbour(neighbours, x + 1, y); // Derecha

        return neighbours;
    }

    private void checkAndAddNeighbour(List<Cell> neighbours, int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            Cell cell = getCell(x, y);
            if (cell != null && cell.getType() != CellType.WALL) {
                neighbours.add(cell);
            }
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}