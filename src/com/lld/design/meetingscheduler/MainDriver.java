package com.lld.design.meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class MainDriver {
	public static void main(String[] args) {
		Room room1 = new Room("Hardwork");
		Room room2 = new Room("Smartwork");
		Room room3 = new Room("Nowork");

		List<Room> rooms = new ArrayList<>();
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);

		//No rooms available.
		Scheduler scheduler = new Scheduler(rooms);
		System.out.println(scheduler.bookAMeetingRoom(3, 5));
		System.out.println(scheduler.bookAMeetingRoom(3, 5));
		System.out.println(scheduler.bookAMeetingRoom(5, 6));
		System.out.println(scheduler.bookAMeetingRoom(1, 6));
		System.out.println(scheduler.bookAMeetingRoom(1, 6)); 
	}
}
