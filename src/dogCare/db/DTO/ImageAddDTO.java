package dogCare.db.DTO;

public class ImageAddDTO {
	private final String name;
    
    
	public ImageAddDTO(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "ImageAddDTO [name=" + name + "]";
	}
}
