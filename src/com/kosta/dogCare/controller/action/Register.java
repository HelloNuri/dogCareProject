package com.kosta.dogCare.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.RegistrationServiceImpl;
import com.kosta.dogCare.model.VO.UserVO;

public class Register implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String name     = request.getParameter("name");
		String userId   = request.getParameter("id");
		String pwd      = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email    = request.getParameter("email");
		String valid    = request.getParameter("valid");
		String url = "controller?cmd=registerUI";
		UserVO user = new UserVO(userId, nickname, name, pwd, email);
		
		if(new RegistrationServiceImpl().register(user))
			url = "controller?cmd=loginUI";
		return url;
	}

}
