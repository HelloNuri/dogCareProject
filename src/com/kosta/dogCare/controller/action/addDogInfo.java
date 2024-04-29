package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class addDogInfo implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
 		String url = "static/js/history_back.js";
		return url;
	}

}
