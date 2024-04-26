package com.kosta.dogCare.model;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kosta.dogCare.model.VO.AlbumVO;
import com.kosta.dogCare.model.VO.ImageVO;
@SuppressWarnings("unused")
public class AlbumDAOImpl implements AlbumDAO {

	private Connection conn; 
	
	public AlbumDAOImpl() throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		conn = DriverManager.getConnection(url, "hr", "hr");
		conn = ConnectionManager.getConnection();
	}	
	
	@Override
	public int addAlbum(AlbumVO album) throws SQLException {
		String sql = "insert into Albums (album_id, title, content, upload_time, user_id) values (?, ?, ?, sysdate, ?)";
		int albumId = -1;
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("select album_id_seq.nextval from dual");
		if(rs.next())
			albumId = rs.getInt(1);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, albumId);
		pstmt.setString(2, album.getTitle());
		pstmt.setString(3, album.getContent());
		pstmt.setString(4, album.getUserId());
		if(pstmt.executeUpdate() != 1)
			throw new SQLException();

		stmt.close();
		rs.close();
		pstmt.close();

		return albumId;
	}

	@Override
	public boolean addDogTags(int albumId, Collection<Integer> dogIds) throws SQLException {
		String sql = "insert into dog_Album_tags (album_id, dog_id) values (?, ?)";
		boolean result = false;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int dogId: dogIds) {
			pstmt.setInt(1, albumId);
			pstmt.setInt(2, dogId);
			pstmt.addBatch();
			pstmt.clearParameters();
		}
		if (pstmt.executeBatch().length == dogIds.size())
			result = true;
		pstmt.clearBatch();
		pstmt.close();
		return result;
	}
	
	@Override
	public boolean addImages(int albumId, Collection<ImageVO> images) throws SQLException {
		String sql = "insert into Images (name, album_id) values (?, ?)";
		boolean result = false;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (ImageVO image: images) {
			pstmt.setString(1, image.getName());
			pstmt.setInt(2, albumId);
			pstmt.addBatch();
			pstmt.clearParameters();
		}
		if (pstmt.executeBatch().length == images.size())
			result = true;
		pstmt.clearBatch();
		pstmt.close();
		return result;
	}
	
	@Override
	public boolean editAlbum(AlbumVO album) {
		 String sql = "update Albums set title=?, content = ? where album_id = ? and user_id = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, album.getTitle());
			pstmt.setString(2, album.getContent());
			pstmt.setInt(3, album.getAlbumId());
			pstmt.setString(4, album.getUserId());
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteDogTags(int albumId) {
		String sql = "delete from dog_album_tags where album_id = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteImages(int albumId) {
		String sql = "delete from images where album_id = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			int rs = pstmt.executeUpdate();
			if(rs >= 0)
				result = true;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteAlbum(int albumId, String userId) {
		String sql = "delete from Albums where album_id = ? and user_id = ?";
		boolean result = false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			pstmt.setString(2, userId);
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public AlbumVO getAlbum(int albumId) {
		String sql = "Select title, content, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from Albums where album_Id = ?";
		AlbumVO result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = new AlbumVO(albumId, rs.getString(1), rs.getString(2), rs.getTimestamp(3), rs.getString(4)); 				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public Collection<ImageVO> getImages(int albumId){
		String sql = "Select name from Images where album_Id = ?";
		Collection<ImageVO> result = new ArrayList<ImageVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				result.add(new ImageVO(rs.getString(1), albumId)); 				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result ;
	}

	@Override
	public Collection<Integer> getDogTags(int albumId) {
		String sql = "Select dog_id from dog_album_tags where album_Id = ?";
		Collection<Integer> result = new ArrayList<Integer>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				result.add(rs.getInt(1)); 				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByUserId(String userId, int numberInScreen) {
		Map<AlbumVO, ImageVO> result = new HashMap<>();
		String sql = "Select album_id,title, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from albums where user_Id = ? and rownum <= ? order by upload_time desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, numberInScreen);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int i = 1;
				AlbumVO aVO = new AlbumVO(rs.getInt(i++), rs.getString(i++), null, rs.getTimestamp(i++), rs.getString(i++));
				result.put(aVO, getThumnailByAlbumId(aVO.getAlbumId()));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByTitle(String title, int numberInScreen) {
		Map<AlbumVO, ImageVO> result = new HashMap<>();
		String sql = "Select album_id,title, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from albums where title like ? and rownum <= ? order by upload_time desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			pstmt.setInt(2, numberInScreen);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int i = 1;
				AlbumVO aVO = new AlbumVO(rs.getInt(i++), rs.getString(i++), null, rs.getTimestamp(i++), rs.getString(i++));
				result.put(aVO, getThumnailByAlbumId(aVO.getAlbumId()));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ImageVO getThumnailByAlbumId(int albumId) {
		String sql = "Select name from Images where album_Id = ? and rownum = 1";
		ImageVO result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = new ImageVO(rs.getString(1), albumId); 				
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByNickname(String nickname, int numberInScreen) {
		Map<AlbumVO, ImageVO> result = new HashMap<>();
		String sql = "Select a.album_id, a.title, to_char(a.upload_time, 'YYYY-MM-DD HH24:MI:SS'), a.user_id from albums a, users u where a.user_id = u.user_id and u.nickname = ? and rownum <= ? order by a.upload_time desc";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setInt(2, numberInScreen);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int i = 1;
				AlbumVO aVO = new AlbumVO(rs.getInt(i++), rs.getString(i++), null, rs.getTimestamp(i++), rs.getString(i++));
				result.put(aVO, getThumnailByAlbumId(aVO.getAlbumId()));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByDogs(Collection<Integer> dogIds, int numberInScreen) {
		Map<AlbumVO, ImageVO> result = new HashMap<>();
		String inTemplate = createInTemplate(dogIds.size()); 
		String sql = "select album_id, title, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from albums where album_id in (Select distinct a.album_id from albums a, dog_album_tags d where a.album_id = d.album_id and d.dog_id in ("+ inTemplate +") and rownum <= ?) order by upload_time";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int setIndex = 1;
			for (int dogId : dogIds) {
				pstmt.setInt(setIndex++, dogId);
			}
			pstmt.setInt(setIndex++, numberInScreen);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int getIndex = 1;
				AlbumVO aVO = new AlbumVO(rs.getInt(getIndex++), rs.getString(getIndex++), null, rs.getTimestamp(getIndex++), rs.getString(getIndex++));
				result.put(aVO, getThumnailByAlbumId(aVO.getAlbumId()));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private String createInTemplate(int size) {
		String result = "?";
		if(size == 0)
			return "";
		for (int i = 1; i < size; i++) {
			result += ",?";
		}
		return result;
	}
	

}
