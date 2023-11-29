package com.four.Mybatis.Bean;

import java.util.List;




public class User {
	private Integer UserID;
	private String Name;
	private String Password;
	private String Phone;
	private String Address;
	private List<Order> orders;
	/*private Card card;*/
	private Integer isMember;
	
	public User() {
		super();
	}	

	public User(String name, String password, String phone, String address) {
		super();
		Name = name;
		this.Password = password;
		Phone = phone;
		Address = address;
	}

	/*@Override
	public String toString() {
		return "User [UserID=" + UserID + ", Name=" + Name + ", password=" + Password + ", Phone=" + Phone
				+ ", Adderss=" + Address + ", orders=" + orders + ", card=" + card + "]";
	}*/

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAdderss() {
		return Address;
	}

	public void setAdderss(String adderss) {
		Address = adderss;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/*public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}*/

	public Integer getIsMember() {
		return isMember;
	}

	public void setIsMember(Integer isMember) {
		this.isMember = isMember;
	}

}

