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

public class UpdateBookAction extends Action{

	private BookIssueMaster bookIssueMaster;
		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("in UpdateBookAction execute()");
			BookIssueMasterDAO bookIssueMasterDAO = new BookIssueMasterDAO();
			System.out.println(" bookIssueMasterDAO OBJ Created");
			BookIssueMasterForm bookIssueMasterForm = (BookIssueMasterForm) form;
			System.out.println("BookIssueMasterForm object is set");
			Boolean result = bookIssueMasterDAO.updateBook(bookIssueMaster);
			if(result== true) {
				System.out.println("Book Updated Successfully");
			}else
				System.out.println("Book Updation Failed");
			return mapping.findForward("success");
			
		}
}
