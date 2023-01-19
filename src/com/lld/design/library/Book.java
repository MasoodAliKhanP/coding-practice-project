package com.lld.design.library;

import java.util.List;

public class Book {
	String title;
	String genre;
	List<String> authors;
	int publishYear;
	String publisher;

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Book)) {
			return false;
		}

		Book b = (Book) obj;

		return title.equals(b.getTitle()) && authors.equals(b.getAuthors()) && publisher.equals(b.getPublisher())
				&& publishYear == b.getPublishYear() && genre.equals(b.getGenre());
	}
}
