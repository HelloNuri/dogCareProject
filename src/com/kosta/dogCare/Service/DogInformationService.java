package com.kosta.dogCare.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;


public interface DogInformationService {
	public boolean addDogHealthReport(DogInfoVO dogInfo, Collection<SupplyVO> supplies);
	
    public Map<Integer, Collection<Double>> getHealthGraphByDogId(int dogId);
    
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category);

	Map<Integer, Collection<Double>> getExerciseGraphByDogId(int dogId);
	
}
