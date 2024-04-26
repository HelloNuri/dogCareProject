package com.kosta.dogCare.model;
import java.util.Collection;

import com.kosta.dogCare.model.VO.DogVO;

public interface DogDAO {
    public int addDog(DogVO dog);
    DogVO getDog(int dogId);
    public Collection<DogVO> getDogsByUserId(String userId);

	String getBreedByDogId(int dogId);
    
    
}
