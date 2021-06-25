package client;

import database.Task;
import database.TaskDeadline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Optional;

public class Client {
	private static final String host = "localhost";
	private static final int port = 8080;

	public static ArrayList<Task> getTasks() throws IOException {
		ArrayList<Task> tasks = new ArrayList<>();
		// connect to the server
		Socket socket = new Socket(host, port);

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

		// send the get all tasks command to populate the list
		writer.writeBytes("get&task\n");

		// read the response and parse tasks from it
		String response = readAll(reader);

		System.out.println(response);
		String[] taskArray = response.split("\n");

		for (String tstring : taskArray) {
			Task t = Task.parseTask(tstring);
			if (t != null) {
				tasks.add(t);
			}
		}
		System.out.println(tasks);
		return tasks;
	}

	private static String readAll(BufferedReader reader) throws IOException {
		int c;
		StringBuilder builder = new StringBuilder();
		while ((c = reader.read()) != -1) {
			builder.append((char) c);
		}
		return builder.toString();
	}

	public static Task addTask(Task task) {
		Socket socket = null;
		try {
			socket = new Socket(host, port);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

			writer.writeBytes(Task.getAddString(task));

			String response = readAll(reader);
			System.out.println(response);
			if (!response.equals("fail")){
				task.setId(Integer.parseInt(response.substring(response.indexOf("\n") + 1)));
				return task;
			} else {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void delTask(int id) throws IOException {
		Socket socket = new Socket(host, port);

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

		writer.writeBytes(String.format("del&task&%d\n", id));

		String response = readAll(reader);
		System.out.println(response);

		System.out.println(!response.equals("fail"));
	}

	public static void doneTask(int id) throws IOException {
		Socket socket = new Socket(host, port);

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

		writer.writeBytes(String.format("done&task&%d\n", id));

		String response = readAll(reader);
		System.out.println(response);

		System.out.println(!response.equals("fail"));
	}

	// helper function to show messages to the user
	public static Optional<ButtonType> showMessage(String title, String header, String text, Alert.AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(text);
		return alert.showAndWait();
	}
}
