package dogCare.db.DTO;

public class SupplyAddDTO {
    private String category;
    private String name;
    
    //DTO
    public SupplyAddDTO(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SupplyAddDTO [category=" + category + ", name=" + name + "]";
	}
}
