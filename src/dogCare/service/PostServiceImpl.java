package dogCare.service;

import java.sql.SQLException;
import java.util.Collection;

import dogCare.db.dao.AlbumDAO;
import dogCare.db.dao.AlbumDAOImpl;
import dogCare.db.dao.CommentDAO;
import dogCare.db.dao.CommentDAOImpl;
import dogCare.db.DTO.AlbumAddDTO;
import dogCare.db.DTO.CommentAddDTO;
import dogCare.db.DTO.ImageAddDTO;
import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.CommentVO;
import dogCare.db.VO.ImageVO;
import dogCare.service.VO.PostVO;

//앨범 상세보기를 구현하는 클래스. 앨범에는 강아지_태그, 앨범 내용, 첨부이미지, 댓글창이 포함된다.
public class PostServiceImpl implements PostService{
	private AlbumDAO albumDao;
	private CommentDAO commentDao;

	public PostServiceImpl() throws ClassNotFoundException, SQLException {
		albumDao = new AlbumDAOImpl();
		commentDao = new CommentDAOImpl();
	}


	@Override
	public PostVO getPostById(int albumId) throws ClassNotFoundException, SQLException {
		PostVO post = null;
		post = new PostVO(albumDao.getAlbum(albumId), albumDao.getImages(albumId), commentDao.getCommentsByAlbumId(albumId));
		return post;
	}

	public Collection<ImageVO> getImagesByAlbumId(int albumId) throws ClassNotFoundException, SQLException{
		return albumDao.getImages(albumId);
	}

	@Override
	public boolean writePost(AlbumAddDTO albumDTO, Collection<ImageAddDTO> images, Collection<Integer> dogTags) throws ClassNotFoundException, SQLException {
		boolean result = true;
		int albumId = -1;
		albumId = albumDao.addAlbum(albumDTO);
		if(albumId == -1)
			return false;

		if(albumDao.addImages(albumId, images) == false)
			result = false;
		if(albumDao.addDogTags(albumId, dogTags) == false)
			result = false;
		return result;
	}

	@Override
	public boolean writeComment(CommentAddDTO commentDTO) throws ClassNotFoundException, SQLException{
		return commentDao.addComment(commentDTO);
	}

	@Override
	public boolean writeRecomment(CommentAddDTO commentDTO) throws ClassNotFoundException, SQLException{
		return commentDao.addRecomment(commentDTO);
	}

	@Override
	public boolean deletePost(int postId, String userId) throws ClassNotFoundException, SQLException {
		return albumDao.deleteAlbum(postId, userId);
	}

	@Override
	public boolean deleteComment(int commentId, String userId) throws ClassNotFoundException, SQLException {
		return commentDao.deleteComment(commentId, userId);
	}

	@Override
	public boolean deleteRecomment(int recommentId, String userId) throws ClassNotFoundException, SQLException {
		return commentDao.deleteRecomment(recommentId, userId);
	}

	@Override
	public boolean editPost(AlbumVO album, Collection<ImageAddDTO> images, Collection<Integer> dogTags) throws SQLException{
		albumDao.editAlbum(album);

		albumDao.deleteDogTags(album.getAlbumId());
		albumDao.deleteImages(album.getAlbumId());

		albumDao.addDogTags(album.getAlbumId(), dogTags);
		albumDao.addImages(album.getAlbumId(), images);
		return true;
	}

	@Override
	public boolean editComment(CommentVO comment) throws SQLException{
		return commentDao.editComment(comment);
	}

	@Override
	public boolean editRecomment(CommentVO recomment) throws SQLException{
		return commentDao.editRecomment(recomment);
	}
}
