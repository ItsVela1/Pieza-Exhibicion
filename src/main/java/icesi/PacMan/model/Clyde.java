package icesi.PacMan.model;

<<<<<<< HEAD
public class Clyde {


=======
public class Clyde  extends Ghost {
    private int fearDistance;

    public Clyde(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph, int fearDistance) {
        super(name, color, scatteraTargetX, scatteraTargetY, behavior, state, graph);
        this.fearDistance = fearDistance;
    }
>>>>>>> af18c9f56d96d7170c39f572f417ebeeaf38e4a8
}
