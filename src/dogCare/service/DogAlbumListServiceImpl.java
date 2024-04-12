package dogCare.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import dogCare.db.VO.AlbumVO;
import dogCare.db.VO.ImageVO;
import dogCare.db.dao.AlbumDAO;
import dogCare.db.dao.AlbumDAOImpl;

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
