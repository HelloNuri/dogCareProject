package dogCare.db.dao;

import java.sql.SQLException;

import dogCare.db.VO.UserVO;

public interface UserDAO {

    //user CR
    boolean addUser(UserVO user) throws SQLException;
    UserVO getUser(String userId);

    //성능향상용 부분 쿼리
    String getNicknameByUserId(String userId);
    String getUserIdByEmail(String email);
    String getPasswordbyUserId(String userId);
    
    boolean setPassword(String userId, String pw);

	boolean isIdDuplicated(String userId);
    




    

}
