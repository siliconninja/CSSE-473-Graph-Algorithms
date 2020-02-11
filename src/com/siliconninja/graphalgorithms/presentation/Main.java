package com.siliconninja.graphalgorithms.presentation;

import com.siliconninja.graphalgorithms.data_source.Edge;
import com.siliconninja.graphalgorithms.data_source.Vertex;
import com.siliconninja.graphalgorithms.domain.DjikstraAlgorithm;
import com.siliconninja.graphalgorithms.domain.UndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // A testing application.
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        Map<Character, Vertex> vertices = new HashMap<>();
        // not using labels to avoid confusion with topological sort algorithm.
        // using in class exercise graph.
        String vertexValues = "sabcdef";
        for(char value : vertexValues.toCharArray()) {
            vertices.put(value, new Vertex(value));
        }

        // s->b  / 7
        String froms = "ssbccdcee";
        String tos = "bccdffefg";
        float[] weights = new float[] {7, 4, 3, 9, 13, 6, 2, 8, 11};
        // assume these above have same length
        for(int i = 0; i < froms.length(); i++) {
            Edge fromEdge = new Edge(vertices.get(froms.charAt(i)), vertices.get(tos.charAt(i)), weights[i]);
            Edge toEdge = new Edge(vertices.get(tos.charAt(i)), vertices.get(froms.charAt(i)), weights[i]);
            edges.add(fromEdge);
            edges.add(toEdge);
            // since this is undirected it goes both ways
            vertices.get(froms.charAt(i)).addEdge(fromEdge);
            // TODO fix this NPE
            Vertex q = vertices.get(tos.charAt(i));

            q.addEdge(toEdge);
        }

        UndirectedGraph g = new UndirectedGraph(new DjikstraAlgorithm(), vertices.values(), edges);
        g.runAlgorithm(vertices.get('s'));
    }
}
