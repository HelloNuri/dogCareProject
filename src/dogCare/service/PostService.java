package dogCare.service;

import java.sql.SQLException;
import java.util.Collection;

import dogCare.db.DTO.AlbumAddDTO;
import dogCare.db.DTO.CommentAddDTO;
import dogCare.db.DTO.ImageAddDTO;
import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.CommentVO;
import dogCare.service.VO.PostVO;

//포스트 상세보기 UI를 구현하는 클래스. 포스트에는 강아지_태그, 앨범 내용, 첨부이미지, 댓글창이 포함된다.
public interface PostService {
	PostVO getPostById(int albumId) throws ClassNotFoundException, SQLException;
	
	boolean writePost(AlbumAddDTO albumDTO, Collection<ImageAddDTO> images, Collection<Integer> dogTags) throws ClassNotFoundException, SQLException;
	
	boolean deletePost(int postId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean deleteComment(int commentId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean deleteRecomment(int recommentId, String userId) throws ClassNotFoundException, SQLException;
	
	boolean writeComment(CommentAddDTO commentDTO) throws ClassNotFoundException, SQLException;
	
	boolean writeRecomment(CommentAddDTO commentDTO) throws ClassNotFoundException, SQLException;

	boolean editPost(AlbumVO album, Collection<ImageAddDTO> images, Collection<Integer> dogTags) throws SQLException;

	boolean editComment(CommentVO comment) throws SQLException;

	boolean editRecomment(CommentVO recomment) throws SQLException;
}
