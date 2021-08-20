package dataStructures;

import model.Lokacija;
import sample.Main;
import sample.TestMain;

import java.util.*;

public class Graph {
    List<Lokacija> lokacijaList;
    int vertices;
    LinkedList<Edge>[] adjacencyList;

    public Graph(int vertices){
        lokacijaList = new ArrayList<>();
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight){
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].addFirst(edge);

        edge = new Edge(destination, source, weight);
        adjacencyList[destination].addFirst(edge);
    }

    public int getVertices() {
        return vertices;
    }

    public LinkedList<Edge>[] getAdjacencyList() {
        return adjacencyList;
    }

    public List<Lokacija> getLokacijaList() {
        return lokacijaList;
    }

    public void setLokacijaList(List<Lokacija> lokacijaList) {
        this.lokacijaList = lokacijaList;
    }

    int countPathsUtil(int u, int d,
                       boolean visited[],
                       int pathCount)
    {

        visited[u] = true;

        if (u == d)
        {
            pathCount++;
        }
        else
        {
            Iterator<Edge> i = adjacencyList[u].listIterator();
            while (i.hasNext())
            {
                Edge n = i.next();
                if (!visited[n.getDestination()])
                {
                    pathCount = countPathsUtil(n.getDestination(), d,
                            visited,
                            pathCount);
                }
            }
        }

        visited[u] = false;
        return pathCount;
    }

    public int countPaths(int s, int d)
    {

        boolean visited[] = new boolean[vertices];
        Arrays.fill(visited, false);

        int pathCount = 0;
        pathCount = countPathsUtil(s, d,
                visited,
                pathCount);
        return pathCount;
    }


}
