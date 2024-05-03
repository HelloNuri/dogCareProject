package com.kosta.dogCare.controller.action;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.kosta.dogCare.model.DogInformationDAOImpl;

public class SupplyRankPage implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "static/json/supplyRankPage.jsp";
	}

}
