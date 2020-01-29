package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		MemberDAO2 dao = new MemberDAO2();
		
		
		String id = request.getParameter("id");
		
		MemberDTO dto = dao.updateui(id);
		
		request.setAttribute("dto", dto);
		
		
		
	return new CommandAction(false, "updateui.do");
	}

}
