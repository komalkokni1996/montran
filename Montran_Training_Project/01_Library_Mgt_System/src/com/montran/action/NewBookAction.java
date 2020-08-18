package com.montran.action;

import java.time.LocalDate;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueMasterDAO;
import com.montran.form.BookIssueMasterForm;
import com.montran.pojo.BookIssueMaster;
import com.montran.pojo.BookMaster;
import com.montran.pojo.MemberMaster;

public class NewBookAction extends Action{

		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("In ActionForward execute()");
			BookIssueMasterDAO bookIssueMasterDAO = new BookIssueMasterDAO();
			System.out.println("BookIssueMasterDAO OBJ Created");
			Enumeration<String> param = request.getParameterNames();
			while (param.hasMoreElements()) {
				System.out.println("");
				String temp = (String) param.nextElement();

				System.out.println(request.getParameter(temp));
			}
			if (request.getParameter("getMember") != null) {
				System.out.println(request.getParameter("getMember"));
			}
			
			//getting bookIssueMasterForm  object
			BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
			System.out.println("BookIssueMasterForm object is set");
			
			// transfering data from bookIssueMasterForm to new BookIssueMaster Object
			BookIssueMaster bookIssueMaster = new BookIssueMaster();
			//System.out.println("bookIssueMaster Object DATA Printing");
		//	System.out.println(bookIssueMaster);
			bookIssueMaster.setIssueSerialNumber(bookIssueMasterDAO.issueNewBook(bookIssueMaster));
			//bookIssueMaster.setDateOfIssue(dateOfIssue);
			
			//bookIssueMaster.setMember(bookIssueMasterForm.getMember().getMemberCode());
			/*
			 * BookIssueReturn bookIssueReturn = new BookIssueReturn();
			 * System.out.println("bookIssueReturn Object DATA Printing");
			 * System.out.println(bookIssueReturn);
			 * bookIssueReturn.setIssueSerialNumber(newBookForm.getIssueSerialNumber() + 1);
			 * //String name= bookIssueReturn.getMember().getName(); //
			 * bookIssueReturn.getMember().setName(name);
			 * 
			 * bookIssueReturn.setDateOfIssue(newBookForm.getDateOfIssue());
			 * 
			 * bookIssueReturn.setDueDateOfReturn(newBookForm.getDueDateOfReturn());
			 * 
			 * //// pass new bookIssueReturn to Hibernate :: insert into database BookDAO
			 * bookDAO = new BookDAO(); bookDAO.issueNewBook(bookIssueReturn);
			 */
			System.out.println("Book ADDED Successfully");
			
			return mapping.findForward("success");
		}
}
