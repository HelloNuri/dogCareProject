package com.kosta.dogCare.model;

import java.sql.SQLException;

import com.kosta.dogCare.model.VO.UserVO;

public interface UserDAO {

    //user CR
    boolean addUser(UserVO user);
    UserVO getUser(String userId);

    //성능향상용 부분 쿼리
    String getNicknameByUserId(String userId);
    String getUserIdByEmail(String email);
    String getPasswordbyUserId(String userId);
    
    boolean setPassword(String userId, String pw);

	boolean isIdDuplicated(String userId);
    




    

}
