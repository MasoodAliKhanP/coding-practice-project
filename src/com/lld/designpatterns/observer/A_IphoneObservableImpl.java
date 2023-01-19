package com.lld.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class A_IphoneObservableImpl implements A_StockObservable{
	List<B_NotificationObserver> observerList = new ArrayList<>();
	int stockCount = 0;

	
	@Override
	public void add(B_NotificationObserver obs) {
		observerList.add(obs);
	}

	@Override
	public void remove(B_NotificationObserver obs) {
		observerList.remove(obs);
	}

	@Override
	public void notifySubscribers() {
		for(B_NotificationObserver ob: observerList) {
			ob.update();
		}
	}

	@Override
	public void setNewStockCount(int newStockCount) {
		if(this.stockCount == 0) {
			notifySubscribers();
		}
		this.stockCount = newStockCount;
	}

}
