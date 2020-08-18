package com.montran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.pojo.BookIssueMaster;
import com.montran.util.SessionFactoryUtil;

public class BookIssueMasterDAO {
	private Session session; // hibernate session
	private SessionFactory factory = SessionFactoryUtil.getFactory();
	private Transaction transaction; // org.hibernate.Transaction;
	private Query query; // org.hibernate.query.Query;
	private int issueSerialNumber;
	//List of Issued Books //Status: Working Proper
	public List<BookIssueMaster> getAllIssuedBooks() {
		System.out.println("In BookIssueMasterDAO getAllIssuedBook()");
		
		if (factory != null) {
		session = factory.openSession();
		query = session.createQuery("FROM book_issue_returns");
		List<BookIssueMaster> issuedBookList = query.getResultList();
		session.close();
		return issuedBookList;
		}
		else {
			return null;
		}
	}

	public int issueNewBook(BookIssueMaster addNewBook) {
		System.out.println("In BookIssueMasterDAO issueNewBook()");
		if (factory != null) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		issueSerialNumber = (int) session.save(addNewBook);
		transaction.commit();
		session.close();
		return issueSerialNumber;
		}
		else {
			System.out.println("Sorry...Factory Null");
			return 0;
		}
	}

	public boolean updateBook(BookIssueMaster bookIssueMaster) {
		System.out.println("In BookIssueMasterDAO updateBook()");

		if (factory != null) {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(bookIssueMaster); // Update Query
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBook(int issueSerialNumber) {
		System.out.println("In BookIssueMasterDAO deleteBook()");
		if (factory != null) {
			session = factory.openSession();
			transaction = session.beginTransaction();
			BookIssueMaster bookIssueMaster = getBookById(issueSerialNumber);
			session = factory.openSession();
			System.out.println("openSession() after getBookById()");
			session.delete(bookIssueMaster); // Delete Query
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}		
	}
	//Get Single Book //Status: Working Proper
	public BookIssueMaster getBookById(int issueSerialNumber) {
		System.out.println("In BookIssueMasterDAO getBookById()");
		if (factory != null) {
			session = factory.openSession();
			BookIssueMaster bookIssueMaster = session.get(BookIssueMaster.class, issueSerialNumber);
			
			if(bookIssueMaster != null) {
				session.close();
				return bookIssueMaster;
			}
			session.close();
			return null;
		}else {
			return null;
		}
	}
}
