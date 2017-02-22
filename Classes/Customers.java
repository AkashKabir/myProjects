package leson;

import java.util.ArrayList;

public class Customers{
	private String mCustomerName;
	private int mCustomerId;
	private float mRate;
	private int mRateType;
	
	public Customers(String name,int id,float rate,int rate_type){	
		this.mCustomerName=name;
		this.mCustomerId=id;
		this.mRate=rate;
		this.mRateType=rate_type;
	}
	
	public String getmCustomerName() {
		return mCustomerName;
	}
	public int getmCustomerId() {
		return mCustomerId;
	}
	public float getmRate() {
		return mRate;
	}
	public String getmRateType() {
		switch(mRateType){
		case 1: return "Yearly_Rate";
		case 2: return "half_yearly_rate";
		case 3: return "Monthly_Rate";
		case 4: return "Weekly_Rate";
		}
		return "";
	}

}
