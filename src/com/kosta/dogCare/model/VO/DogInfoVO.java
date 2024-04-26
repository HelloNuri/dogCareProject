package com.kosta.dogCare.model.VO;
import java.sql.Timestamp;

public class DogInfoVO {
	private int dogInfoId;
	private double weight;
	private double exerciseTime;
	private String note;
    private Timestamp uploadTime;
    private int dogId;
    
    //DTO
	public DogInfoVO(double weight, double exerciseTime, String note, Timestamp uploadTime, int dogId) {
		super();
		this.weight = weight;
		this.exerciseTime = exerciseTime;
		this.note = note;
		this.uploadTime = uploadTime;
		this.dogId = dogId;
	}
	
	public DogInfoVO(int dogInfoId, double weight, double exerciseTime, String note, Timestamp uploadTime,
			int dogId) {
		super();
		this.dogInfoId = dogInfoId;
		this.weight = weight;
		this.exerciseTime = exerciseTime;
		this.note = note;
		this.uploadTime = uploadTime;
		this.dogId = dogId;
	}
	public int getDogInfoId() {
		return dogInfoId;
	}
	public void setDogInfoId(int dogInfoId) {
		this.dogInfoId = dogInfoId;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getExerciseTime() {
		return exerciseTime;
	}
	public void setExerciseTime(double exerciseTime) {
		this.exerciseTime = exerciseTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public int getDogId() {
		return dogId;
	}
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dogId;
		result = prime * result + dogInfoId;
		long temp;
		temp = Double.doubleToLongBits(exerciseTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((uploadTime == null) ? 0 : uploadTime.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DogInfoVO other = (DogInfoVO) obj;
		if (dogId != other.dogId)
			return false;
		if (dogInfoId != other.dogInfoId)
			return false;
		if (Double.doubleToLongBits(exerciseTime) != Double.doubleToLongBits(other.exerciseTime))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (uploadTime == null) {
			if (other.uploadTime != null)
				return false;
		} else if (!uploadTime.equals(other.uploadTime))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DogInfoVO [dogInfoId=" + dogInfoId + ", weight=" + weight + ", exerciseTime=" + exerciseTime + ", note="
				+ note + ", uploadTime=" + uploadTime + ", dogId=" + dogId + "]";
	}
    
    
}
