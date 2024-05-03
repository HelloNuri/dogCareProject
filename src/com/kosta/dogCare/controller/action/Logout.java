package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "controller?cmd=loginUI";
		HttpSession session = request.getSession();
		if(session != null)
			session.invalidate();
		return url;
	}

}
