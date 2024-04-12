package dogCare.service;

import java.sql.SQLException;
import java.util.Collection;

import dogCare.db.DTO.DogAddDTO;
import dogCare.db.VO.DogVO;
import dogCare.db.dao.DogDAO;
import dogCare.db.dao.DogDAOImpl;

public class DogRegistrationServiceImpl implements DogRegistrationService{
	private DogDAO dogDao;
	public DogRegistrationServiceImpl() throws ClassNotFoundException, SQLException{
		dogDao = new DogDAOImpl();
	}
	
	@Override
	public int dogRegister(DogAddDTO dog) {
		return dogDao.addDog(dog);
	}

	@Override
	public Collection<DogVO> getDogsByUserId(String userId) {
		return dogDao.getDogsByUserId(userId);
	}

	@Override
	public DogVO getDog(int dogId) {
		return dogDao.getDog(dogId);
	}

}
