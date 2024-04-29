package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SendValidationNum implements Action {
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "static/json/false.jsp";
		int maxAgeMins = 3;
		
		String vNumber = createVNumber(); 
		LocalDateTime expiredDate = LocalDateTime.now().plusMinutes(maxAgeMins);
		
		HttpSession session = request.getSession();
		session.setAttribute("vNumber"      , vNumber);
		session.setAttribute("vNumberMaxAge", expiredDate);
		
		url = "static/json/true.jsp";
		return url;
	}

	private String createVNumber() {
		int vNumber = (int)(Math.random() * 9000) + 1000;//1000~9999 사이의 수 생성
		System.out.println(vNumber);
		return vNumber + "";
	}

}
