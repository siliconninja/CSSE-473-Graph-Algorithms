package com.siliconninja.graphalgorithms.domain;

import com.siliconninja.graphalgorithms.data_source.Vertex;

import java.util.Map;

public interface IGraphAlgorithm {
    // by def. of the interface, a graph algorithm (single-source in this case) has to find the shortest path
    // to all other vertices.
    public Map<Vertex, Float> findShortestPaths(Vertex startVertex, UndirectedGraph g);
}
