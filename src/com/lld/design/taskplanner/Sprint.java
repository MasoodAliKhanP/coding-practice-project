package com.lld.design.taskplanner;

import java.util.ArrayList;
import java.util.List;


public class Sprint {
	static final int SPRINT_DURATION = 14;
	private int id;
	

	private int startTime;
	private int endTime;
	private String description;
	private List<Task>  tasks;
	
	public Sprint(int id, int startTime, int endTime, String description) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.tasks = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void remove(Task task) {
		tasks.remove(task);
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public List<Task> getUserTasks(User user){
		List<Task> userTasks = new ArrayList<>();
		for(Task task: tasks) {
			if(task.getUser().getName().equals(user.getName())) {
				userTasks.add(task);
			}
		}
		return userTasks;
	}
	
	public String printDetails() {
		return "Sprint [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", description=" + description
				+ ", tasks=" + tasks + "]";
	}
}
