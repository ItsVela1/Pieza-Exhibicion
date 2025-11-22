package icesi.PacMan.model;

public class Pinky extends Ghost {
    private int predictionTiles;

    public Pinky(String name, String color, int scatterTargetX, int scatterTargetY,
                 GhostBehavior behavior, GhostState state, GridGraph graph, int predictionTiles) {
        super(name, color, scatterTargetX, scatterTargetY, behavior, state, graph);
        this.predictionTiles = predictionTiles;
    }

    public int getPredictionTiles() { return predictionTiles; }
}