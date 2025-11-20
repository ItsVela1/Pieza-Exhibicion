package icesi.PacMan.Structures;

public class Edge<T> {
    public T from;
    public T to;
    public int weight;

    public Edge(T from, T to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return from + " -> " + to + " (w=" + weight + ")";
    }
}

