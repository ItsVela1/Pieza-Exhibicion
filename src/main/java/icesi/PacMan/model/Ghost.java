package icesi.PacMan.model;

public class Ghost {

    protected String name;
    protected String color;
    protected int scatterTargetX;
    protected int scatterTargetY;
    protected GhostBehavior behavior;
    protected  GhostState state;
    protected GridGraph graph;
    protected int x;
    protected int y;
    protected Direction direction;


    public Ghost(String name, String color, int scatterTargetX, int scatterTargetY,
                 GhostBehavior behavior, GhostState state, GridGraph graph) {
        this.name = name;
        this.color = color;
        this.scatterTargetX = scatterTargetX;
        this.scatterTargetY = scatterTargetY;
        this.behavior = behavior;
        this.state = state;
        this.graph = graph;
    }

}
