<%@page import="com.kosta.dogCare.Service.DogInformationServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.google.gson.JsonObject"%>
<%  int dogId = Integer.parseInt(request.getParameter("dogId")); 
	JsonObject result = new JsonObject();
	result.addProperty("weight", new DogInformationServiceImpl().getDogRecentWeight(dogId));
	%>
<%= result.toString()%>