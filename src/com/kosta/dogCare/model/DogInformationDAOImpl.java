package com.kosta.dogCare.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;


public class DogInformationDAOImpl implements DogInformationDAO{
	DataSource dataSource;
	
	public DogInformationDAOImpl(){
		try {
			Context context = new InitialContext();
			dataSource =
					(DataSource) context.lookup("java:comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public int addDogInfo(DogInfoVO dogInfo){
		String sql = "insert into dog_Informations (information_id, weight, exercise_time, note, upload_time, dog_id) values (?, ?, ?, ?, ?, ?)";
		int infoId = -1;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Statement stmt = conn.createStatement();
				ResultSet rs =stmt.executeQuery("select information_id_seq.nextval from dual");) {
			if(rs.next())
				infoId = rs.getInt(1);
			
			pstmt.setInt(1, infoId);
			pstmt.setDouble(2, dogInfo.getWeight());
			pstmt.setDouble(3, dogInfo.getExerciseTime());
			pstmt.setString(4, dogInfo.getNote());
			pstmt.setTimestamp(5, dogInfo.getUploadTime());
			pstmt.setDouble(6, dogInfo.getDogId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return infoId;
	}
	
	public DogInfoVO getDogInfo(int dogInfoId) {
		String sql = "Select weight, exercise_time, note, upload_time, dog_id from dog_informations where dog_information_id = ?";
		DogInfoVO result = null;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, dogInfoId);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()){
					result = new DogInfoVO(dogInfoId, rs.getDouble(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	void getDogInfoTest() {
		
	}

	@Override
	public Collection<DogInfoVO> getDogInfos(int dogId) {
		String sql = "Select information_id, weight, exercise_time, note, upload_time from dog_informations where dog_id = ?";
		Collection<DogInfoVO> result = new ArrayList<DogInfoVO>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, dogId);
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()){
					result.add(new DogInfoVO(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4), rs.getTimestamp(5), dogId));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean addDogSupplies(int infoId, Collection<SupplyVO> supplies){
		String sql = "insert into supplies (supply_id, category, name, information_id) values (supply_id_seq.nextval, ?, ?, ?)";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			for (SupplyVO supply: supplies) {
				pstmt.setString(1, supply.getCategory());
				pstmt.setString(2, supply.getName());
				pstmt.setInt(3, infoId);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			if (pstmt.executeBatch().length == supplies.size())
				result = true;
			pstmt.clearBatch();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Collection<SupplyVO> getSupplies(int infoId) {
		String sql = "Select supply_id, category, name from supplies where information_id = ?";
		Collection<SupplyVO> result = new ArrayList<SupplyVO>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, infoId);
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()){
					result.add(new SupplyVO(rs.getInt(1), rs.getString(2), rs.getString(3), infoId));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Map<Integer, Double> getHealthDataByDogId(int dogId) {
		String sql = "select trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) \"생후개월\",round(avg(weight),2) \"평균체중\" "
				+ "from dog_informations di "
				+ "inner join dogs d "
				+ "on d.dog_id = di.dog_id "
				+ "where d.dog_id = ? "
				+ "and trunc((sysdate-TRUNC(upload_time, 'MM'))/30) <= trunc((sysdate-d.birth_date) / 30) "
				+ "group by trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) "
				+ "order by trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) ";
		Map<Integer, Double> result = new HashMap<Integer, Double>();
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			//데이터 유효성 검사는 UI에서 한다고 가정한다.
			pstmt.setInt(1, dogId);
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
					result.put(rs.getInt(1), rs.getDouble(2));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Map<Integer, Double> getHealthDataByBreed(String breed) {
		String sql = "select trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) \"생후개월\",round(avg(weight),2) \"평균체중\" "
				+ "from dog_informations di "
				+ "inner join dogs d "
				+ "on d.dog_id = di.dog_id "
				+ "where d.breed = ? "
				+ "and trunc((sysdate-TRUNC(upload_time, 'MM'))/30) <= trunc((sysdate-d.birth_date) / 30) "
				+ "group by trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) "
				+ "order by trunc((sysdate-TRUNC(di.upload_time, 'MM'))/30) ";
		Map<Integer, Double> result = new HashMap<Integer, Double>();
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			//데이터 유효성 검사는 UI에서 한다고 가정한다.
			pstmt.setString(1, breed);
			try(ResultSet rs = pstmt.executeQuery();){
				while (rs.next()) {
					result.put(rs.getInt(1), rs.getDouble(2));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category){
		String sql = "select name, trunc(count(name)/(select count(name) total from \r\n"
				+ "(\r\n"
				+ "  select s.name, trunc((to_Date('2025-01-01', 'YYYY-MM-DD')-trunc(d.BIRTH_DATE, 'MM'))/30) \"age\"\r\n"
				+ "  from dogs d, dog_informations i, supplies s \r\n"
				+ "  where d.dog_id = i.dog_id \r\n"
				+ "    and i.information_id = s.information_id \r\n"
				+ "    and d.breed = ? \r\n"
				+ "    and s.category = ?\r\n"
				+ "    and trunc((to_Date('2025-01-01', 'YYYY-MM-DD')-trunc(d.BIRTH_DATE, 'MM'))/30) Between ? and ?\r\n"
				+ ")),3)*100 \"수\" from \r\n"
				+ "(\r\n"
				+ "  select s.name, trunc((to_Date('2025-01-01', 'YYYY-MM-DD')-trunc(d.BIRTH_DATE, 'MM'))/30) \"age\"\r\n"
				+ "  from dogs d, dog_informations i, supplies s \r\n"
				+ "  where d.dog_id = i.dog_id \r\n"
				+ "    and i.information_id = s.information_id \r\n"
				+ "    and d.breed = ? \r\n"
				+ "    and s.category = ?\r\n"
				+ "    and trunc((to_Date('2025-01-01', 'YYYY-MM-DD')-trunc(d.BIRTH_DATE, 'MM'))/30) Between ? and ?\r\n"
				+ ")\r\n"
				+ "group by name\r\n"
				+ "order by \"수\" desc";
		Collection<Map<String, Double>> rankPage = new ArrayList<>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, breed);
			pstmt.setString(2, category);
			pstmt.setInt(3, startAge);
			pstmt.setInt(4, endAge);
			pstmt.setString(5, breed);
			pstmt.setString(6, category);
			pstmt.setInt(7, startAge);
			pstmt.setInt(8, endAge);
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
//			rankPage.add(Map.of(rs.getString(1), rs.getDouble(2)));
					break;//Todo
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rankPage;
	}

}
