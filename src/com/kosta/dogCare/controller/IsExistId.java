package com.kosta.dogCare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.RegistrationServiceImpl;
import com.kosta.dogCare.controller.action.Action;

public class IsExistId implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		//Id로 닉네임을 찾아서 null이 아니면 이미 존재하는 아이디
		String url = "static/json/true.jsp";
		
		String userId = request.getParameter("id");
		String nickname = new RegistrationServiceImpl().getNicknameById(userId);
		if(nickname == null)
			url = "static/json/false.jsp";
		return url;
	}

}
