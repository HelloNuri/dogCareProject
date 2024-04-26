package com.kosta.dogCare.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.kosta.dogCare.model.VO.DogVO;

public class DogDAOImpl implements DogDAO{
	private Connection conn; 
	
	public DogDAOImpl() throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		conn = DriverManager.getConnection(url, "hr", "hr");
		conn = ConnectionManager.getConnection();
	}
	
	@Override
	public int addDog(DogVO dog) {
		String sql = "insert into dogs (dog_id, name, breed, birth_date, gender, neutrification, user_id) values (?, ?, ?, ?, ?, ?, ?)";
		int dogId = -1;
		try {
			//데이터 유효성 검사는 UI에서 한다고 가정한다.
			Statement stmt = conn.createStatement();
			ResultSet rs =stmt.executeQuery("select dog_id_seq.nextval from dual");
			if(rs.next())
				dogId = rs.getInt(1);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int i = 1;
			pstmt.setInt(i++, dogId);
			pstmt.setString(i++, dog.getName());
			pstmt.setString(i++, dog.getBreed());
			pstmt.setString(i++, dog.getBrithDate().toString());
			pstmt.setString(i++, "" + dog.getGender());
			pstmt.setString(i++, "" + dog.getNeutrification());
			pstmt.setString(i++, dog.getUserId());
			pstmt.executeUpdate();
			pstmt.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dogId;
	}

	@Override
	public Collection<DogVO> getDogsByUserId(String userId) {
		String sql = "select dog_id, name, breed, birth_date, gender, neutrification from dogs where user_id = ?";
		Collection<DogVO> result = new ArrayList<DogVO>();
		try {
			//데이터 유효성 검사는 UI에서 한다고 가정한다.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result.add(new DogVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5).charAt(0), rs.getString(6).charAt(0), userId));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String getBreedByDogId(int dogId) {
		String sql = "select breed from dogs where dog_id = ?";
		String breed = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dogId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				breed = rs.getString(1);
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return breed;
	}

	@Override
	public DogVO getDog(int dogId) {
		String sql = "select name, breed, birth_date, gender, neutrification, user_id from dogs where dog_id = ?";
		DogVO dog = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dogId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				dog = new DogVO(dogId, rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4).charAt(0), rs.getString(5).charAt(0), rs.getString(6));
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dog;
	}
}
