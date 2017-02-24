package leson;

/*class for handling orders by assigning the order an orderid 
 * and associating a customerId with the order*/

public class CustomerOrder{

		private int mOrderId;
		private int mCustomerId;
		private Rate mRateDetails;
		
		public CustomerOrder(int oid,int cid,float rate,int rate_type){
			this.mOrderId=oid;
			this.mCustomerId=cid;
			this.mRateDetails=setRateDetails(rate,rate_type);
		}
		
		public Rate setRateDetails(float rate,int rate_type){
			return new Rate(rate,rate_type);
		}
		
		public Rate getmRateDetails() {
			return mRateDetails;
		}

		public int getmOrderId() {
			return mOrderId;
		}
		public int getmCustomerId() {
			return mCustomerId;
		}	
		
}
