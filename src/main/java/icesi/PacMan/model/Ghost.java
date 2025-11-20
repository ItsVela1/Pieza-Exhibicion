package icesi.PacMan.model;

public class Ghost {

    protected String Name;
    protected String Color;
    protected int scatteraTargetX;
    protected int scatteraTargetY;
    protected GhostBehavior behavior;
    protected GhostState State;
    protected GridGraph graph;

    public Ghost(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph) {
        Name = name;
        Color = color;
        this.scatteraTargetX = scatteraTargetX;
        this.scatteraTargetY = scatteraTargetY;
        this.behavior = behavior;
        State = state;
        this.graph = graph;
    }

    public void setBehavior(GhostBehavior behavior) {
        this.behavior = behavior;
    }
}
