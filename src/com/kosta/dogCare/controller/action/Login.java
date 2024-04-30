package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kosta.dogCare.Service.DogRegistrationServiceImpl;
import com.kosta.dogCare.Service.RegistrationServiceImpl;
import com.kosta.dogCare.model.VO.DogVO;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "controller?cmd=loginUI";
		String userId  = request.getParameter("id");
		String pw = request.getParameter("password");
		
		if(new RegistrationServiceImpl().login(userId, pw)){
			url = "controller?cmd=mainUI";
			HttpSession session = request.getSession();
			
			session.setAttribute("loginId", userId);
		}
		return url;
	}

}
