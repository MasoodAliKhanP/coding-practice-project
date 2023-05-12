package com.lld.designpatterns.proxy;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void create(String client, Employee emp) throws Exception {
		System.out.println("Employeee created.");
	}

	@Override
	public void update(String client, Employee emp) throws Exception {
		System.out.println("employee details updated.");
	}

	@Override
	public void delete(String client, Employee emp) throws Exception {
		System.out.println("employee deleted.");
	}

}
