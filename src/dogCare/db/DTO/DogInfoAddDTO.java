package dogCare.db.DTO;

import java.sql.Timestamp;

public class DogInfoAddDTO {
	private double weight;
	private double exerciseTime;
	private String note;
    private Timestamp uploadTime;
    
	public DogInfoAddDTO(double weight, double exerciseTime, String note, Timestamp uploadTime) {
		super();
		this.weight = weight;
		this.exerciseTime = exerciseTime;
		this.note = note;
		this.uploadTime = uploadTime;
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

	@Override
	public String toString() {
		return "DogInfoAddDTO [weight=" + weight + ", exerciseTime=" + exerciseTime + ", note=" + note + ", uploadTime="
				+ uploadTime + "]";
	}
}
