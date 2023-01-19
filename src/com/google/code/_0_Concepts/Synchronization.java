package com.google.code._0_Concepts;

public class Synchronization implements Runnable {
	private String playerId;
	private String testId;
//	private int end;

	public Synchronization(String playerId, String testId) {
		super();
		this.playerId = playerId;
		this.testId = testId;
	}

	@Override
	public void run() {
		System.out.println("******** " + this.testId + " *********");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this.playerId) {
			for (int i = 0; i < 10; i++) {
				System.out.println("Playerid: " + this.testId);
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Synchronization("1", "10"));
		Thread t2 = new Thread(new Synchronization("1", "20"));
		Thread t3 = new Thread(new Synchronization("1", "30"));

		t1.start();
		t2.start();
		t3.start();
	}

}
