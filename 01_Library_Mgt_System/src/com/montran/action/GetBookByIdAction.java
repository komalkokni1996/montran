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

public class GetBookByIdAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In BookIssueMasterAction execute()");
		BookIssueMasterDAO bookIssueMasterDAO = new BookIssueMasterDAO();
		System.out.println(" bookIssueMasterDAO OBJ Created");
		BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
		
		int issueSerialNumber = bookIssueMasterForm.getIssueSerialNumber();
		//List<BookIssueMaster> issuedBookList = bookIssueMasterDAO.getBookById(issueSerialNumber);
		BookIssueMaster IssuedBook = bookIssueMasterDAO.getBookById(issueSerialNumber);
		System.out.println("IssuedBook" + IssuedBook);
		
		request.setAttribute("book", IssuedBook);
		return mapping.findForward("success");
	}
}
