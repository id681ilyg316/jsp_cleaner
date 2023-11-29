package com.four.Mybatis.Bean;

public class Card {
	private Integer UserID;
	private Integer CardID;
	private Double Balance;
	private Integer isUsed;
	public Card() {
		super();
	}
	public Card(Integer cardID, Double balance) {
		CardID = cardID;
		Balance = balance;

	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getCardID() {
		return CardID;
	}
	public void setCardID(Integer cardID) {
		CardID = cardID;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public Integer getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	@Override
	public String toString() {
		return "Card [UserID=" + UserID + ", CardID=" + CardID + ", Balance=" + Balance + ", isUsed=" + isUsed + "]";
	}
	
}
