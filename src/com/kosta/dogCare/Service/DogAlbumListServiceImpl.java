package com.kosta.dogCare.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.AlbumDAO;
import com.kosta.dogCare.model.AlbumDAOImpl;
import com.kosta.dogCare.model.VO.AlbumVO;
import com.kosta.dogCare.model.VO.ImageVO;

public class DogAlbumListServiceImpl implements DogAlbumListService {
	private AlbumDAO albumDao;
	public DogAlbumListServiceImpl() throws ClassNotFoundException, SQLException {
		albumDao = new AlbumDAOImpl();
	}
	
	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByTitle(String title, int numberInScreen) {
		return albumDao.getAlbumListByTitle(title, numberInScreen);
	}

	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByNickname(String nickname, int numberInScreen) {
		return albumDao.getAlbumListByNickname(nickname, numberInScreen);
	}

	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByDogs(Collection<Integer> dogIds, int numberInScreen) {
		// TODO Auto-generated method stub
		return albumDao.getAlbumListByDogs(dogIds, numberInScreen);
	}

	@Override
	public Map<AlbumVO, ImageVO> getAlbumListByUserId(String userId, int numberInScreen) {
		return albumDao.getAlbumListByUserId(userId, numberInScreen);
	}

}
