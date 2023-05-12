package com.lld.designpatterns.proxy;

public class MainDriver {
	public static void main(String[] args) throws Exception {
		EmployeeDaoProxy proxy = new EmployeeDaoProxy();
		proxy.create("USER", new Employee());
		
		proxy.create("ADMIN",  new Employee());
	}
}
