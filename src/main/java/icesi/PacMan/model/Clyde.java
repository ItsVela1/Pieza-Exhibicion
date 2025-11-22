package icesi.PacMan.model;

public class Clyde extends Ghost {
    private int fearDistance;

    public Clyde(String name, String color, int scatterTargetX, int scatterTargetY,
                 GhostBehavior behavior, GhostState state, GridGraph graph, int fearDistance) {
        super(name, color, scatterTargetX, scatterTargetY, behavior, state, graph);
        this.fearDistance = fearDistance;
    }

    public int getFearDistance() { return fearDistance; }
}