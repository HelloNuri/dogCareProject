<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.google.gson.JsonObject"%>
<% 
	String userId = request.getParameter("userId");
	String email= request.getParameter("id-email");
%>
<c:if test="${userId == null}">
	
</c:if>
		 
		${email} 회원님의 아이디는 ${userId}입니다.
