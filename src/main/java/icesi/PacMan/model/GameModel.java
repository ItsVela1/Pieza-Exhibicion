package icesi.PacMan.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private GridGraph grid;
    private PacMan pacman;
    private List<Ghost> ghosts;
    private int score;
    private boolean gameOver;

    public GameModel() {
        this.grid = new GridGraph();
        this.pacman = new PacMan(3);
        this.ghosts = new ArrayList<>();
        this.score = 0;
        this.gameOver = false;
        initializeGhosts();
        initializeGrid();
    }

    private void initializeGrid() {}

    private void initializeGhosts() {
        // Inicializar los fantasmas aquí
        ghosts.add(new Blinky("Blinky", "Red", 25, 0, null, GhostState.CHASE, grid, 5));
        ghosts.add(new Pinky("Pinky", "Pink", 2, 0, null, GhostState.CHASE, grid, 4));
        ghosts.add(new Inky("Inky", "Cyan", 27, 35, null, GhostState.CHASE, grid, 0.5));
        ghosts.add(new Clyde("Clyde", "Orange", 0, 35, null, GhostState.CHASE, grid, 8));
    }


    public void update() {

        if (gameOver) return;

        //Movimiento PacMan
        pacman.move;

        //Movimiento Fantasmas
        for (Ghost ghost : ghosts) {
            ghost.
        }

        //Colisiones
        checkCollisions();
    }

    private void checkCollisions() {
        // Verificar si PacMan como pellets

        Cell currentCell = grid.getCell(pacman.getX(), pacman.getY());
        if (currentCell != null && currentCell.getFood() != null) {
            if (currentCell.getFood() == Food.PELLET) {
                pacman.eatPellet();
                score += 10;
                currentCell.setFood(null);
            } else if (currentCell.getFood() == Food.POWER_PELLET) {
                pacman.eatPowerPellet();
                score += 50;
                currentCell.setFood(null);

                for (Ghost ghost : ghosts) {
                    ghost.setState(GhostState.FRIGHTENED);
                }
            }
        }

        // Verificar colisiones con fantasmas

        for (Ghost ghost : ghosts) {
            if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
                if (ghost.getState() == GhostState.FRIGHTENED) {
                    // PacMan come el fantasma
                    ghost.setState(GhostState.CHASE); // Volver a estado normal después de un tiempo?
                    score += 200;
                } else {
                    // PacMan pierde una vida
                    pacman.setLives(pacman.getLives() - 1);
                    if (pacman.getLives() <= 0) {
                        gameOver = true;
                    } else {
                        // Reiniciar posiciones
                        resetPositions();
                    }
                }
            }
        }
    }

    private void resetPositions() {
        pacman.setX(14);
        pacman.setY(23);
    }

    public GridGraph getGrid() { return grid; }
    public PacMan getPacMan() { return pacman; }
    public List<Ghost> getGhosts() { return ghosts; }
    public int getScore() { return score; }
    public boolean isGameOver() { return gameOver; }

}