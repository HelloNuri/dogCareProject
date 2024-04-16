package dogCare.db.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dogCare.db.VO.UserVO;

public class UserDAOImpl implements UserDAO {
	private Connection conn; 
	
	public UserDAOImpl() throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		conn = DriverManager.getConnection(url, "hr", "hr");
		conn = ConnectionManager.getConnection();
	}	

	@Override
	public boolean isIdDuplicated(String userId) {
		boolean result = false;
		String sql = "select user_id from users where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	@Override
	public boolean addUser(UserVO user) throws SQLException {
		String sql = "Insert Into users (user_id, name, nickname, password, email_address) values(?, ?, ?, ?, ?)";
		boolean result = false;
		//비밀번호 유효성 검사/비밀번호 확인/닉네임 중복 확인/아이디 중복 확인은 UI에서 한다고 가정한다.
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getNickname());
		pstmt.setString(4, user.getPassword());
		pstmt.setString(5, user.getEmailAddress());
		int rs = pstmt.executeUpdate();
		if(rs == 1)
			result = true;
		pstmt.close();
		return result;
	}

	@Override
	public String getUserIdByEmail(String email) {
		String sql = "select user_id from users where email_address = ?";
		String result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result = rs.getString(1);
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UserVO getUser(String userId) {
		String sql = "Select nickname, name, password, email_address from users where user_Id = ?";
		UserVO result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = new UserVO(userId, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)); 				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getNicknameByUserId(String userId) {
		String sql = "Select nickname from users where user_Id = ?";
		String nickname = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				nickname = rs.getString(1);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nickname;
	}

	@Override
	public String getPasswordbyUserId(String userId) {
		String sql = "Select password from users where user_Id = ?";
		String password = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				password = rs.getString(1);
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}




	@Override
	public boolean setPassword(String userId, String pw) {
		String sql = "update users set password = ? where user_Id = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, userId);
			int rs = pstmt.executeUpdate();
			if(rs == 1){
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
