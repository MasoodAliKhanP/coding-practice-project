package com.lld.designpatterns.proxy;

public interface EmployeeDao {
	public void create(String client, Employee emp) throws Exception;
	public void update(String client, Employee emp) throws Exception;
	public void delete(String client, Employee emp) throws Exception;
}
