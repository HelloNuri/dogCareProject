package com.kosta.dogCare.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kosta.dogCare.model.DogDAO;
import com.kosta.dogCare.model.DogDAOImpl;
import com.kosta.dogCare.model.DogInformationDAO;
import com.kosta.dogCare.model.DogInformationDAOImpl;
import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;

public class DogInformationServiceImpl implements DogInformationService{
	DogInformationDAO dogInfoDao;
	DogDAO dogDao;
	
	public DogInformationServiceImpl(){
		dogInfoDao = new DogInformationDAOImpl();
		dogDao = new DogDAOImpl();
	}

	@Override
	public boolean addDogHealthReport(DogInfoVO dogInfo, Collection<SupplyVO> supplies){
		boolean result = false;
		int infoId = dogInfoDao.addDogInfo(dogInfo);
		if(infoId == -1)
			return false;
		
		result = dogInfoDao.addDogSupplies(infoId, supplies);
		return result;
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
	public Map<Integer, Collection<Double>> getExerciseGraphByDogId(int dogId) {
		Map<Integer, Collection<Double>> result = new HashMap<>();
		
		Map<Integer, Double> myDogWeights = dogInfoDao.getExerciseDataByDogId(dogId);
		Map<Integer, Double> otherDogWeights = dogInfoDao.getExerciseDataByBreed(dogDao.getBreedByDogId(dogId));
		for (int key : otherDogWeights.keySet()) {
			Collection<Double> weights = new ArrayList<>();
			weights.add(myDogWeights.get(key));
			weights.add(otherDogWeights.get(key));
			result.put(key, weights);
		}
		return result;
	}

	@Override
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category){
		return dogInfoDao.getSupplyStatistic(breed, startAge, endAge, category);
	}


}
