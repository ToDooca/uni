package client;

import database.Task;
import database.TaskCategory;
import database.TaskDeadline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static TableView<Task> taskView = new TableView();

    @Override
    public void start(Stage primaryStage) {

        Button add = new Button("+ add");
        Button finish = new Button("Finish");
        Button delete = new Button("Delete");

        try {
            taskList = Client.getTasks();
        } catch (IOException ex) {
            // if the connection to the server was unsuccessful
            // display message to the user
            Client.showMessage("Error", "Error", "Could not connect to the server.", Alert.AlertType.ERROR);
        }

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage newTaskStage = new Stage();
                BorderPane addTaskRoot = new BorderPane();
                Scene addTaskScene = new Scene(addTaskRoot, 450, 250);

                Label taskLabel = new Label("Enter task text:");
                Label deadlineLabel = new Label("Chose deadline:");
                Label categoryLabel = new Label("Chose category:");
                TextField taskText = new TextField();
                taskText.setPrefWidth(250);
                ComboBox<TaskDeadline> deadlineSelect = new ComboBox<>();
                deadlineSelect.getItems().setAll(TaskDeadline.values());
                deadlineSelect.getSelectionModel().selectFirst();
                ComboBox<TaskCategory> categorySelect = new ComboBox<>();
                categorySelect.getItems().setAll(TaskCategory.values());
                categorySelect.getSelectionModel().selectFirst();

                GridPane taskBox = new GridPane();
                taskBox.add(taskLabel, 0, 0);
                taskBox.add(taskText, 1, 0);
                taskBox.add(deadlineLabel, 0, 1);
                taskBox.add(deadlineSelect, 1, 1);
                taskBox.add(categoryLabel, 0, 2);
                taskBox.add(categorySelect, 1, 2);
                taskBox.setPadding(new Insets(30, 10, 10, 20));
                taskBox.setVgap(10);
                taskBox.setHgap(10);

                Button applyBtn = new Button("Apply");
                Button cancelBtn = new Button("Cancel");
                HBox bottomBox = new HBox(20);
                bottomBox.setAlignment(Pos.BASELINE_RIGHT);
                bottomBox.setPadding(new Insets(10, 25, 20, 10));
                bottomBox.getChildren().addAll(applyBtn, cancelBtn);

                cancelBtn.setOnMouseReleased(e1 -> newTaskStage.close());

                applyBtn.setOnMousePressed(e2 -> {
                    String text = taskText.getText();
                    TaskDeadline deadline = deadlineSelect.getValue();
                    TaskCategory category = categorySelect.getValue();
                    Task newTask = new Task(text, deadline, category);
                    Client.addTask(newTask);
                    try {
                        taskList = Client.getTasks();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    taskView.setItems(FXCollections.observableArrayList(taskList));
                    newTaskStage.close();
                });

                addTaskRoot.setCenter(taskBox);
                addTaskRoot.setBottom(bottomBox);

                newTaskStage.setTitle("Add new task");
                newTaskStage.setScene(addTaskScene);
                newTaskStage.setResizable(false);
                newTaskStage.setX(primaryStage.getX() + 100);
                newTaskStage.setY(primaryStage.getY() + 100);
                newTaskStage.show();
            }
        });

        taskView = new TableView<>(FXCollections.observableArrayList(taskList));

        taskView.setRowFactory(tv -> new TableRow<Task>() {
            @Override
            protected void updateItem(Task t, boolean empty) {
                super.updateItem(t, empty);
                if (t == null)
                    setStyle("");
                else if (t.getIsDone() == 1) {
                    setStyle("-fx-background-color: green");
                }
                else
                    setStyle("-fx-background-color: red");
            }
        });

        TableColumn<Task, String> idCol = new TableColumn("id");
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn<Task, String> taskCol = new TableColumn("Task");
        taskCol.setMinWidth(375);
        taskCol.setCellValueFactory(new PropertyValueFactory("text"));
        TableColumn<Task, String> deadlineCol = new TableColumn("Deadline");
        deadlineCol.setMinWidth(100);
        deadlineCol.setCellValueFactory(new PropertyValueFactory("TaskDeadline"));
        TableColumn<Task, String> categoryCol = new TableColumn("Category");
        categoryCol.setMinWidth(100);
        categoryCol.setCellValueFactory(new PropertyValueFactory("TaskCategory"));
//        TableColumn<Task, String> finishCol = new TableColumn("Done");
//        finishCol.setCellValueFactory(new PropertyValueFactory("isDone"));
        taskView.getColumns().addAll(idCol, taskCol, deadlineCol, categoryCol);


        VBox listBox = new VBox(10);
        listBox.setAlignment(Pos.CENTER);
        listBox.getChildren().add(taskView);

        HBox bottomBox = new HBox(200);
        bottomBox.setAlignment(Pos.BOTTOM_LEFT);
        bottomBox.setPadding(new Insets(10, 10, 10, 10));

        finish.setDisable(true);
        taskView.setOnMousePressed(e3 -> {
            finish.setDisable(false);
        });

        finish.setOnMousePressed(e4 -> {
            try {
                Client.doneTask(taskView.getSelectionModel().getSelectedItem().getId());
                taskList = Client.getTasks();
            } catch (IOException e) {
                e.printStackTrace();
            }
            taskView.setItems(FXCollections.observableArrayList(taskList));
        });

        delete.setOnMousePressed(e5 -> {
            try {
                Client.delTask(taskView.getSelectionModel().getSelectedItem().getId());
                taskList = Client.getTasks();
            } catch (IOException e) {
                e.printStackTrace();
            }
            taskView.setItems(FXCollections.observableArrayList(taskList));
        });

        bottomBox.getChildren().addAll(add, finish, delete);

        BorderPane root = new BorderPane();
        root.setBottom(bottomBox);
        root.setCenter(listBox);

        Scene scene = new Scene(root, 655, 400);

        primaryStage.setTitle("To Do List");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}


