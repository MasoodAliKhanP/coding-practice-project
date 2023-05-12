package com.lld.design.udemy.taskplanner;

import java.util.ArrayList;
import java.util.List;

public class User {
	String name;
	
	public String getName() {
		return name;
	}
	
	public void addTaskToSprint(Sprint sp, Task task) {
		sp.addTask(task);
	}
	
	public void removeTask(Sprint sp, Task task) {
		sp.remove(task);
	}
	
	public void updateStatus(Task task, TaskStatus status) {//input should be taskid
		task.setStatus(status);
	}
	
	public List<Task> getDelayedTasks(Sprint sp) {
		if((sp.getEndTime()-sp.getStartTime()) <= Sprint.SPRINT_DURATION ) {
			return new ArrayList<>();
		}
		List<Task> delayedTasks = new ArrayList<>();
		for(Task task: sp.getTasks()) {
			if(task.getStatus() != TaskStatus.CLOSED) {
				delayedTasks.add(task);
			}
		}
		return delayedTasks;
	}
	
	public List<Task> getTaskAssigned(Sprint sp, User user){
		return sp.getUserTasks(user);
	}
}
