package com.kosta.dogCare.model;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.CommentVO;

public interface CommentDAO {

	//Comment CUD
    public boolean addComment(CommentVO comment);
    public boolean editComment(CommentVO comment);
    public boolean deleteComment(int commentId, String userId);
    
    //Recomment CUD
    public boolean addRecomment(CommentVO recomment);
    public boolean editRecomment(CommentVO recomment);
    public boolean deleteRecomment(int recommentId, String userId);
    
    //Co&Recomment R
    public Map<CommentVO, Collection<CommentVO>> getCommentsByAlbumId(int albumId);

}
