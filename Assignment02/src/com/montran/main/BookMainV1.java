package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;

public class BookMainV1 {

	public static void main(String[] args) {
		Book book = new Book();
		
		Scanner scanner = new Scanner(System.in);
		
		book.input(101, "Java", 150);
		
		System.out.println(book);
		System.out.println("----------------------Books Store----------------------------------");
		System.out.println("Enter No. of Copies: ");
		int n = scanner.nextInt();
		if(n >0) {
			System.out.println("Total Purchase Amount: ");
			System.out.println("Rs." + book.purchase(n));
		}
		else {
			System.out.println("Please Enter Valid number.");
		}

	}

}
