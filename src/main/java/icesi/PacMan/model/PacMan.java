package icesi.PacMan.model;

public class PacMan {
    private int lives;
    private int score;
    private int x;
    private int y;
    private Direction direction;

    public PacMan(int lives) {
        this.lives = lives;
        this.score = 0;
        this.x = 14; // Posición inicial típica
        this.y = 23; // Posición inicial típica
        this.direction = Direction.RIGHT;
    }

    public void move() {
        // Lógica de movimiento de Pac-Man
        switch (direction) {
            case UP: y--; break;
            case DOWN: y++; break;
            case LEFT: x--; break;
            case RIGHT: x++; break;
        }
    }

    public void eatPellet() {
        score += 10;
    }

    public void eatPowerPellet() {
        score += 50;
        // Activar estado de frightened en fantasmas
    }


    public int getLives() { return lives; }
    public void setLives(int lives) { this.lives = lives; }
    public int getScore() { return score; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
}