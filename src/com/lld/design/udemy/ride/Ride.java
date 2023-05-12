package com.lld.design.udemy.ride;

public class Ride {
	static final int AMT_PER_KM = 20;
	
	private int id;
	private int origin;
	private int dest;
	private int seats;
	private RideStatus rideStatus;
	
	public Ride() {
		this.id = this.origin = this.dest = this.seats = 0;
		this.rideStatus = RideStatus.IDLE;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestination() {
		return dest;
	}

	public void setDestination(int destination) {
		this.dest = destination;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus status) {
		this.rideStatus = status;
	}

	
	public int calculateFare(boolean isPriority) {
		if(seats >= 2) {
			return (int) ((dest - origin) * seats * (isPriority? 0.5: 0.75) * Ride.AMT_PER_KM);
		}
		return (int) ((dest - origin) * (isPriority? 0.75: 1) * Ride.AMT_PER_KM);
	}
	
}
