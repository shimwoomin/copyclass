package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		MemberDAO2 dao = new MemberDAO2();
		MemberDTO dto = null;
		String id = request.getParameter("id");
		dto = dao.read(id);

		request.setAttribute("dto", dto);

		return new CommandAction(false, "read.jsp");
	}

}
