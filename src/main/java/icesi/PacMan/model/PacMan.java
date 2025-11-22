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
        this.x = 1; // Posición inicial
        this.y = 1; // Posición inicial
        this.direction = Direction.D;
    }

    public void move() {
        int speed = 3; // <<< velocidad en píxeles

        switch (direction) {
            case W -> y -= speed;
            case S -> y += speed;
            case A -> x -= speed;
            case D -> x += speed;
        }
    }


    private boolean canMove(int newX, int newY) {
        return newX >= 0 && newX < 15 && newY >= 0 && newY < 15;
    }

    public void loseLife() {
        lives--;

        x = 1;
        y = 1;
    }

    public int getLives() { return lives; }
    public int getScore() { return score; }
    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }


}