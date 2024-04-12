package dogCare.db.dao;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import dogCare.db.DTO.AlbumAddDTO;
import dogCare.db.DTO.ImageAddDTO;
import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.ImageVO;

public interface AlbumDAO {

	//album CRUD
    public int addAlbum(AlbumAddDTO albumDTO) throws SQLException;
    public AlbumVO getAlbum(int albumId);
    public boolean editAlbum(AlbumVO album);
    public boolean deleteAlbum(int albumId, String userId);

    //Images CRD
    public boolean addImages(int albumId, Collection<ImageAddDTO> images) throws SQLException;
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
