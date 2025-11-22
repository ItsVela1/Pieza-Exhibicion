package icesi.PacMan.model;

public class BlinkyBehavior implements GhostBehavior{

    @Override
    public void move(Ghost ghost, PacMan pacman, GridGraph grid) {
        int[] target = getTarget(ghost, pacman, grid);
        moveTowardsTarget(ghost, target, grid);
    }

    @Override
    public int[] getTarget(Ghost ghost, PacMan pacman, GridGraph grid) {
        // Blinky persigue directamente a Pac-Man
        return new int[]{pacman.getX(), pacman.getY()};
    }

    private void moveTowardsTarget(Ghost ghost, int[] target, GridGraph grid) {
        int ghostX = ghost.getX();
        int ghostY = ghost.getY();
        int targetX = target[0];
        int targetY = target[1];

        // Determinar la mejor dirección
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
