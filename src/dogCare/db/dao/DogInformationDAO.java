package dogCare.db.dao;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import dogCare.db.DTO.DogInfoAddDTO;
import dogCare.db.DTO.SupplyAddDTO;
import dogCare.db.VO.DogInfoVO;
import dogCare.db.VO.SupplyVO;

public interface DogInformationDAO {
	
	//DogInfo CRUD
    public int addDogInfo(int dogId, DogInfoAddDTO dogInfo) throws SQLException;
    public Collection<DogInfoVO> getDogInfos(int dogId);

    //Supplies CRUD
    public boolean addDogSupplies(int infoId, Collection<SupplyAddDTO> supplies) throws SQLException;
    public Collection<SupplyVO> getSupplies(int infoId);
	Map<Integer, Double> getHealthDataByDogId(int dogId);
	Map<Integer, Double> getHealthDataByBreed(String breed);
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category) throws SQLException;
}
