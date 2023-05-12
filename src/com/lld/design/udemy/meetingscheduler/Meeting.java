package com.lld.design.udemy.meetingscheduler;

public class Meeting {
	Room room;
	int startTime;
	int endTime;
	
	public Meeting(Room room, int startTime, int endTime){
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}
}
