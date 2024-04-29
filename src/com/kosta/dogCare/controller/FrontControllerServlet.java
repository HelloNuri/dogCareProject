package com.kosta.dogCare.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dogCare.controller.action.Action;
import com.kosta.dogCare.model.UserDAO;
import com.kosta.dogCare.model.UserDAOImpl;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //Filter
		response.setHeader("Cache-Control", "no-cache"); 
		response.setHeader("Pragma", "no-cache"); 
		response.setDateHeader("Expires", 0);
		
		ActionFactroy factory = new ActionFactroy();
		String cmd = request.getParameter("cmd");
		
		UserDAO dao = new UserDAOImpl();
		System.out.println(dao.getNicknameByUserId("1"));
		
		Action action = factory.getAction(cmd);
		String url = action.execute(request);
		request.getRequestDispatcher(url).forward(request, response);
	}
}