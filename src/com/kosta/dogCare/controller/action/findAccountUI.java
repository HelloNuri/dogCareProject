package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class findAccountUI implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "static/html/find_account.html";
		return url;
	}

}
