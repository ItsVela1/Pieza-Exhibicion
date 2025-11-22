package icesi.PacMan.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private GridGraph grid;
    private PacMan pacman;
    private List<Ghost> ghosts;
    private int score;
    private boolean gameRunning;

    public GameModel() {
        this.grid = new GridGraph();
        this.pacman = new PacMan(3);
        this.ghosts = new ArrayList<>();
        this.score = 0;
        this.gameRunning = true;
        initializeSimpleLevel();
    }

    private void initializeSimpleLevel() {
        grid.initializeSimpleGrid();

        //Crea los fantasmas con sus comportamientos
        Ghost blinky = new Blinky("Blinky","Red",13,11,new BlinkyBehavior(), GhostState.CHASE, grid, 3);
        Ghost pinky = new Pinky("Pinky","Pink",13,11,new PinkyBehavior(), GhostState.CHASE, grid, 2);
        Ghost inky = new Inky("Inky","Cyan",13,11,new InkyBehavior(), GhostState.CHASE, grid, 5);
        Ghost clyde = new Clyde("Clyde","Orange",13,11,new ClydeBehavior(), GhostState.CHASE, grid, 8);

        // Posiciones Iniciales
        blinky.setX(13); blinky.setY(11);
        pinky.setX(12); pinky.setY(11);
        inky.setX(14); inky.setY(11);
        clyde.setX(13); clyde.setY(12);
    }

    // Inky necesita referencia de los demás fantasmas
    List<Ghost> otherGhosts = new ArrayList<>();
    otherGhosts.add(blinky);
    otherGhosts.add(pinky);
    otherGhosts.add(clyde);
    ((Inky)inky).setOtherGhosts(otherGhosts);

    ghosts.add(blinky);
    ghosts.add(pinky);
    ghosts.add(inky);
    ghosts.add(clyde);

    public void update(){
        if (!gameRunning) return;

        // Mover PacMan
        pacman.move();

        // Mover fantasmas (cada uno con su comportamiento)
        for (Ghost ghost : ghosts) {
            ghost.move(pacman);
        }

        // Verificar colisiones
        checkCollisions();
    }

    private void checkCollisions() {
        for (Ghost ghost : ghosts) {
            if (ghost.getX() == pacman.getX() && ghost.getY() == pacman.getY()){
                pacman.loseLife();
                if (pacman.getLives() == 0){
                    gameRunning = false;
                }
                //Reiniciar posicion tras colision
                resetPositions();
                break;
            }
        }
    }

    private void resetPositions() {
        pacman.setX(1);
        pacman.setY(1);

        ghosts.get(0).setX(13); ghosts.get(0).setY(11);
        ghosts.get(1).setX(12); ghosts.get(1).setY(11);
        ghosts.get(2).setX(14); ghosts.get(2).setY(11);
        ghosts.get(3).setX(13); ghosts.get(3).setY(12);
    }

    public void reset(){
        this.score = 0;
        this.pacman = new PacMan(3);
        this.gameRunning = true;
        initializeSimpleLevel();
    }
    public GridGraph getGrid() { return grid; }
    public PacMan getPacMan() { return pacman; }
    public List<Ghost> getGhosts() { return ghosts; }
    public int getScore() { return score; }
    public boolean isGameRunning() { return gameRunning; }

}
