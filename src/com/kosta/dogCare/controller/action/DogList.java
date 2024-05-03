package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kosta.dogCare.Service.DogRegistrationServiceImpl;
import com.kosta.dogCare.model.VO.DogVO;

public class DogList implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginId");
		Collection<DogVO> dogs = new DogRegistrationServiceImpl().getDogsByUserId(userId);
		request.setAttribute("dogs", dogs);
		return "static/json/dogList.jsp";
	}

}
