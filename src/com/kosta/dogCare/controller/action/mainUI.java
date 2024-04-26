package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class mainUI implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "controller?cmd=loginUI";
		return url;
	}

}
