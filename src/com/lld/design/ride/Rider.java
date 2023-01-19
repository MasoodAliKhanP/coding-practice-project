package com.lld.design.ride;

import java.util.ArrayList;
import java.util.List;

public class Rider extends Person{
	int id;
	Ride currentRide;
	List<Ride> completedRides;
	public Rider(int id, String name) {
		super(name);
		this.id = id;
		this.currentRide = new Ride();
		this.completedRides  = new ArrayList<>();
	}
	
	
	public int getId() {
		return id;
	}

	void createRide (int id, int origin, int destination, int seats) {
		if(origin > destination) {
			System.out.println("Invalid origin and destination values. Can not create ride.");
			return ;
		}
		currentRide.setId(id);
		currentRide.setOrigin(origin);
		currentRide.setDestination(destination);
		currentRide.setSeats(seats);
		currentRide.setRideStatus(RideStatus.CREATED);
	}
	
	void updateRide (int id, int origin, int destination, int seats){
		if(currentRide.getRideStatus() == RideStatus.WITHDRAWN) {
			System.out.println("Cannot update ride. Ride was withdrawn.");
			return;
		}
		if(currentRide.getRideStatus() == RideStatus.COMPLETED) {
			System.out.println("Cannot update ride. Ride was complete.");
			return;
		}

		createRide(id, origin, destination, seats);
	}
	
	void withdrawRide (int id) {
		if(currentRide.getId() != id) {
			System.out.println("Ride id mismatch. Cannot withdraw ride.");
			return;
		}
		if(currentRide.getRideStatus() != RideStatus.CREATED) {
			System.out.println("Ride was not in progress. Cannot withdraw.");
			return;
		}
		currentRide.setRideStatus(RideStatus.WITHDRAWN);
	}
	
	int closeRide() {
		if(currentRide.getRideStatus() != RideStatus.CREATED) {
			System.out.println("Ride was not in progress. Cannot close ride.");
			return 0;
		}
		currentRide.setRideStatus(RideStatus.COMPLETED);
		completedRides.add(currentRide);
		return currentRide.calculateFare(completedRides.size() >= 10);
	}
}
