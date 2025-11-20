package icesi.PacMan.model;

public class Clyde  extends Ghost {
    private int fearDistance;

    public Clyde(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph, int fearDistance) {
        super(name, color, scatteraTargetX, scatteraTargetY, behavior, state, graph);
        this.fearDistance = fearDistance;
    }
}
