package leson;

/*class for handling the rate associated with the order for a particular customer*/

public class Rate {
	
	private float mRate;
	private int mRateType;
	
	public Rate(float rate,int rate_type){
		this.mRate=rate;
		this.mRateType=rate_type;
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
		return "rate not defined!!!!!";
	}
}
