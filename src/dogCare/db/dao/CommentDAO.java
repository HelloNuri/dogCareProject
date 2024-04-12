package dogCare.db.dao;
import java.util.Collection;
import java.util.Map;

import dogCare.db.DTO.CommentAddDTO;
import dogCare.db.VO.CommentVO;

public interface CommentDAO {

	//Comment CUD
    public boolean addComment(CommentAddDTO comment);
    public boolean editComment(CommentVO comment);
    public boolean deleteComment(int commentId, String userId);
    
    //Recomment CUD
    public boolean addRecomment(CommentAddDTO recomment);
    public boolean editRecomment(CommentVO recomment);
    public boolean deleteRecomment(int recommentId, String userId);
    
    //Co&Recomment R
    public Map<CommentVO, Collection<CommentVO>> getCommentsByAlbumId(int albumId);

}
