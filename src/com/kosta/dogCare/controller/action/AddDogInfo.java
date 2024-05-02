package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.Service.DogInformationServiceImpl;
import com.kosta.dogCare.Service.DogRegistrationServiceImpl;
import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;

public class AddDogInfo implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
 		String url = "controller?cmd=addDogInfoUI";
 		int dogId = Integer.parseInt(request.getParameter("dogId"));
 		double weight = Double.parseDouble(request.getParameter("dogWeight"));
 		double exerciseTime = Double.parseDouble(request.getParameter("dogExerciseTime"));
 		String note = request.getParameter("dogNote");
 		String [] supplyCategories = request.getParameterValues("supplyCategory");
 		String [] supplyName = request.getParameterValues("supplyName");
 		Timestamp uploadTime = Timestamp.valueOf(request.getParameter("datetime-local") + " 00:00:00");
 		
 		DogInfoVO dogInfo = new DogInfoVO(weight, exerciseTime, note, uploadTime, dogId);
 		Collection<SupplyVO> supplies = new ArrayList<>();
 		for(int i = 0; supplyCategories != null && i < supplyCategories.length; i++){
 			supplies.add(new SupplyVO(supplyCategories[i], supplyName[i]));
 		}
 		
 		if(new DogInformationServiceImpl().addDogHealthReport(dogInfo, supplies))
 			url = "controller?cmd=mainUI";
		return url;
	}

}
