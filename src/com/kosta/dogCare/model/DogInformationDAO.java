package com.kosta.dogCare.model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;

public interface DogInformationDAO {
	
	//DogInfo CRUD
    public int addDogInfo(int dogId, DogInfoVO dogInfo);
    public Collection<DogInfoVO> getDogInfos(int dogId);

    //Supplies CRUD
    public boolean addDogSupplies(int infoId, Collection<SupplyVO> supplies);
    public Collection<SupplyVO> getSupplies(int infoId);
	Map<Integer, Double> getHealthDataByDogId(int dogId);
	Map<Integer, Double> getHealthDataByBreed(String breed);
	public Collection<Map<String, Double>> getSupplyStatistic(String breed, int startAge, int endAge, String category);
}
