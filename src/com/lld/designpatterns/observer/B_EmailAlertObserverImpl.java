package com.lld.designpatterns.observer;

public class B_EmailAlertObserverImpl implements B_NotificationObserver{
	String email;
	A_StockObservable stockObservable;
	
	public B_EmailAlertObserverImpl(String email, A_StockObservable stockObservable) {
		this.email = email;
		this.stockObservable = stockObservable;
	}
	
	@Override
	public void update() {
		sendEmail();
	}
	
	private void sendEmail() {
		System.out.println("Email sent to " + this.email);
	}

}
