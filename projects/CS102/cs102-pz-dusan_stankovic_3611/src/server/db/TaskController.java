package server.db;

import database.Task;
import database.TaskCategory;
import database.TaskDeadline;

import java.sql.*;
import java.util.ArrayList;

public class TaskController {

	public static int addTask(Task task) {
		String query = "insert into task (task_text, deadline, category, isdone) values (?, ?, ?, ?);";
		try (Connection con = DBController.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, task.getText());
			statement.setString(2, task.getTaskDeadline().toString());
			statement.setString(3, task.getTaskCategory().toString());
			statement.setBoolean(4, task.isDone());
			statement.execute();

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return -1;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return -1;
		}

	}


	public static ArrayList<Task> getTasks() {
		String query = "select * from task;";
		ArrayList<Task> tasks = new ArrayList<>();

		try (Connection con = DBController.getConnection()) {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String text = resultSet.getString(2);
				TaskDeadline deadline = TaskDeadline.valueOf(resultSet.getString(3));
				TaskCategory category = TaskCategory.valueOf(resultSet.getString(4));
				boolean isDone = resultSet.getBoolean(5);
				Task task = new Task(id, text, deadline, category, isDone);
				tasks.add(task);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tasks;
	}

	public static Task getTask(int taskId) {
		String query = "select * from task where task_id = ?;";
		System.out.println(taskId);
		Task task = null;
		try (Connection con = DBController.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, taskId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()){
				int id = resultSet.getInt(1);
				String text = resultSet.getString(2);
				TaskDeadline deadline = TaskDeadline.valueOf(resultSet.getString(3));
				TaskCategory category = TaskCategory.valueOf(resultSet.getString(4));
				boolean isDone = resultSet.getBoolean(5);
				task = new Task(id, text, deadline, category, isDone);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return task;
	}


	public static void setTaskDone(int id) {
		String query = "update task set isdone = 1 where task_id = ?;";

		try (Connection con = DBController.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			//statement.setBoolean(1, isDone);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteTask(int id) {
		String query = "delete from task where task_id = ?;";

		try (Connection con = DBController.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
