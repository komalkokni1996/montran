package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueMasterDAO;
import com.montran.form.BookIssueMasterForm;
import com.montran.pojo.BookIssueMaster;

public class BookIssueMasterAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("In BookIssueMasterAction execute()");
		BookIssueMasterDAO bookIssueMasterDAO = new BookIssueMasterDAO();
		System.out.println(" bookIssueMasterDAO OBJ Created");
		
		List<BookIssueMaster> issuedBookList = bookIssueMasterDAO.getAllIssuedBooks();
		System.out.println("IssuedBookList" + issuedBookList);
		
		BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
	//	HttpSession httpSession = request.getSession();
		request.setAttribute("books", issuedBookList);
		return mapping.findForward("success");
	}
}
