package com.kosta.dogCare.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.DogInformationService;
import com.kosta.dogCare.Service.DogInformationServiceImpl;
import com.kosta.dogCare.controller.action.Action;

public class ExerciseChart implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
//		int dogId = Integer.parseInt(request.getParameter("dogId"));
//		DogInformationService infoService = new DogInformationServiceImpl();
//		Map<Integer, Collection<Double>> weightData = infoService.getHealthGraphByDogId(dogId);
//		request.setAttribute("data", weightData);
		return "static/json/exerciseChartData.jsp";
	}

}
