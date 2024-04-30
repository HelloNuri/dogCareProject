package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.RegistrationServiceImpl;

public class FindPw implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "static/json/false.jsp";
		String userId = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		if(new RegistrationServiceImpl().resetPassword(userId, name, email)){
			url = "static/json/true.jsp";
		};
		return url;
	}

}
