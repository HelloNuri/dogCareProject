package dogCare.service;

import java.sql.SQLException;

import dogCare.db.VO.UserVO;

//회원가입, 로그인처럼 회원정보를 작성/수정/사용하는 클래스
public interface RegistrationService {
	boolean login(String userId, String pw) throws SQLException;
	boolean logout();
	boolean resetPassword(String userId, String name, String email);

	boolean register(UserVO user, String confirmPw);
	

    
    //성능향상용 부분 쿼리
    String getNicknameById(String userId);
    public String getUserIdByEmail(String email);
}
