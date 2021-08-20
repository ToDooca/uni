package sample;

import algorithims.Dijkstra;
import algorithims.QuickSort;
import dataStructures.Graph;
import model.Lokacija;

public class TestMain {

    public static void main(String[] args) {
        generate();
    }

    public static void generate() {
        Graph graph = new Graph(4);
        Lokacija lokacija = new Lokacija(0, "London");
        Lokacija lokacija2 = new Lokacija(1, "New York");
        Lokacija lokacija3 = new Lokacija(2, "Los Angeles");
        Lokacija lokacija4 = new Lokacija(3, "Peking");
        graph.getLokacijaList().add(lokacija);
        graph.getLokacijaList().add(lokacija2);
        graph.getLokacijaList().add(lokacija3);
        graph.getLokacijaList().add(lokacija4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(1, 3, 2);

        System.out.println(graph.countPaths(0, 3));

        System.out.println("************************************");

        Dijkstra.dijkstra_GetMinDistances(graph, 0);

        System.out.println("************************************");

        String s = "qwertyuioplkjhgfsadzxcvbnm";
        String s2 = "abcddsds";
        String saa[] = new String[2];
        saa[0] = s;
        saa[1] = s2;
        System.out.println(saa[0]);
        QuickSort.quickSort(saa, 0, 1);
        System.out.println(saa[0]);
    }

    public static Graph generateGraph(){
        Graph graph = new Graph(4);
        Lokacija lokacija = new Lokacija(0, "London");
        Lokacija lokacija2 = new Lokacija(1, "New York");
        Lokacija lokacija3 = new Lokacija(2, "Los Angeles");
        Lokacija lokacija4 = new Lokacija(3, "Peking");
        graph.getLokacijaList().add(lokacija);
        graph.getLokacijaList().add(lokacija2);
        graph.getLokacijaList().add(lokacija3);
        graph.getLokacijaList().add(lokacija4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(1, 3, 2);
        return graph;
    }


}
