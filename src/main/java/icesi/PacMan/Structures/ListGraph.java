package icesi.PacMan.Structures;

import java.util.*;

public class ListGraph<T> implements Graph<T> {

    private Map<T, List<Edge<T>>> adj = new HashMap<>();



    @Override
    public boolean addVertex(T v) {
        if (adj.containsKey(v)) return false;
        adj.put(v, new ArrayList<>());
        return true;
    }

    @Override
    public boolean removeVertex(T v) {
        if (!adj.containsKey(v)) return false;
        adj.remove(v);
        adj.values().forEach(list -> list.removeIf(e -> e.to.equals(v)));
        return true;
    }

    @Override
    public boolean addEdge(T a, T b, int w) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) return false;
        adj.get(a).add(new Edge<>(a, b, w));
        return true;
    }

    @Override
    public boolean removeEdge(T a, T b) {
        if (!adj.containsKey(a)) return false;
        return adj.get(a).removeIf(e -> e.to.equals(b));
    }

    @Override
    public List<T> getNeighbors(T v) {
        List<T> out = new ArrayList<>();
        for (Edge<T> e : adj.getOrDefault(v, List.of())) out.add(e.to);
        return out;
    }

    @Override public int vertexCount() { return adj.size(); }

    @Override
    public int edgeCount() {
        int c = 0;
        for (List<Edge<T>> l : adj.values()) c += l.size();
        return c;
    }


    @Override
    public List<T> bfs(T start) {
        List<T> r = new ArrayList<>();
        if (!adj.containsKey(start)) return r;

        Queue<T> q = new LinkedList<>();
        Set<T> seen = new HashSet<>();

        q.add(start); seen.add(start);

        while (!q.isEmpty()) {
            T u = q.poll(); r.add(u);
            for (Edge<T> e : adj.get(u))
                if (seen.add(e.to)) q.add(e.to);
        }
        return r;
    }


    @Override
    public List<T> dfs(T start) {
        List<T> r = new ArrayList<>();
        dfsRec(start, new HashSet<>(), r);
        return r;
    }

    private void dfsRec(T u, Set<T> seen, List<T> r) {
        if (!adj.containsKey(u) || !seen.add(u)) return;
        r.add(u);
        for (Edge<T> e : adj.get(u)) dfsRec(e.to, seen, r);
    }


    @Override
    public Map<T, Integer> dijkstra(T start) {
        Map<T, Integer> dist = new HashMap<>();
        adj.keySet().forEach(v -> dist.put(v, Integer.MAX_VALUE));
        dist.put(start, 0);

        PriorityQueue<Edge<T>> pq =
                new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge<>(start, start, 0));

        while (!pq.isEmpty()) {
            Edge<T> cur = pq.poll();
            if (cur.weight > dist.get(cur.to)) continue;

            for (Edge<T> e : adj.get(cur.to)) {
                int nd = cur.weight + e.weight;
                if (nd < dist.get(e.to)) {
                    dist.put(e.to, nd);
                    pq.add(new Edge<>(cur.to, e.to, nd));
                }
            }
        }
        return dist;
    }


    @Override
    public int[][] floydWarshall() {
        int n = adj.keySet().size();
        List<T> V = new ArrayList<>(adj.keySet());
        int INF = Integer.MAX_VALUE / 4;
        int[][] d = new int[n][n];

        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                d[i][j] = (i==j?0:INF);

        for (int i=0;i<n;i++)
            for (Edge<T> e : adj.get(V.get(i))) {
                int j = V.indexOf(e.to);
                d[i][j] = e.weight;
            }

        for (int k=0;k<n;k++)
            for (int i=0;i<n;i++)
                for (int j=0;j<n;j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

        return d;
    }


    @Override
    public List<Edge<T>> prim() {
        List<Edge<T>> mst = new ArrayList<>();
        if (adj.isEmpty()) return mst;

        T start = adj.keySet().iterator().next();
        Set<T> vis = new HashSet<>();
        PriorityQueue<Edge<T>> pq =
                new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        vis.add(start);
        pq.addAll(adj.get(start));

        while (!pq.isEmpty()) {
            Edge<T> e = pq.poll();
            if (vis.contains(e.to)) continue;
            vis.add(e.to);
            mst.add(e);
            pq.addAll(adj.get(e.to));
        }
        return mst;
    }

    @Override
    public List<Edge<T>> kruskal() {
        List<Edge<T>> edges = new ArrayList<>();
        adj.values().forEach(edges::addAll);

        edges.sort(Comparator.comparingInt(e -> e.weight));

        Map<T,T> parent = new HashMap<>();
        adj.keySet().forEach(v -> parent.put(v, v));

        List<Edge<T>> mst = new ArrayList<>();

        for (Edge<T> e : edges) {
            T r1 = find(parent, e.from);
            T r2 = find(parent, e.to);
            if (!r1.equals(r2)) {
                mst.add(e);
                parent.put(r1, r2);
            }
        }
        return mst;
    }

    private T find(Map<T,T> p, T v) {
        return p.get(v).equals(v) ? v : find(p, p.get(v));
    }
}

