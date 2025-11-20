package icesi.PacMan.model;

public class Ghost {

<<<<<<< HEAD
    private String color;
    private String name;
    protected GhostBehaviour behaviour;
    private int scatterTargetX;
    private int scatterTargetY;
    private  GhostState state;
    private GridGraph pathGraph;

    public void move(){

    }

    public void setBehaviour(GhostBehaviour behaviour){
        this.behaviour = behaviour;
=======
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
>>>>>>> af18c9f56d96d7170c39f572f417ebeeaf38e4a8
    }

    public void setBehavior(GhostBehavior behavior) {
        this.behavior = behavior;
    }
}
