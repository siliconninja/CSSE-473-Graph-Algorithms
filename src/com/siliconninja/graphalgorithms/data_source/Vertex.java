package com.siliconninja.graphalgorithms.data_source;

import java.util.ArrayList;
import java.util.List;

// A data structure for vertices would belong in this layer.
public class Vertex {
    private char value;
    private List<Edge> edges;

    // in case we don't have any edges yet, and we want to make vertices first
    public Vertex(char value) {
        this.value = value;
        this.edges = new ArrayList<Edge>();
    }

    public Vertex(char value, List<Edge> edges) {
        this.value = value;
        this.edges = edges;
    }

    public char getValue() {
        return value;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge e) {
        this.edges.add(e);
    }
}
