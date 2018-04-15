package pojo;

public class ComputerPojo {

	private Integer cid;
	private String tradeMark;
	private Float price;
	private String pic;
	public ComputerPojo() {
		super();
	}
	public ComputerPojo(Integer cid, String tradeMark, Float price, String pic) {
		super();
		this.cid = cid;
		this.tradeMark = tradeMark;
		this.price = price;
		this.pic = pic;
	}

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
	@Override
	public String toString() {
		return "ComputerPojo [cid=" + cid + ", tradeMark=" + tradeMark + ", price=" + price + ", pic=" + pic + "]";
	}
	
}
