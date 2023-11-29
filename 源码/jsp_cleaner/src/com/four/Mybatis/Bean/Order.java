package com.four.Mybatis.Bean;


public class Order {
	private Integer OrederID;
	private Integer UserID;
	private String dataTime;
	private Double Cost;
	private Integer isDetermined;
	private String details;
	
	public Order() {
		super();
	}

	public Order( Integer userID, String dataTime, Double cost) {
		super();
		UserID = userID;
		this.dataTime = dataTime;
		Cost = cost;
	}

	public Integer getOrederID() {
		return OrederID;
	}

	public void setOrederID(Integer orederID) {
		OrederID = orederID;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}

	public Double getCost() {
		return Cost;
	}

	public void setCost(Double cost) {
		Cost = cost;
	}

	public Integer getIsDetermined() {
		return isDetermined;
	}

	public void setIsDetermined(Integer isDetermined) {
		this.isDetermined = isDetermined;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [OrederID=" + OrederID + ", UserID=" + UserID + ", dataTime=" + dataTime + ", Cost=" + Cost
				+ ", isDetermined=" + isDetermined + "]";
	}

}
