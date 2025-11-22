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
        // Posición inicial fantasmas
        this.x = scatterTargetX;
        this.y = scatterTargetY;
    }

    public void move(PacMan pacman){
        if (behavior != null) {
            behavior.move(this, pacman, graph);
        }
    }

    public String getName() { return name; }
    public String getColor() { return color; }
    public int getScatterTargetX() { return scatterTargetX; }
    public int getScatterTargetY() { return scatterTargetY; }
    public GhostState getState() { return state; }
    public void setState(GhostState state) { this.state = state; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

}
