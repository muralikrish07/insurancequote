package com.cg.model;
import java.io.Serializable;
public class Accounts implements Serializable{
	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private Integer insuredZip;
	private String lineOfBusiness;
	private Integer accountNumber;
	
	public Accounts() {
		super();
	}


	public Accounts(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			Integer insuredZip ) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		
	}


	public Accounts(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			Integer insuredZip, String lineOfBusiness, Integer accountNumber) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.lineOfBusiness = lineOfBusiness;
		this.accountNumber = accountNumber;
	}

 
	public Accounts(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			Integer insuredZip, String lineOfBusiness) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.lineOfBusiness = lineOfBusiness;
	}


	public String getInsuredName() {
		return insuredName;
	}


	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}


	public String getInsuredStreet() {
		return insuredStreet;
	}


	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}


	public String getInsuredCity() {
		return insuredCity;
	}


	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}


	public String getInsuredState() {
		return insuredState;
	}


	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}


	public Integer getInsuredZip() {
		return insuredZip;
	}


	public void setInsuredZip(Integer insuredZip) {
		this.insuredZip = insuredZip;
	}


	public String getLineOfBusiness() {
		return lineOfBusiness;
	}


	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Accounts [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", lineOfBusiness="
				+ lineOfBusiness + ", accountNumber=" + accountNumber + "]";
	}
	
}


