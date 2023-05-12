package com.lld.designpatterns.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
	
	EmployeeDaoImpl empDaoImpl;
	
	public EmployeeDaoProxy() {
		this.empDaoImpl = new EmployeeDaoImpl();
	}
	@Override
	public void create(String client, Employee emp) throws Exception {
		if(!client.equals("ADMIN")) {
			System.out.println("permission denied.");
			return;
		}
		empDaoImpl.create(client, emp);
	}

	@Override
	public void update(String client, Employee emp) throws Exception {
		if(client.equals("ADMIN")|| client.equals("RISK")) {
			empDaoImpl.update(client, emp);
			return;
		}
		System.out.println("permission denied.");
	}

	@Override
	public void delete(String client, Employee emp) throws Exception {
		//some logic
	}

}
