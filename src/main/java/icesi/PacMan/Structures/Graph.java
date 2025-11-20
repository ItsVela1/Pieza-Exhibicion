package icesi.PacMan.Structures;
import java.util.List;
import java.util.Map;

public interface Graph<T> {


        boolean addVertex(T v);
        boolean removeVertex(T v);
        boolean addEdge(T from, T to, int weight);
        boolean removeEdge(T from, T to);
        List<T> getNeighbors(T v);

        List<T> bfs(T start);
        List<T> dfs(T start);


        Map<T, Integer> dijkstra(T start);
        int[][] floydWarshall();


        List<Edge<T>> prim();
        List<Edge<T>> kruskal();


        int vertexCount();
        int edgeCount();
    }



