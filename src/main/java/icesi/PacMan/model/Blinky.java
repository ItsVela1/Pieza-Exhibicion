package icesi.PacMan.model;

public class Blinky extends Ghost {
    private int aggression;

    public Blinky(String name, String color, int scatterTargetX, int scatterTargetY,
                  GhostBehavior behavior, GhostState state, GridGraph graph, int aggression) {
        super(name, color, scatterTargetX, scatterTargetY, behavior, state, graph);
        this.aggression = aggression;
    }

    public int getAggression() { return aggression; }
}