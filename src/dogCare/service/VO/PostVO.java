package dogCare.service.VO;

import java.util.Collection;
import java.util.Map;

import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.CommentVO;
import dogCare.db.VO.ImageVO;

public class PostVO {
	private AlbumVO albumVo;
	private Collection<ImageVO> images;
	private Map<CommentVO, Collection<CommentVO>> comments;
	
	
	public PostVO(AlbumVO albumVo, Collection<ImageVO> images, Map<CommentVO, Collection<CommentVO>> comments) {
		super();
		this.albumVo = albumVo;
		this.images = images;
		this.comments = comments;
	}
	public AlbumVO getAlbumVo() {
		return albumVo;
	}
	public void setAlbumVo(AlbumVO albumVo) {
		this.albumVo = albumVo;
	}
	public Collection<ImageVO> getImages() {
		return images;
	}
	public void setImages(Collection<ImageVO> images) {
		this.images = images;
	}
	public Map<CommentVO, Collection<CommentVO>> getComments() {
		return comments;
	}
	public void setComments(Map<CommentVO, Collection<CommentVO>> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "PostVO [albumVo=" + albumVo + ", images=" + images + ", comments=" + comments + "]";
	}
}
