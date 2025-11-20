package icesi.PacMan.model;

public class Ghost {

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
    }

}
