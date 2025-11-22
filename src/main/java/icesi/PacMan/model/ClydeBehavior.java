package icesi.PacMan.model;

public class ClydeBehavior implements GhostBehavior {
    private static final int FEAR_DISTANCE = 8;

    @Override
    public void move(Ghost ghost, PacMan pacman, GridGraph grid) {
        int[] target = getTarget(ghost, pacman, grid);
        moveTowardsTarget(ghost, target, grid);
    }

    @Override
    public int[] getTarget(Ghost ghost, PacMan pacman, GridGraph grid) {
        int ghostX = ghost.getX();
        int ghostY = ghost.getY();
        int pacX = pacman.getX();
        int pacY = pacman.getY();

        // Calcular distancia a Pac-Man
        double distance = Math.sqrt(Math.pow(ghostX - pacX, 2) + Math.pow(ghostY - pacY, 2));

        if (distance < FEAR_DISTANCE) {
            // Si está cerca, huir a su esquina
            return new int[]{ghost.getScatterTargetX(), ghost.getScatterTargetY()};
        } else {
            // Si está lejos, perseguir a Pac-Man
            return new int[]{pacX, pacY};
        }
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