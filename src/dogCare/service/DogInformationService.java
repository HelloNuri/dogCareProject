package dogCare.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import dogCare.db.DTO.DogInfoAddDTO;
import dogCare.db.DTO.SupplyAddDTO;

public interface DogInformationService {
	public boolean addDogHealthReport(int dogId, DogInfoAddDTO dogInfo, Collection<SupplyAddDTO> supplies) throws SQLException;
	
    public Map<Integer, Collection<Double>> getHealthGraphByDogId(int dogId);

	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category) throws SQLException;

}
