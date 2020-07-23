package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {

	private Book books[]; //'books' array of type Book[]
	private int nextIndex=0;
	private int maxIndex;
	
	public BookUtil(int MaxBookLength) { //paramterized
		books = new Book[MaxBookLength]; // size of objects to create
		maxIndex = MaxBookLength;
	}
	
	//create getters
		public int getNextIndex() {
			return nextIndex;
		}

		public int getMaxIndex() {
			return maxIndex;
		}
		
	//functions
	public boolean addNewBook(Book book) {
		if(nextIndex >= 0 && nextIndex< maxIndex) {
			books[nextIndex] = book; //single book into books array
			nextIndex++;
			return true;
		}
		return false;
	}
	
	public boolean addAllBooks(Book books[]) {
		for(Book book : books) {
			 addNewBook(book);
			}
		return true;
	}
	
	public boolean updateBook(int bookID , String newName , double newPrice) {
		for(Book book : books) {
			if(book.getBookID()== bookID) {
				book.setName(newName);
				book.setPrice(newPrice);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteBook(int bookID) {
		for(int i=0; i < books.length;i++) {
			if(books[i].getBookID() == bookID) {
				books[i]= null;
				return true;
			}
		}
		return false;
	}
	
	public Book getBookByBookId(int bookID) {
		for(Book book : books) {
			if(book!=null) {
				if(book.getBookID() == bookID)
					return book;
			}
		}
		return null;
	}
	
	public Book[] getAllBooks() {
		return books;
	}
}
