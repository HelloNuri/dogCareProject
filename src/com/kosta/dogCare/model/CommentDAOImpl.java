package com.kosta.dogCare.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.kosta.dogCare.model.VO.CommentVO;

public class CommentDAOImpl implements CommentDAO {
	DataSource dataSource;
	
	public CommentDAOImpl() throws ClassNotFoundException, SQLException {
		try {
			Context context = new InitialContext();
			dataSource =
					(DataSource) context.lookup("java:comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addComment(CommentVO comment) {
		String sql = "Insert into comments (comment_id, comment_content, upload_time, album_id, user_id) values(comment_id_seq.nextval, ?,sysdate, ?, ?)";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getParentId());
			pstmt.setString(3, comment.getUserId());
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean editComment(CommentVO comment) {
		String sql = "update comments set comment_content=? where comment_id = ? and user_id = ?";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCommentId());
			pstmt.setString(3, comment.getUserId());
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addRecomment(CommentVO recomment) {
		String sql = "Insert into recomments (recomment_id, recomment_content, upload_time, comment_id, user_id) values(recomment_id_seq.nextval, ?,sysdate, ?, ?)";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, recomment.getContent());
			pstmt.setInt(2, recomment.getParentId());
			pstmt.setString(3, recomment.getUserId());
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean editRecomment(CommentVO recomment) {
		String sql = "update recomments set recomment_content=? where recomment_id = ? and user_id = ?";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, recomment.getContent());
			pstmt.setInt(2, recomment.getCommentId());
			pstmt.setString(3, recomment.getUserId());
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteComment(int commentId, String userId) {
		String sql = "delete from comments where comment_Id = ? and user_id = ?";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, commentId);
			pstmt.setString(2, userId);
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteRecomment(int recommentId, String userId) {
		String sql = "delete from recomments where recomment_Id = ? and user_id = ?";
		boolean result = false;
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recommentId);
			pstmt.setString(2, userId);
			int rs = pstmt.executeUpdate();
			if(rs == 1)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<CommentVO, Collection<CommentVO>> getCommentsByAlbumId(int albumId) {
		String sql = "select comment_id, comment_content, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from comments where album_id = ? order by upload_time";
		Map<CommentVO, Collection<CommentVO>> result = new HashMap<>();
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, albumId);
			try(ResultSet rs = pstmt.executeQuery();){
				CommentVO comment;
				while(rs.next()) {
					comment = new CommentVO(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), albumId, rs.getString(4));
					result.put(comment, getRecommentsByCommentId(comment.getCommentId()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Collection<CommentVO> getRecommentsByCommentId(int commentId){
		String sql = "select recomment_id, recomment_content, to_char(upload_time, 'YYYY-MM-DD HH24:MI:SS'), user_id from recomments where comment_id = ? order by upload_time";
		Collection<CommentVO> result = new ArrayList<CommentVO>();
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, commentId);
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) 
					result.add(new CommentVO(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), commentId, rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
