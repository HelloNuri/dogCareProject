package dogCare.service;

import java.util.Collection;
import java.util.Map;

import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.ImageVO;

public interface DogAlbumListService {
	public Map<AlbumVO, ImageVO> getAlbumListByTitle(String title, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByNickname(String nickname, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByDogs(Collection<Integer> dogIds, int numberInScreen);
    Map<AlbumVO, ImageVO> getAlbumListByUserId(String userId, int numberInScreen);
}
