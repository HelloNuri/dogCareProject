package com.kosta.dogCare.Service;

import java.sql.SQLException;
import java.util.Collection;

import com.kosta.dogCare.model.DogDAO;
import com.kosta.dogCare.model.DogDAOImpl;
import com.kosta.dogCare.model.VO.DogVO;

public class DogRegistrationServiceImpl implements DogRegistrationService{
	private DogDAO dogDao;
	public DogRegistrationServiceImpl() throws ClassNotFoundException, SQLException{
		dogDao = new DogDAOImpl();
	}
	
	@Override
	public int dogRegister(DogVO dog) {
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
