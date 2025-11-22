package icesi.PacMan.model;

import java.util.List;

public class InkyBehavior implements GhostBehavior {

    @Override
    public void move(Ghost ghost, PacMan pacman, GridGraph grid) {
        int[] target = getTarget(ghost, pacman, grid);
        moveTowardsTarget(ghost, target, grid);
    }

    @Override
    public int[] getTarget(Ghost ghost, PacMan pacman, GridGraph grid) {
        // Inky usa una posición intermedia entre Pac-Man y Blinky
        int pacX = pacman.getX();
        int pacY = pacman.getY();

        // Calcular posición 2 casillas adelante de Pac-Man
        int aheadX = pacX;
        int aheadY = pacY;

        switch (pacman.getDirection()) {
            case W: aheadY -= 2; break;
            case S: aheadY += 2; break;
            case A: aheadX -= 2; break;
            case D: aheadX += 2; break;
        }

        // Encontrar a Blinky (asumiendo que está en la lista de fantasmas)
        Ghost blinky = null;
        if (ghost instanceof Inky) {
            List<Ghost> otherGhosts = ((Inky)ghost).getOtherGhosts();
            for (Ghost g : otherGhosts) {
                if (g instanceof Blinky) {
                    blinky = g;
                    break;
                }
            }
        }

        if (blinky != null) {
            // Calcular vector desde Blinky hasta el punto adelante de Pac-Man
            int vectorX = aheadX - blinky.getX();
            int vectorY = aheadY - blinky.getY();

            // El objetivo es el doble de ese vector
            return new int[]{blinky.getX() + 2 * vectorX, blinky.getY() + 2 * vectorY};
        }

        return new int[]{aheadX, aheadY};
    }

    private void moveTowardsTarget(Ghost ghost, int[] target, GridGraph grid) {
        // Movimiento ocasionalmente aleatorio
        if (Math.random() < 0.2) { // 20% de probabilidad de movimiento aleatorio
            moveRandomly(ghost, grid);
        } else {
            // Movimiento hacia el objetivo
            int ghostX = ghost.getX();
            int ghostY = ghost.getY();
            int targetX = target[0];
            int targetY = target[1];

            if (Math.abs(targetX - ghostX) > Math.abs(targetY - ghostY)) {
                if (targetX > ghostX && canMove(ghostX + 1, ghostY, grid)) {
                    ghost.setX(ghostX + 1);
                } else if (targetX < ghostX && canMove(ghostX - 1, ghostY, grid)) {
                    ghost.setX(ghostX - 1);
                } else if (targetY > ghostY && canMove(ghostX, ghostY + 1, grid)) {
                    ghost.setY(ghostY + 1);
                } else if (targetY < ghostY && canMove(ghostX, ghostY - 1, grid)) {
                    ghost.setY(ghostY - 1);
                }
            } else {
                if (targetY > ghostY && canMove(ghostX, ghostY + 1, grid)) {
                    ghost.setY(ghostY + 1);
                } else if (targetY < ghostY && canMove(ghostX, ghostY - 1, grid)) {
                    ghost.setY(ghostY - 1);
                } else if (targetX > ghostX && canMove(ghostX + 1, ghostY, grid)) {
                    ghost.setX(ghostX + 1);
                } else if (targetX < ghostX && canMove(ghostX - 1, ghostY, grid)) {
                    ghost.setX(ghostX - 1);
                }
            }
        }
    }

    private void moveRandomly(Ghost ghost, GridGraph grid) {
        // Movimiento aleatorio simple
        int ghostX = ghost.getX();
        int ghostY = ghost.getY();

        // Movimientos aleatorios
        int direction = (int)(Math.random() * 4);
        for (int i = 0; i < 4; i++) {
            int testDirection = (direction + i) % 4;
            int newX = ghostX;
            int newY = ghostY;

            switch (testDirection) {
                case 0: newY--; break; // Arriba
                case 1: newX++; break; // Derecha
                case 2: newY++; break; // Abajo
                case 3: newX--; break; // Izquierda
            }

            if (canMove(newX, newY, grid)) {
                ghost.setX(newX);
                ghost.setY(newY);
                break;
            }
        }
    }

    private boolean canMove(int x, int y, GridGraph grid) {
        Cell cell = grid.getCell(x, y);
        return cell != null && cell.getType() != CellType.WALL;
    }
}