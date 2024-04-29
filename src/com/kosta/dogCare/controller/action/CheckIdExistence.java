package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CheckIdExistence implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = ".json";
		return url;
	}

}
