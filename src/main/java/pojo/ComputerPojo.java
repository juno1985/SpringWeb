package pojo;

public class ComputerPojo {

	private int cid;
	private String tradeMark;
	private float price;
	private String pic;
	public ComputerPojo() {
		super();
	}
	public ComputerPojo(int cid, String tradeMark, float price, String pic) {
		super();
		this.cid = cid;
		this.tradeMark = tradeMark;
		this.price = price;
		this.pic = pic;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
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
