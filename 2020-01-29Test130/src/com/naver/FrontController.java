package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String what = uri.substring(cPath.length());

		Command com = null;

		if (what.equalsIgnoreCase("/insertui.do")) {
			com = new InsertUICommand();
		} else if (what.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if (what.equalsIgnoreCase("/list.do")) {
			com = new ListCommand();
		} else if (what.equalsIgnoreCase("/loginui.do")) {
			com = new loginUICommand();
		} else if (what.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if (what.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if (what.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		} else if (what.equalsIgnoreCase("/deleteui.do")) {
			com = new DeletUICommand();
			
		} else if (what.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		}else if (what.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		}else if (what.equalsIgnoreCase("/updatego.do")) {
			com = new UpdateGoCommand();
		}else if (what.equalsIgnoreCase("/read.do")) {
			com = new ReadCommand();
		}
		
		if (com != null) {
			CommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
