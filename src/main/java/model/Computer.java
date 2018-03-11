package model;

public class Computer {

	private int id;
	private String tradeMark;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Computer() {
		super();
	}
	public Computer(int id, String tradeMark, int price) {
		super();
		this.id = id;
		this.tradeMark = tradeMark;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Computer [id=" + id + ", tradeMark=" + tradeMark + ", price=" + price + "]";
	}
	
}
