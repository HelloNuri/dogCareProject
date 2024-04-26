package com.kosta.dogCare.model.VO;
import java.sql.Date;
import java.util.Objects;

public class DogVO {
	private int dogId;
    private String name;
    private String breed;
    private Date brithDate;
    private char gender;
    private char neutrification;
    private String userId;
    
	public DogVO(int dogId, String name, String breed, Date brithDate, char gender, char neutrification, String userId) {
		super();
		this.dogId = dogId;
		this.name = name;
		this.breed = breed;
		this.brithDate = brithDate;
		this.gender = gender;
		this.neutrification = neutrification;
		this.userId = userId;
	}
	public int getDogId() {
		return dogId;
	}
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Date getBrithDate() {
		return brithDate;
	}
	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getNeutrification() {
		return neutrification;
	}
	public void setNeutrification(char neutrification) {
		this.neutrification = neutrification;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(breed, brithDate, dogId, gender, name, neutrification, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DogVO other = (DogVO) obj;
		return Objects.equals(breed, other.breed) && Objects.equals(brithDate, other.brithDate) && dogId == other.dogId
				&& gender == other.gender && Objects.equals(name, other.name) && neutrification == other.neutrification
				&& Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return "DogVO [dogId=" + dogId + ", name=" + name + ", breed=" + breed + ", brithDate=" + brithDate
				+ ", gender=" + gender + ", neutrification=" + neutrification + ", userId=" + userId + "]";
	}
	
    

}
