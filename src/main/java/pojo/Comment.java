package pojo;

public class Comment {
	private Integer id;
	private String pc_comment;
	private Integer pc_star;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPc_comment() {
		return pc_comment;
	}
	public void setPc_comment(String pc_comment) {
		this.pc_comment = pc_comment;
	}
	public Integer getPc_star() {
		return pc_star;
	}
	public void setPc_star(Integer pc_star) {
		this.pc_star = pc_star;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", pc_comment=" + pc_comment + ", pc_star=" + pc_star + "]";
	}
	
}
