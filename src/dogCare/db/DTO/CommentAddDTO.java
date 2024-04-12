package dogCare.db.DTO;

public class CommentAddDTO {
    private final String content;
    private final int parentId;
    private final String userId;
    
    //DTO
	public CommentAddDTO(String content, int parentId, String userId) {
		super();
		this.content = content;
		this.parentId = parentId;
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public int getParentId() {
		return parentId;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "CommentAddDTO [content=" + content + ", parentId=" + parentId + ", userId=" + userId + "]";
	}

}
