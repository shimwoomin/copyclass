package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateGoCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		 
		MemberDAO2 dao = new MemberDAO2();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sage = request.getParameter("age");
		
		int age =0;
		if (sage != null) {
			age = Integer.parseInt(sage);
		}
		
		MemberDTO dto = new MemberDTO(id, name, age);
		dao.update(dto);
		
		
		return new CommandAction(true, "list.do");
	}

}
