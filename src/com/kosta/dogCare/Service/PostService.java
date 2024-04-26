package com.kosta.dogCare.Service;

import java.sql.SQLException;
import java.util.Collection;

import com.kosta.dogCare.Service.VO.PostVO;
import com.kosta.dogCare.model.VO.AlbumVO;
import com.kosta.dogCare.model.VO.CommentVO;
import com.kosta.dogCare.model.VO.ImageVO;

//포스트 상세보기 UI를 구현하는 클래스. 포스트에는 강아지_태그, 앨범 내용, 첨부이미지, 댓글창이 포함된다.
public interface PostService {
	PostVO getPostById(int albumId) throws ClassNotFoundException, SQLException;
	
	boolean writePost(AlbumVO album, Collection<ImageVO> images, Collection<Integer> dogTags) throws ClassNotFoundException, SQLException;
	
	boolean deletePost(int postId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean deleteComment(int commentId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean deleteRecomment(int recommentId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean writeComment(CommentVO commentDTO) throws ClassNotFoundException, SQLException;
	
	boolean writeRecomment(CommentVO commentDTO) throws ClassNotFoundException, SQLException;

	boolean editPost(AlbumVO album, Collection<ImageVO> images, Collection<Integer> dogTags) throws SQLException;

	boolean editComment(CommentVO comment) throws SQLException;

	boolean editRecomment(CommentVO recomment) throws SQLException;
}
