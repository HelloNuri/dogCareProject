package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "controller?cmd=loginUI";
		String id  = request.getParameter("id");
		String password = request.getParameter("password");
		
		//JDBC
		url = "controller?cmd=mainUI";
		return url;
	}

}
