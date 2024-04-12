package dogCare.db.dao;
import java.util.Collection;

import dogCare.db.DTO.DogAddDTO;
import dogCare.db.VO.DogVO;

public interface DogDAO {
    public int addDog(DogAddDTO dog);
    DogVO getDog(int dogId);
    public Collection<DogVO> getDogsByUserId(String userId);

	String getBreedByDogId(int dogId);
    
    
}
