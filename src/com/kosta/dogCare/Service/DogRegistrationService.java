package com.kosta.dogCare.Service;

import java.util.Collection;

import com.kosta.dogCare.model.VO.DogVO;

public interface DogRegistrationService {
	int dogRegister(DogVO dog);
	DogVO getDog(int dogId);
	public Collection<DogVO> getDogsByUserId(String userId);
}
