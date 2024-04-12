package dogCare.db.DTO;

public class AlbumAddDTO {
	private final String title;
    private final String content;
    private final String userId;
    
	public AlbumAddDTO(String title, String content, String userId) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}


	public String getContent() {
		return content;
	}


	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "AlbumAddDTO [title=" + title + ", content=" + content + ", userId=" + userId + "]";
	}

}
