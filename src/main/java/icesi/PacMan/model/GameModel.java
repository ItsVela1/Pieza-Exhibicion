package icesi.PacMan.model;

import icesi.PacMan.Structures.ListGraph;

import java.util.List;

public class GameModel {
    private ListGraph<Cell> Logicgraph;
    private PacMan pacMan;
    private GridGraph grid;
    private Ghost ghost;
    private int gridHeight;
    private int gridWidth;

    public GameModel(ListGraph<Cell> Logicgraph, PacMan pacMan, GridGraph grid,Ghost ghost, int gridHeight, int gridWidth) {
        this.Logicgraph= new ListGraph<>();
        this.pacMan = pacMan;
        this.grid = new GridGraph(gridWidth, gridHeight);
        this.ghost = ghost;
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
       BuldGameGraph();
    }
     private void BuldGameGraph(){
        for(int y=0;y<gridHeight;y++){
            for(int x=0;x<gridWidth;x++){
                Cell c=grid.getCell(x,y);
                if (c.getType() != CellType.WALL){
                    Logicgraph.addVertex(c);
                }
            }
        }
        for(int y=0;y<gridHeight;y++){
            for(int x=0;x<gridWidth;x++){
                Cell c=grid.getCell(x,y);
                if (c.getType() != CellType.WALL)continue;
                List<Cell> vecinos=grid.neighbors(c);
                for (Cell n:vecinos){
                    if (n.getType() != CellType.WALL){
                        Logicgraph.addEdge(c,n,1);
                    }
                }
            }
        }
        System.out.println("Vertices creados"+Logicgraph.vertexCount());
        System.out.println("Aristas  creados"+Logicgraph.edgeCount());
     }


}
