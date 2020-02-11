package com.siliconninja.graphalgorithms.data_source;

public class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;
    private float weight;

    public Edge(Vertex fromVertex, Vertex toVertex, float weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public float getWeight() {
        return weight;
    }
}
