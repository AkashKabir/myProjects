package leson;

import java.util.ArrayList;

//customers class for instantiating each customer info

public class Customers{
	
	private String mCustomerName;
	private int mCustomerId;

	public Customers(String name,int id){	
		this.mCustomerName=name;
		this.mCustomerId=id;

	}
	
	public String getmCustomerName() {
		return mCustomerName;
	}
	public int getmCustomerId() {
		return mCustomerId;
	}


}
