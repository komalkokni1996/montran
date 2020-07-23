package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class BookMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		BookUtil bookUtil = new BookUtil(100);
		
		Book books[] = null;
		Book book;
		int bookID;
		String name;
		double price;
		int bookChoice =0;
		String continueChoice="";
		boolean result;
		int numberOfBooks;
		
		do {
			books = bookUtil.getAllBooks();
			for(Book bookTemp : books) {
				if(bookTemp!= null) {//check empty or not
					System.out.println(bookTemp.getBookID() + "\t" + bookTemp.getName() + "\t" + bookTemp.getPrice());
				}
			}
		System.out.println("\n----Menu-----");
		System.out.println("1. Add Single Book");
		System.out.println("2. Add Multiple Books");
		System.out.println("3. Update Existing Book");
		System.out.println("4. Delete Existing Book");
		System.out.println("5. Print Single Book Details");
		System.out.println("6. Exit");
		System.out.println("-----------------------------------------");
		
		System.out.println("Enter your choice: ");
		bookChoice = scanner.nextInt();
		
		switch (bookChoice) {
		case 1: 
			//
			System.out.println("Enter BookID: ");
			bookID = scanner.nextInt();
			scanner.nextLine(); //accepting space + String
			
			System.out.println("Enter Book Name:");
			name = scanner.nextLine();
			
			System.out.println("Enter Price:");
			price = scanner.nextDouble();
			
			book = new Book(bookID,name, price);
		    result = bookUtil.addNewBook(book);
		    if(result)
		    	System.out.println("Book Added Successfully..!!");
		    else
		    	System.out.println("Fail to Add Book..!!");
			break;
		
		case 2:
			System.out.println("How many books do you want to add ?");
			numberOfBooks = scanner.nextInt();
			if(numberOfBooks < (bookUtil.getMaxIndex() - bookUtil.getNextIndex())) {
				books = new Book[numberOfBooks];
				for(int i =0; i< numberOfBooks; i++) {
					System.out.println("Enter BookID: ");
					bookID = scanner.nextInt();
					scanner.nextLine(); //accepting space + String
					
					System.out.println("Enter Book Name:");
					name = scanner.nextLine();
					
					System.out.println("Enter Price:");
					price = scanner.nextDouble();
					
					book = new Book(bookID, name, price);
					books[i]= book;
				}
				bookUtil.addAllBooks(books);
				System.out.println("Books are Addedd !!");
			}else
				System.out.println("Insufficient Space");
			break;
			
		case 3: 
			System.out.println("Enter BookID: ");
			bookID = scanner.nextInt();
			scanner.nextLine();
			book= bookUtil.getBookByBookId(bookID);
			
			if(book != null) {
				System.out.println("Enter New Book Name:");
				name = scanner.nextLine();
				
				System.out.println("Enter New Price:");
				price = scanner.nextDouble();
			
			result= bookUtil.updateBook(bookID, name, price);
			if(result){
				System.out.println("Book Details are Updated Successfully..!!");
			}else 
				System.out.println("Failed to update Book details");
		}else
			System.out.println("No Book found !!");
			break;
			
		case 4: 
			System.out.println("Enter BookID: ");
			bookID = scanner.nextInt();
			book= bookUtil.getBookByBookId(bookID);
			if(book != null) {
				result = bookUtil.deleteBook(bookID);
				if(result) {
					System.out.println("Book Deleted Successfully");
				}else 
					System.out.println("Failed to Delete book");
			}else
					System.out.println("Book Not Found");
			break;
		
		case 5:
			System.out.println("Enter BookID: ");
			bookID = scanner.nextInt();
			book= bookUtil.getBookByBookId(bookID);
			if(book != null) {
				System.out.println(book);
			}else
				System.out.println("Book Not Found");
			break;
		case 6:
			System.out.println("Thank You");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		System.out.println("-----------------------------------");
		System.out.println("Do you want to continue ? [yes/no]");
		continueChoice = scanner.next();
		}while(continueChoice.equals("yes"));
		System.out.println("----Thank You------");
		scanner.close();
	}
}
