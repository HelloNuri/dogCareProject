package dogCare.service;

import java.util.Collection;

import dogCare.db.DTO.DogAddDTO;
import dogCare.db.VO.DogVO;

public interface DogRegistrationService {
	int dogRegister(DogAddDTO dog);
	DogVO getDog(int dogId);
	public Collection<DogVO> getDogsByUserId(String userId);
}
