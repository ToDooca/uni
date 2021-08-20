package sample;

import algorithims.Dijkstra;
import algorithims.QuickSort;
import dataStructures.Edge;
import dataStructures.Graph;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main extends Application {

   public static String str = "";

    //grid
    Label labelPocetnaLokacija = new Label("Izaberite pocetnu lokaciju: ");
    Label labelKrajnjaLokacija = new Label("Izaberite krajnju lokaciju: ");
    ComboBox comboBoxPocetnaLokacija = new ComboBox();
    ComboBox ComboBoxKrajnjaLokacija = new ComboBox();

    Label labelPutanje = new Label("Broj mogucih putanja: ");
    TextField txtField = new TextField();

    Label lblNajkracaPutanja = new Label("Najkraca moguca putanja");
    TextField txtNajkracaPutanja = new TextField();

    Label lbl = new Label("Putanje: ");
    TextArea txt = new TextArea();

    Label sortlbl = new Label("Sortirane putanje: ");
    TextArea sortTxt = new TextArea();






    Button btn = new Button("Pokreni algoritme");
    @Override
    public void start(Stage primaryStage) throws Exception{
        Graph graph = TestMain.generateGraph();
        ArrayList<String> arrPocetna = new ArrayList<String>();
        ArrayList<String> arrKrajnja = new ArrayList<String>();
        for(int i = 0; i < graph.getLokacijaList().size(); i++){
            arrPocetna.add(graph.getLokacijaList().get(i).toString());
            arrKrajnja.add(graph.getLokacijaList().get(i).toString());
        }
        comboBoxPocetnaLokacija.setItems(FXCollections.observableArrayList(arrPocetna));
        ComboBoxKrajnjaLokacija.setItems(FXCollections.observableArrayList(arrKrajnja));



        GridPane gridPane = new GridPane();
        gridPane.add(labelPocetnaLokacija, 0, 0);
        gridPane.add(comboBoxPocetnaLokacija, 1, 0);
        gridPane.add(labelKrajnjaLokacija, 0, 1);
        gridPane.add(ComboBoxKrajnjaLokacija, 1, 1);
        gridPane.add(labelPutanje, 0, 2);
        gridPane.add(txtField, 1,2 );
        gridPane.add(lbl, 0, 3);
        txt.setMaxHeight(300);
        txt.setMaxWidth(300);
        gridPane.add(txt, 1, 3);
        gridPane.add(lblNajkracaPutanja, 0, 4);
        gridPane.add(txtNajkracaPutanja, 1, 4);
        gridPane.add(sortlbl, 0, 5);
        gridPane.add(sortTxt, 1, 5);
        gridPane.add(btn, 0, 6);


        btn.setOnAction(event -> {
            String a = comboBoxPocetnaLokacija.getSelectionModel().getSelectedItem().toString();
            String b = ComboBoxKrajnjaLokacija.getSelectionModel().getSelectedItem().toString();

            int a1 = comboBoxPocetnaLokacija.getSelectionModel().getSelectedIndex();
            System.out.println(a1);
            int a2 = ComboBoxKrajnjaLokacija.getSelectionModel().getSelectedIndex();
            System.out.println(a2);

            txtField.setText("" + graph.countPaths(a1, a2));

            printPaths(a1, a2, graph);
            txt.setText(str);
            System.out.println("String: " + str);

            txtNajkracaPutanja.setText(Dijkstra.dijkstra_GetMinDistances(graph, a1));

            String[] strArr = str.split("\n");
            QuickSort.quickSort(strArr, 0, strArr.length-1);
            String sPom = "";
            for(int i =  0; i < strArr.length; i++){
                sPom += strArr[i] + "\n";
            }
            sortTxt.setText(sPom);



        });

        primaryStage.setTitle("CS103-PZ");
        primaryStage.setScene(new Scene(gridPane, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void printPaths(int s, int d, Graph graph){
        Boolean[] visited = new Boolean[graph.getVertices()];
        int[] path = new int[graph.getVertices()];
        int path_index = 0;

        for(int i=0; i<graph.getVertices(); i++){
            visited[i] =false;
        }
        printPathsUtil(s,d,visited,path,path_index, graph);
    }

    public static void printPathsUtil(int s, int d, Boolean[] visited, int[] path, int path_index, Graph graph){
        visited[s] = true;
        path[path_index] = s;
        path_index++;

        if(s==d){
            for(int i=0; i<path_index; i++){
                System.out.print(path[i] + " " + graph.getLokacijaList().get(path[i]).toString());
                str+=graph.getLokacijaList().get(path[i]).toString();
                if(i != path_index-1){
                    str+="->";
                }
            }
            str+="\n";
            System.out.println();

        }
        else{
            LinkedList<Edge> list = graph.getAdjacencyList()[s];
            for(Edge i: list){
                if(!visited[i.getDestination()])
                    printPathsUtil(i.getDestination(),d,visited,path,path_index, graph);
            }
        }

        path_index--;
        visited[s]=false;

    }
}
