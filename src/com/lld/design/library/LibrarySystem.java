package com.lld.design.library;

import java.util.List;
import java.util.Map;

public class LibrarySystem {
	String name;
	String address;
	List<BookItem> books;
	List<User> users;
//	Map<User,List<BookItem>> userBooks;
	
	public LibrarySystem(List<BookItem> books, List<User> users, Map<User,List<BookItem>> userBooks) {
		this.books = books;
//		this.userBooks = new HashMap<>();
		this.users = users;
	}
	public void borrowBook(User user, BookItem book) {
		if(!book.getIsAvailable()) {
			System.out.println("Requested book is unavailable.");
		}
		user.borrowBook(book);
		books.stream().forEach(b -> {
			if(b.getId() == book.getId()) {
//				userBooks.computeIfAbsent(user, v -> new ArrayList<>()).add(book);
				b.setIsAvailable(false);
			}
		});
		
	}
	
	public void returnBook(User user, BookItem book) {
		if(book.getIsAvailable()) {
			System.out.println("Book is already returned.");
		}
		user.returnBook(book);
		
		books.stream().forEach(b -> {
			if(b.getId() == book.getId()) {
//				userBooks.get(user).remove(book);
				b.setIsAvailable(true);
			}
		});
	}
	
}
