package icesi.PacMan.model;

public class Blinky extends Ghost{

private  int agression;

    public Blinky(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph, int agression) {
        super(name, color, scatteraTargetX, scatteraTargetY, behavior, state, graph);
        this.agression = agression;
    }
}
