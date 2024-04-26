package com.kosta.dogCare.model.VO;
public class SupplyVO {
    private int supplyId;
    private String category;
    private String name;
    private int infoId;
    
    //DTO
    public SupplyVO(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}
    
	public SupplyVO(int supplyId, String category, String name, int infoId) {
		super();
		this.supplyId = supplyId;
		this.category = category;
		this.name = name;
		this.infoId = infoId;
	}
	public int getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
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
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + infoId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + supplyId;
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
		SupplyVO other = (SupplyVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (infoId != other.infoId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (supplyId != other.supplyId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SupplyVO [supplyId=" + supplyId + ", category=" + category + ", name=" + name + ", infoId=" + infoId
				+ "]";
	}

}
