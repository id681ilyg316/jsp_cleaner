package com.four.Mybatis.Bean;

import org.apache.ibatis.type.Alias;


@Alias("cloth")//为类取别名
public class Cloth{
	
	private Integer ClothID;
	private Integer UserID;
	private Integer OrderID;
	private String C_type;
	private Double price;
	private Integer C_number;
	
	public Cloth() {
		super();
	}

	public Cloth(Integer userID,String type, Double price, Integer number) {
		super();
		UserID = userID;
		this.C_type = type;
		this.price = price;
		this.setC_number(number);
	}



	public Integer getClothID() {
		return ClothID;
	}

	public void setClothID(Integer clothID) {
		ClothID = clothID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	@Override
	public String toString() {
		return "Cloth [ClothID=" + ClothID + ", UserID=" + UserID + ", OrderID=" + OrderID + ", type=" + C_type
				+ ", price=" + price + ", number=" + C_number + "]";
	}

	public String getC_type() {
		return C_type;
	}

	public void setC_type(String c_type) {
		C_type = c_type;
	}

	public Integer getC_number() {
		return C_number;
	}

	public void setC_number(Integer c_number) {
		C_number = c_number;
	}
}
