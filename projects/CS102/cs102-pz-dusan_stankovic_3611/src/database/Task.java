package database;

import com.sun.org.apache.xpath.internal.operations.Bool;
import server.db.TaskController;

public class Task {
	private int id;
	private String text;
	private TaskDeadline deadline;
	private TaskCategory category;
	private boolean isDone;

	public Task() {
	}

	public Task(int id, String text, TaskDeadline deadline, TaskCategory category, boolean isDone) {
		this.id = id;
		this.text = text;
		this.deadline = deadline;
		this.category = category;
		this.isDone = isDone;
	}

	public Task(String text, TaskDeadline deadline, TaskCategory category) {
		this.text = text;
		this.deadline = deadline;
		this.category = category;
	}

	public Task(String text, TaskDeadline deadline, TaskCategory category, boolean isDone) {
		this(-1, text, deadline, category, isDone);
	}

	// id|text|deadline|category|isdone
	public static Task parseTask(String taskString) {
		String[] params = taskString.split("\\|");
		Task task = null;
		if (params.length == 5) {
			int id = Integer.parseInt(params[0]);
			String text = params[1];
			TaskDeadline deadline = TaskDeadline.valueOf(params[2]);
			TaskCategory category = TaskCategory.valueOf(params[3]);
			boolean isDone = Boolean.parseBoolean(params[4]);
			task = new Task(id, text, deadline, category, isDone);
		}

		return task;
	}

	// id|text|deadline|category|isdone
	public static String toTaskString(Task task) {
		return String.format("%d|%s|%s|%s|%s", task.id, task.text, task.deadline, task.category, task.isDone);
	}

	public static String getAddString(Task task) {
		return String.format("add&task&%s&%s&%s\n", task.getText(), task.getTaskDeadline().toString(), task.getTaskCategory().toString());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TaskDeadline getTaskDeadline() {
		return deadline;
	}

	public void setTaskDeadline(TaskDeadline deadline) {
		this.deadline = deadline;
	}

	public TaskCategory getTaskCategory() {
		return category;
	}

	public void setTaskCategory(TaskCategory category) {
		this.category = category;
	}

	public boolean isDone() {
		return isDone;
	}

	public int getIsDone() {
		return isDone? 1 : 0;
	}

	public void setDone(boolean done) {
		isDone = done;
	}

	@Override
	public String toString() {
		return id + " " +  text + " " +  deadline + " " +  category + "\n";
	}
}
