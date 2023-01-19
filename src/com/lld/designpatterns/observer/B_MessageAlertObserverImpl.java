package com.lld.designpatterns.observer;

public class B_MessageAlertObserverImpl implements B_NotificationObserver{
	String phoneNumber;
	A_StockObservable stockObservable;
	
	public B_MessageAlertObserverImpl(String phoneNumber, A_StockObservable stockObservable) {
		this.phoneNumber = phoneNumber;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		sendMessage();
	}
	
	private void sendMessage() {
		System.out.println("Message sent to " + this.phoneNumber);
	}
}
