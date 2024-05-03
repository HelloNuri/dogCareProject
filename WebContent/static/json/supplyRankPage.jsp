<%@page import="com.google.gson.Gson"%>
<%@page import="com.kosta.dogCare.model.DogInformationDAOImpl"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Collection<Map<String, String>> rank = new DogInformationDAOImpl().getSupplyStatistic("골든 리트리버", 1, 15, "사료");
	Gson gson = new Gson();
%>
<%=gson.toJson(rank) %>