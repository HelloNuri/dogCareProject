package com.kosta.dogCare.Service;

import java.sql.SQLException;

import com.kosta.dogCare.model.UserDAO;
import com.kosta.dogCare.model.UserDAOImpl;
import com.kosta.dogCare.model.VO.UserVO;

//회원가입, 로그인처럼 회원정보를 작성/수정/사용하는 클래스
public class RegistrationServiceImpl implements RegistrationService {
	private UserDAO userDao;
	
	public RegistrationServiceImpl() throws ClassNotFoundException, SQLException {
		userDao = new UserDAOImpl();
	}
	
	@Override
	public boolean login(String userId, String pw) {
		if(userDao.getPasswordbyUserId(userId) == null)
			return false;
		return userDao.getPasswordbyUserId(userId).equals(pw) ? true : false;
	}

	@Override
	public boolean logout() {
		return true;
	}

	@Override
	public boolean resetPassword(String userId, String name, String email) {
		boolean result = false;
		UserVO user = userDao.getUser(userId);
		if(user.getName().equals(name) && user.getEmailAddress().equals(email))
			result = userDao.setPassword(userId, "0000");
		return result;
	}

	@Override
	public boolean register(UserVO user, String confirmPw) {
		boolean result = false;
		if(!userDao.isIdDuplicated(user.getUserId()) && user.getPassword().equals(confirmPw))
			result = userDao.addUser(user);
		return result;
	}

	@Override
	public String getNicknameById(String userId) {
		return userDao.getNicknameByUserId(userId);
	}

	@Override
	public String getUserIdByEmail(String email) {
		return userDao.getUserIdByEmail(email);
	}

}
