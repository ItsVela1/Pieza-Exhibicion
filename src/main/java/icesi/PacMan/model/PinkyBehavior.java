package icesi.PacMan.model;

import java.util.List;

public class PinkyBehavior implements GhostBehavior {

    @Override
    public void move(Ghost ghost, PacMan pacman, GridGraph grid) {
        int [] target = getTarget(ghost, pacman, grid);
        moveTowardsTarget(ghost, target, grid);
    }

    @Override
    public int[] getTarget(Ghost ghost, PacMan pacman, GridGraph grid) {
        // Pinky apunta 4 casillas adelante de Pac-Man
        int targetX = pacman.getX();  // Cambiado de pacMan a pacman
        int targetY = pacman.getY();  // Cambiado de pacMan a pacman

        switch (pacman.getDirection()) {
            case UP: targetY -= 4; break;
            case DOWN: targetY += 4; break;
            case LEFT: targetX -= 4; break;
            case RIGHT: targetX += 4; break;
        }

        return new int[]{targetX, targetY};
    }

    private void moveTowardsTarget(Ghost ghost, int[] target, GridGraph grid) {
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

    private boolean canMove(int x, int y, GridGraph grid) {
        Cell cell = grid.getCell(x, y);
        return cell != null && cell.getType() != CellType.WALL;
    }

}