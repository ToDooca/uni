package algorithims;

import dataStructures.Edge;
import dataStructures.Graph;
import javafx.util.Pair;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    public static String dijkstra_GetMinDistances(Graph graph, int sourceVertex) {
        int vertices = graph.getVertices();
        boolean[] SPT = new boolean[vertices];

        int[] distance = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                int key1 = p1.getKey();
                int key2 = p2.getKey();
                return key1 - key2;
            }
        });

        distance[0] = 0;
        Pair<Integer, Integer> p0 = new Pair<>(distance[0], 0);

        priorityQueue.offer(p0);

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> extractedPair = priorityQueue.poll();

            int extractedVertex = extractedPair.getValue();
            if (!SPT[extractedVertex]) {
                SPT[extractedVertex] = true;

                LinkedList<Edge> list = graph.getAdjacencyList()[extractedVertex];

                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    int destination = edge.getDestination();
                    if (SPT[destination] == false) {
                        int newKey = distance[extractedVertex] + edge.getWeight();
                        int currentKey = distance[destination];
                        if (currentKey > newKey) {
                            Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                            priorityQueue.offer(p);
                            distance[destination] = newKey;
                        }
                    }
                }
            }
        }
        printDijkstra(graph, sourceVertex, distance);
        String s = "";
        s+= graph.getLokacijaList().get(sourceVertex).toString() + "->" + graph.getLokacijaList().get( graph.getVertices()-1).toString() + " = " +distance[ graph.getVertices()-1];

         return s;
    }

    public static void printDijkstra(Graph graph, int sourceVertex, int[] distance){
        for (int i = 0; i <graph.getVertices() ; i++) {
            System.out.println("Source : " + sourceVertex + " "+ graph.getLokacijaList().get(sourceVertex) + " to  " +   i + " " + graph.getLokacijaList().get(i) + " "+
                    " distance: " + distance[i]);
        }
    }
}
