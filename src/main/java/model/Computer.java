package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class Computer {

	private int id;
	@NotBlank(message="商品名称不能为空")
	private String tradeMark;
	@Min(value=100,message="商品价格不能低于100元")
	@Max(value=10000,message="商品价格不能高于10000元")
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
