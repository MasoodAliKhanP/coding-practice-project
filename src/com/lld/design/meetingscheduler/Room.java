package com.lld.design.meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String name;
	private List<Meeting> calander;
	
	Room(String name){
		this.name = name;
		this.calander = new ArrayList<>();
	}
	
	String getName() {
		return this.name;
	}

	boolean bookARoom(int startTime, int endTime) {
		for(Meeting m : calander) {
			if(m.getStartTime() < endTime && startTime < m.getEndTime()) {
				return false;
			}
		}
		
		Meeting m = new Meeting(this, startTime, endTime);
		calander.add(m);
		return true;
	}
}
