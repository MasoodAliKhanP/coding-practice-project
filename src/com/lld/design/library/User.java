package com.lld.design.library;

import java.util.List;

public class User {
	int id;
	String name;
//	Library library; //user will use library (has a), not right
	List<BookItem> borrowedBooks;
	
	User(int id, String name, List<BookItem> borrowedBooks){
		this.id = id;
		this.name = name;
		this.borrowedBooks = borrowedBooks;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		User user = (User) obj;
		return (user.getId() == this.id && user.getName().equals(this.name));
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	public void borrowBook(BookItem bItem){
		borrowedBooks.add(bItem);
	}
	
	public void returnBook(BookItem bItem){
		borrowedBooks.remove(bItem);
	}
}
