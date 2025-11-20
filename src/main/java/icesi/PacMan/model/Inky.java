package icesi.PacMan.model;

public class Inky extends Ghost {
    private double dualInfluence;

    public Inky(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph, double dualInfluence) {
        super(name, color, scatteraTargetX, scatteraTargetY, behavior, state, graph);
        this.dualInfluence = dualInfluence;
    }
}
