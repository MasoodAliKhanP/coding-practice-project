package com.lld.designpatterns.observer;

public class MainDriver {
	public static void main(String[] args) {
		A_StockObservable iPhone = new A_IphoneObservableImpl();
		
		B_NotificationObserver email1 = new B_EmailAlertObserverImpl("masood@techmojo.in", iPhone);
		B_NotificationObserver email2 = new B_EmailAlertObserverImpl("hello@techmojo.in", iPhone);
		B_NotificationObserver message = new B_MessageAlertObserverImpl("9177196065", iPhone);
		
		iPhone.add(email1);
		iPhone.add(message);
		iPhone.add(email2);
		
		iPhone.setNewStockCount(10);
		iPhone.setNewStockCount(0);
		System.out.println();
		iPhone.setNewStockCount(10);
	}
}
