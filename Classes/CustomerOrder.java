package leson;

public class CustomerOrder{
		private int mOrderId;
		private int mCustomerId;
		
		public CustomerOrder(int oid,int cid){
			this.mOrderId=oid;
			this.mCustomerId=cid;
			
		}
		public int getmOrderId() {
			return mOrderId;
		}
		public int getmCustomerId() {
			return mCustomerId;
		}	
		
}
