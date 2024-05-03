package com.kosta.dogCare.model;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.kosta.dogCare.model.VO.DogInfoVO;
import com.kosta.dogCare.model.VO.SupplyVO;

public interface DogInformationDAO {
	
	//DogInfo CRUD
    public int addDogInfo(DogInfoVO dogInfo);
    public Collection<DogInfoVO> getDogInfos(int dogId);
    Map<Integer, Double> getHealthDataByDogId(int dogId);
    Map<Integer, Double> getHealthDataByBreed(String breed);
    Map<Integer, Double> getExerciseDataByDogId(int dogId);
    Map<Integer, Double> getExerciseDataByBreed(String breedByDogId);

    //Supplies CRUD
	Collection<SupplyVO> getSupplies(int infoId);
	Collection<Map<String, String>> getSupplyStatistic(String breed, int startAge, int endAge, String category);
	boolean addDogSupplies(int infoId, Collection<SupplyVO> supplies);
}
