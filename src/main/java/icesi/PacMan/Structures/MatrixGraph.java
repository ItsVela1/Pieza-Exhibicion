package icesi.PacMan.Structures;

import java.util.*;

public class MatrixGraph<T> implements Graph<T> {

    private List<T> V = new ArrayList<>();
    private int[][] M;
    private int n;
    private final int INF = Integer.MAX_VALUE / 4;

    public MatrixGraph() {
        this.M = new int[200][200];
        this.n = 0;

        for (int i = 0; i < 200; i++)
            Arrays.fill(M[i], INF);
    }

    @Override
    public boolean addVertex(T v) {
        if (V.contains(v)) return false;
        V.add(v);
        int idx = V.indexOf(v);
        M[idx][idx] = 0;
        n++;
        return true;
    }

    @Override
    public boolean removeVertex(T v) {
        int idx = V.indexOf(v);
        if (idx == -1) return false;
        V.remove(idx);
        n--;
        return true;
    }

    @Override
    public boolean addEdge(T from, T to, int weight) {
        int i = V.indexOf(from), j = V.indexOf(to);
        if (i == -1 || j == -1) return false;
        M[i][j] = weight;
        return true;
    }

    @Override
    public boolean removeEdge(T from, T to) {
        int i = V.indexOf(from), j = V.indexOf(to);
        if (i == -1 || j == -1) return false;
        M[i][j] = INF;
        return true;
    }

    @Override
    public List<T> getNeighbors(T v) {
        List<T> out = new ArrayList<>();
        int i = V.indexOf(v);
        if (i == -1) return out;

        for (int j = 0; j < n; j++)
            if (M[i][j] < INF && i != j)
                out.add(V.get(j));

        return out;
    }

    @Override
    public int vertexCount() { return n; }

    @Override
    public int edgeCount() {
        int c = 0;
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if (i!=j && M[i][j] < INF) c++;
        return c;
    }

    private ListGraph<T> toAdjList() {
        ListGraph<T> g = new ListGraph<>();

        for (T v : V) g.addVertex(v);

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                if (M[i][j] < INF && i!=j)
                    g.addEdge(V.get(i), V.get(j), M[i][j]);

        return g;
    }

    // Delegación de algoritmos
    @Override public List<T> bfs(T start){ return toAdjList().bfs(start); }
    @Override public List<T> dfs(T start){ return toAdjList().dfs(start); }
    @Override public Map<T,Integer> dijkstra(T start){ return toAdjList().dijkstra(start); }
    @Override public int[][] floydWarshall(){ return toAdjList().floydWarshall(); }
    @Override public List<Edge<T>> prim(){ return toAdjList().prim(); }
    @Override public List<Edge<T>> kruskal(){ return toAdjList().kruskal(); }
}
