package com.lld.design.meetingscheduler;

import java.util.List;

public class Scheduler {
	List<Room> rooms;
	
	public Scheduler(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public String bookAMeetingRoom(int  startTime, int endTime) {
		for(Room room: rooms) {
			boolean isBooked = room.bookARoom(startTime, endTime);
			if(isBooked == true)
				return room.getName();
		}
		
		return "No rooms available";
	}
}
