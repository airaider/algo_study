package hw;

import java.io.Serializable;

public class Product implements Serializable{
	private String no;
	private String name;
	private int price;
	private int quantity;
	public Product(String no, String name, int price, int quantity) {
		this.no = no;
		this.name = name;
		setPrice(price);
		setQuantity(quantity);
	}
	public Product() {
		
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price>0) {
			this.price = price;
		}
		else {
			throw new IllegalArgumentException("0원 이상의 가격을 입력하세요");
		}
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity>0) {
			this.quantity = quantity;
		}
		else {
			throw new IllegalArgumentException("0원 이상의 가격을 입력하세요");
		}
		
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
