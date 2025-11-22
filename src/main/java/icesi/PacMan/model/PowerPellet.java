package icesi.PacMan.model;

public class PowerPellet {

    private int points;
    private float duration;

    public PowerPellet(int points, float duration) {
        this.points = points;
        this.duration = duration;
    }

    public int getPoints() {
        return points; }
    public float getDuration() {
        return duration; }
}
