package server;

import database.Task;
import database.TaskCategory;
import database.TaskDeadline;
import server.db.DBController;
import server.db.TaskController;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class HandlerThread implements Runnable {
	private Socket socket;

	public HandlerThread(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
			// get  task
			// add  task
			// del  task
			// done task

			String request = reader.readLine();
			if (request != null) {
				String[] params = request.split("&");

				// parse commands from the request
				// requests are sent as "command param1 param2 ..."
				StringBuilder response = new StringBuilder();
				System.out.println(Arrays.deepToString(params));
				switch (params[0]) {
					case "get":
						// get&task
						// get&task&num
						if (params.length == 2 && params[1].equals("task")) {
							ArrayList<Task> tasks = TaskController.getTasks();
							for (Task task : tasks) {
								response.append(Task.toTaskString(task));
								response.append("\n");
							}
						} else if (params.length == 3 && params[1].equals("task")) {
							int id = Integer.parseInt(params[2]);
							Task task = TaskController.getTask(id);
							if (task != null) {
								response.append(Task.toTaskString(task));
								response.append("\n");
							}
						}
						break;
					case "add":
						// "add&task&text&deadline&category"
						if (params.length == 5) {
							String text = params[2];
							TaskDeadline deadline = TaskDeadline.valueOf(params[3]);
							TaskCategory category = TaskCategory.valueOf(params[4]);
							Task task = new Task(text, deadline, category, false);
							int id = TaskController.addTask(task);
							response.append(id);
						} else {
							response.append("fail");
						}
						break;
					case "del":
						// "del&task&id"
						if (params.length == 3) {
							int id = Integer.parseInt(params[2]);
							TaskController.deleteTask(id);
							response.append(id);
						} else {
							response.append("fail");
						}
						break;
					case "done":
						// "done&task&id"
						if (params.length == 3) {
							int id = Integer.parseInt(params[2]);
							TaskController.setTaskDone(id);
							response.append(id);
						} else {
							response.append("fail");
						}
						break;
				}

				// return the response to the user
				writer.writeBytes(response.toString());
			}
			reader.close();
			writer.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
