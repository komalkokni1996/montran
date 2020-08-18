package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueMasterDAO;
import com.montran.form.BookIssueMasterForm;
import com.montran.pojo.BookIssueMaster;

public class DeleteBookAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In DeleteBookAction execute()");
		BookIssueMasterDAO bookIssueMasterDAO = new BookIssueMasterDAO();
		System.out.println(" bookIssueMasterDAO OBJ Created");
		BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
		
		int issueSerialNumber = bookIssueMasterForm.getIssueSerialNumber();
		
		//BookIssueMaster IssuedBook = bookIssueMasterDAO.getBookById(issueSerialNumber);
		//	System.out.println("IssuedBook" + IssuedBook);
		bookIssueMasterDAO.deleteBook(issueSerialNumber);
		System.out.println("Book Deleted Successfully");
		
		return mapping.findForward("success");
	}
}
