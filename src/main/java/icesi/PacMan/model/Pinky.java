package icesi.PacMan.model;

public class Pinky extends Ghost {
    private int predictionTiles;

    public Pinky(String name, String color, int scatteraTargetX, int scatteraTargetY, GhostBehavior behavior, GhostState state, GridGraph graph, int predictionTiles) {
        super(name, color, scatteraTargetX, scatteraTargetY, behavior, state, graph);
        this.predictionTiles = predictionTiles;
    }
}
