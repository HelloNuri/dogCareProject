<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="com.kosta.dogCare.Service.DogInformationServiceImpl"%>
<%@page import="com.kosta.dogCare.Service.DogInformationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int dogId = Integer.parseInt(request.getParameter("dogId"));
	DogInformationService infoService = new DogInformationServiceImpl();
	Map<Integer, Collection<Double>> exerciseChart = infoService.getExerciseGraphByDogId(dogId);
		%>
만나서 반갑다. 나는 운동량 그래프라고 한다.
<%= exerciseChart.toString() %>