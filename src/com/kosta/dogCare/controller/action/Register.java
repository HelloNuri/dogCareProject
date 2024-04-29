package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kosta.dogCare.Service.RegistrationServiceImpl;
import com.kosta.dogCare.model.VO.UserVO;

public class Register implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String userId   = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String name     = request.getParameter("name");
		String pwd      = request.getParameter("password");
		String email    = request.getParameter("email");
		String url = "controller?cmd=registerUI";
		
		UserVO user = new UserVO(userId, nickname, name, pwd, email);
		
		if(isCorrectValidationNumber(request) && new RegistrationServiceImpl().register(user)){
			url = "controller?cmd=loginUI";
		}
		return url;
	}

	private boolean isCorrectValidationNumber(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String numInputName = "vNumber";
		String    numSessionAttr = "vNumber";
		String maxAgeSessionAttr = "vNumberMaxAge";
		
		String actualNum = request.getParameter(numInputName);
		String expectedNum   = (String)        session.getAttribute(numSessionAttr);
		LocalDateTime maxAge = (LocalDateTime) session.getAttribute(maxAgeSessionAttr);
		
		if(expectedNum == null || maxAge.isAfter(LocalDateTime.now()))
			return false;	
		
		if(actualNum.equals(expectedNum)){
			session.removeAttribute(numSessionAttr);
			session.removeAttribute(maxAgeSessionAttr);
			return true;
		}
		
		return false;//쓸일없음
	}

}
