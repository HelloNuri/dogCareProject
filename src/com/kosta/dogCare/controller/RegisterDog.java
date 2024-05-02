package com.kosta.dogCare.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kosta.dogCare.Service.DogInformationServiceImpl;
import com.kosta.dogCare.Service.DogRegistrationServiceImpl;
import com.kosta.dogCare.controller.action.Action;
import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.DogVO;
import com.kosta.dogCare.model.VO.SupplyVO;

public class RegisterDog implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String url = "controller?cmd=registerDogUI";
		HttpSession session = request.getSession();
		
		String name = request.getParameter("dog-name");
		String breed = request.getParameter("dog-breed");
		int age = Integer.parseInt(request.getParameter("dog-age"));
		Date birthDate = Date.valueOf(LocalDate.now().minusMonths(age));
		char gender = request.getParameter("dog-gender").charAt(0);
//		boolean neutrification = false;
		char neutrification = 'N';
		String userId = (String) session.getAttribute("loginId");
		double weight = Double.parseDouble(request.getParameter("dog-weight")); 
		double exerciseTime = Double.parseDouble(request.getParameter("dog-exercise"));
		String note = request.getParameter("dog-note");
		Timestamp uploadTime = Timestamp.valueOf(LocalDateTime.now());
		String [] categories = request.getParameterValues("supplyCategory");
		String [] names = request.getParameterValues("supplyName");
		
		DogVO dog = new DogVO(name, breed, birthDate, gender, neutrification, userId);
		int dogId = new DogRegistrationServiceImpl().dogRegister(dog);
		if(dogId == -1)
			return url;
		DogInfoVO dogInfo = new DogInfoVO(weight, exerciseTime, note, uploadTime, dogId);
		Collection<SupplyVO> supplies = new ArrayList<SupplyVO>();
		for(int i = 0; categories != null && i < categories.length; i++)
			supplies.add(new SupplyVO(categories[i], names[i]));
		if(new DogInformationServiceImpl().addDogHealthReport(dogInfo, supplies))
			url = "static/json/historyBack.jsp";
		return url;
	}

}
