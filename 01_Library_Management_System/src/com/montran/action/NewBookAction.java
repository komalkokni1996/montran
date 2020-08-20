package com.montran.action;

import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueMasterDAO;
import com.montran.form.BookIssueMasterForm;
import com.montran.pojo.BookIssueMaster;
import com.montran.pojo.BookMaster;
import com.montran.pojo.MemberMaster;

public class NewBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In ActionForward execute()");
		// 
		BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
		BookIssueMasterDAO  bookIssueMasterDAO = new BookIssueMasterDAO();
		MemberMaster member = null;
		BookMaster book = null;
		BookIssueMaster bookIssueMaster = null;
		
		if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				System.out.println("getMember BTN clicked");
				System.out.println(bookIssueMasterForm.getMemberCode());
				member = bookIssueMasterDAO.getMemberByMemberCode(bookIssueMasterForm.getMemberCode());
				bookIssueMasterForm.setName(member.getName());
				return mapping.findForward("book");
			}
		}
		if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				System.out.println("getBook BTN clicked");
				book = bookIssueMasterDAO.getBookByBookCode(bookIssueMasterForm.getBookCode());
				bookIssueMasterForm.setBookAuthor(book.getBookAuthor());
				bookIssueMasterForm.setBookTitle(book.getBookTitle());
				
				LocalDate dateOfIssue = LocalDate.now() ;
				LocalDate dueDateOfReturn = LocalDate.now() ;
				
				member = bookIssueMasterDAO.getMemberByMemberCode(bookIssueMasterForm.getMemberCode());
				bookIssueMasterForm.setName(member.getName());
				
				if(member.getMemberType().equals("student")) {
					dueDateOfReturn = dueDateOfReturn.plusDays(10);
					System.out.println(bookIssueMasterForm);
				}
				if(member.getMemberType().equals("faculty")) {
					dueDateOfReturn = dueDateOfReturn.plusDays(90);
					System.out.println(bookIssueMasterForm);
				}
				bookIssueMasterForm.setDateOfIssue(dateOfIssue.toString());
				bookIssueMasterForm.setDueDateOfReturn(dueDateOfReturn.toString());
				System.out.println("-----------------------------");
				System.out.println(bookIssueMasterForm);
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("dateOfIssue", dateOfIssue);
				httpSession.setAttribute("dueDateOfReturn", dueDateOfReturn);
				return mapping.findForward("member");
			
			}
			
		}
		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("issueBook BTN clicked");
				//start from here
			}
		}
		System.out.println("Book ADDED Successfully");

		return mapping.findForward("success");
		

	}
}
