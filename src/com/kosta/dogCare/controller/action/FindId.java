package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.RegistrationServiceImpl;

public class FindId implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "static/json/findId.jsp";
		String email = request.getParameter("email");
		String userId = new RegistrationServiceImpl().getUserIdByEmail(email);
		request.setAttribute("userId", userId);
		return url;
	}

}
