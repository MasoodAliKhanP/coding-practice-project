package com.lld.design.ride;

import java.util.ArrayList;
import java.util.List;

public class MainDriver {
	public static void main(String[] args) {
		Rider rider = new Rider(1, "Lucifer");
		Driver driver = new Driver("Amenadiel");
		Rider rider1 = new Rider(2, "Chloe");
		Rider rider2 = new Rider(3, "Maze");

		List<Rider> riders = new ArrayList<>();
		riders.add(rider);
		riders.add(rider1);
		riders.add(rider2);
		RideShareSystem ridesystem = new RideShareSystem(3, riders);

		rider.createRide(1, 50, 60, 1);
		System.out.println("Close ride: " + rider.closeRide());
		rider.updateRide(1, 50, 60, 2);
		System.out.println("Close ride: " + rider.closeRide());
		System.out.println("*****************************************************************");

		ridesystem.createRide(1, 1, 50, 60, 1);
		ridesystem.withdrawRide(1, 1);
		ridesystem.updateRide(1, 1, 50, 60, 2);
		System.out.println("Close ride: " + rider.closeRide());

		System.out.println("*****************************************************************");

		ridesystem.createRide(1, 1, 50, 60, 1);
		ridesystem.updateRide(1, 1, 50, 60, 2);
		System.out.println("Close ride: " + ridesystem.closeRide(1));
	}
	
}
