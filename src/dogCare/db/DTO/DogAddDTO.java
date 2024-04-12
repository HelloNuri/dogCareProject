package dogCare.db.DTO;

import java.sql.Date;

public class DogAddDTO {
    private String name;
    private String breed;
    private Date brithDate;
    private char gender;
    private char neutrification;
    private String userId;
    
    //DTO
	public DogAddDTO(String name, String breed, Date brithDate, char gender, char neutrification, String userId) {
		super();
		this.name = name;
		this.breed = breed;
		this.brithDate = brithDate;
		this.gender = gender;
		this.neutrification = neutrification;
		this.userId = userId;
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
	public String toString() {
		return "DogAddDTO [name=" + name + ", breed=" + breed + ", brithDate=" + brithDate + ", gender=" + gender
				+ ", neutrification=" + neutrification + ", userId=" + userId + "]";
	}
}
