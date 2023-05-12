package com.lld.design.udemy.taskplanner;

public class Task {
	String type;
	TaskStatus status;
	String description;
	User user;
	
	public Task(String type, String description, User user) {
		this.type = type;
		this.status = TaskStatus.CREATED;
		this.description = description;
		this.user = user;
	}
	
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public User getUser() {
		return user;
	}
	
	public TaskStatus getStatus() {
		return status;
	}
}
