package dogCare.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogCare.db.DTO.DogInfoAddDTO;
import dogCare.db.DTO.SupplyAddDTO;
import dogCare.db.dao.DogDAO;
import dogCare.db.dao.DogDAOImpl;
import dogCare.db.dao.DogInformationDAO;
import dogCare.db.dao.DogInformationDAOImpl;

public class DogInformationServiceImpl implements DogInformationService{
	DogInformationDAO dogInfoDao;
	DogDAO dogDao;
	
	public DogInformationServiceImpl() throws ClassNotFoundException, SQLException{
		dogInfoDao = new DogInformationDAOImpl();
		dogDao = new DogDAOImpl();
	}

	@Override
	public boolean addDogHealthReport(int dogId, DogInfoAddDTO dogInfo, Collection<SupplyAddDTO> supplies) throws SQLException {
		boolean result = false;
		int infoId = dogInfoDao.addDogInfo(dogId, dogInfo);
		result = dogInfoDao.addDogSupplies(infoId, supplies);
		return result;
	}

	public Map<Integer, Double> getHealthDataByDogId(int dogId) {
		return dogInfoDao.getHealthDataByDogId(dogId);
	}
	
	public Map<Integer, Double> getHealthDataByBreed(String breed) {
		return dogInfoDao.getHealthDataByBreed(breed);
	}

	@Override
	public Map<Integer, Collection<Double>> getHealthGraphByDogId(int dogId) {
		Map<Integer, Collection<Double>> result = new HashMap<>();
		
		Map<Integer, Double> myDogWeights = dogInfoDao.getHealthDataByDogId(dogId);
		Map<Integer, Double> otherDogWeights = dogInfoDao.getHealthDataByBreed(dogDao.getBreedByDogId(dogId));
		for (int key : otherDogWeights.keySet()) {
			Collection<Double> weights = new ArrayList<>();
			weights.add(myDogWeights.get(key));
			weights.add(otherDogWeights.get(key));
			result.put(key, weights);
		}
		return result;
	}

	@Override
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category) throws SQLException {
		return dogInfoDao.getSupplyStatistic(breed, startAge, endAge, category);
	}


}
