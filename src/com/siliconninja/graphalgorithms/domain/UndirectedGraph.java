package com.siliconninja.graphalgorithms.domain;

import com.siliconninja.graphalgorithms.data_source.Edge;
import com.siliconninja.graphalgorithms.data_source.Vertex;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {
    // Use strategy pattern by composing IGraphAlgorithm (note, a general "object" that runs the algorithm itself
    // such as Graph with its own properties surrounds the strategy pattern.)
    private IGraphAlgorithm algorithm;
    // program to the interface, not to the implementation. really gets you when you want to be efficient at
    // using a different implementation (e.g. hashmap in main).
    private Collection<Vertex> vertices;
    private Collection<Edge> edges;

    public UndirectedGraph(IGraphAlgorithm algorithm, Collection<Vertex> vertices, List<Edge> edges) {
        this.algorithm = algorithm;
        this.vertices = vertices;
        this.edges = edges;
    }

    public IGraphAlgorithm getAlgorithm() {
        return algorithm;
    }

    public Collection<Vertex> getVertices() {
        return vertices;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    // single source!
    public Map<Vertex, Float> runAlgorithm(Vertex startVertex) {
        return this.algorithm.findShortestPaths(startVertex, this);
    }
}
