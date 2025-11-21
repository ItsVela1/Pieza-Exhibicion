package icesi.PacMan.model;

import java.util.ArrayList;
import java.util.List;

public class GridGraph {

    private int width;
    private int height;
    private Cell[][] grid;

    public GridGraph(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new Cell(x, y, CellType.BlANK);
            }
        }
    }
    public Cell getCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return null;

        return grid[y][x];
    }


    public void setCell(int x, int y, CellType type) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return;
        grid[y][x].setType(type);
    }


    public List<Cell> neighbors(int x, int y) {

        List<Cell> list = new ArrayList<>();
        if (y > 0)
            list.add(grid[y - 1][x]);


        if (y < height - 1)
            list.add(grid[y + 1][x]);


        if (x > 0)
            list.add(grid[y][x - 1]);

        if (x < width - 1)
            list.add(grid[y][x + 1]);

        return list;
    }

    public List<Cell> neighbors(Cell c) {
        return neighbors(c.getX(), c.getY());
    }


    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public Cell[][] getGrid() { return grid; }
}
