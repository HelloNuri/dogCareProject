package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AddDogInfo implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
 		String url = "controller";
		return url;
	}

}
