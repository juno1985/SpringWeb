package pojo;

import java.util.List;
/*
 * 维护Computer -> Comment 的 1-N关系
 */
public class ComputerComment {
	//Computer
	private Integer cid;
	private String tradeMark;
	private Float price;
	private String pic;
	//Comment
	List<Comment> comments;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "ComputerComment [cid=" + cid + ", tradeMark=" + tradeMark + ", price=" + price + ", pic=" + pic
				+ ", comments=" + comments + "]";
	}
	
	
}
