package com.kosta.dogCare.model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.AlbumVO;
import com.kosta.dogCare.model.VO.ImageVO;

public interface AlbumDAO {

	//album CRUD
    public int addAlbum(AlbumVO album) throws SQLException;
    public AlbumVO getAlbum(int albumId);
    public boolean editAlbum(AlbumVO album);
    public boolean deleteAlbum(int albumId, String userId);

    //Images CRD
    public boolean addImages(int albumId, Collection<ImageVO> images) throws SQLException;
    public Collection<ImageVO> getImages(int albumId);
    public boolean deleteImages(int albumId);
    
    //DogTags CRD
    public boolean addDogTags(int albumId, Collection<Integer> dogTags) throws SQLException;
    public Collection<Integer> getDogTags(int albumId);
    public boolean deleteDogTags(int albumId);
    

	
	
	//Album List
	public Map<AlbumVO, ImageVO> getAlbumListByTitle(String title, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByNickname(String nickname, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByDogs(Collection<Integer> dogIds, int numberInScreen);
	Map<AlbumVO, ImageVO> getAlbumListByUserId(String userId, int numberInScreen);
    
}
