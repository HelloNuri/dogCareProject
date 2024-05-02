package com.kosta.dogCare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.kosta.dogCare.controller.action.Action;

public class WeightChart implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "static/json/weightChartData.jsp";
	}

}
