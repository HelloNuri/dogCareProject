package com.kosta.dogCare.Service;

import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.AlbumVO;
import com.kosta.dogCare.model.VO.ImageVO;

public interface DogAlbumListService {
	public Map<AlbumVO, ImageVO> getAlbumListByTitle(String title, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByNickname(String nickname, int numberInScreen);

    public Map<AlbumVO, ImageVO> getAlbumListByDogs(Collection<Integer> dogIds, int numberInScreen);
    Map<AlbumVO, ImageVO> getAlbumListByUserId(String userId, int numberInScreen);
}
