package icesi.PacMan.model;

import java.util.List;

public class Inky extends Ghost {
    private double dualInfluence;
    private List<Ghost> otherGhosts;

    public Inky(String name, String color, int scatterTargetX, int scatterTargetY,
                GhostBehavior behavior, GhostState state, GridGraph graph, double dualInfluence) {
        super(name, color, scatterTargetX, scatterTargetY, behavior, state, graph);
        this.dualInfluence = dualInfluence;
    }

    public void setOtherGhosts(List<Ghost> otherGhosts) {
        this.otherGhosts = otherGhosts;
    }

    public List<Ghost> getOtherGhosts() {
        return otherGhosts;
    }

    public double getDualInfluence() { return dualInfluence; }
}