package com.lld.designpatterns.observer;

public interface A_StockObservable {
	public void add(B_NotificationObserver obs);
	public void remove(B_NotificationObserver obs);
	public void notifySubscribers();
	public void setNewStockCount(int newStockCount);	
}
