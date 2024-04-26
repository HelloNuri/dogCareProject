package com.kosta.dogCare.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;


public interface DogInformationService {
	public boolean addDogHealthReport(int dogId, DogInfoVO dogInfo, Collection<SupplyVO> supplies) throws SQLException;
	
    public Map<Integer, Collection<Double>> getHealthGraphByDogId(int dogId);
    
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category) throws SQLException;
	
}
