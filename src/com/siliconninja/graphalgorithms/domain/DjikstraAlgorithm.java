package com.siliconninja.graphalgorithms.domain;

import com.siliconninja.graphalgorithms.data_source.Edge;
import com.siliconninja.graphalgorithms.data_source.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DjikstraAlgorithm implements IGraphAlgorithm {

    @Override
    public Map<Vertex, Float> findShortestPaths(Vertex startVertex, UndirectedGraph g) {
        float currentDistance = 0;

        List<Vertex> currentVertices = new ArrayList<>();

        // could also be 2 lists if you wanted
        Map<Vertex, Float> tentativeDistances = new HashMap<>();

        // initialize everything
        for(Vertex v : g.getVertices()) {
            tentativeDistances.put(v, Float.MAX_VALUE);
        }
        tentativeDistances.put(startVertex, (float) 0);
        currentVertices.add(startVertex);

        // until we've visited all vertices
        while(currentVertices.size() < g.getVertices().size()) {
            //Map<Vertex, Float> tempTentativeDistances = new HashMap<>(); // not needed if we just keep track of min in temp variable
            // get all edges reachable from current vertex and see which one is min relative to tentative distances
            // WARNING! look at the tree!
            List<Edge> reachables = new ArrayList<>();
            for(Vertex vertexInTree : currentVertices)  {
                for(Edge edgeFromThisVertex : vertexInTree.getEdges()) {
                    // need if statement to skip over already visited vertices!
                    // ~have to do both checks b/c undirected graph.~
                    // it is OK to come from an existing "from vertex" because that is how we build the tree.
                    /*if(!currentVertices.contains(edgeFromThisVertex.getToVertex()) &&
                            !currentVertices.contains(edgeFromThisVertex.getFromVertex())) {*/
                    if(!currentVertices.contains(edgeFromThisVertex.getToVertex())) {
                        reachables.add(edgeFromThisVertex);
                    }
                }
            }

            float minDistance = Float.MAX_VALUE;
            Edge minDistanceEdge = null; // it will be set, for simplicity assume it is. if not an NPE will be thrown
            for(Edge reachable : reachables) {
                float distanceIfWeVisitThisReachable = currentDistance + reachable.getWeight();
                // update the map of tentative distances, if the distance using this edge is smaller
                // ~NOT TODO_IS ALREADY RESOLVED fix the "to vertex" thing for the undirected graphs?~
                // it's reachable from a "from" vertex (a vertex we've already visited) so we can assume the from vertex is
                // just something in the tree (from above double for each loop), so just using the "to vertex" is OK
                if(distanceIfWeVisitThisReachable < tentativeDistances.get(reachable.getToVertex())) {
                    // NOTE: here, we'd add the last vertex visited if we were doing the math worksheet.
                    // it's just so it's easier to keep track of when doing this by hand (and prevent mistakes).
                    // in the actual algorithm, this is NOT necessary to do since only the min distance comparison
                    // is required, and already visited vertices' edges to this vertex (this "reachable")
                    // will not be reconsidered again
                    tentativeDistances.put(reachable.getToVertex(), distanceIfWeVisitThisReachable);
                }

                if(distanceIfWeVisitThisReachable < minDistance) {
                    minDistance = distanceIfWeVisitThisReachable;
                    minDistanceEdge = reachable;
                }
            }
            // add the vertex with the minimum distance to the tree to indicate that we "visited" it
            currentDistance += minDistance;
            currentVertices.add(minDistanceEdge.getToVertex());
        }

        return tentativeDistances;
    }
}
