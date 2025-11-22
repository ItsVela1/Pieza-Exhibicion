package icesi.PacMan.model;

public interface GhostBehavior {
    void move(Ghost ghost, PacMan pacMan, GridGraph grid);
    int[] getTarget(Ghost ghost, PacMan pacMan, GridGraph grid);
}