package leson;

import java.util.ArrayList;
import java.util.Scanner;

/* class for handling the order mechanism */
public class Main {
	
		static Scanner input=new Scanner(System.in);
		public static ArrayList<CustomerOrder> OrderList=new ArrayList<>();	
		public static ArrayList<Customers> customersList=new ArrayList<>(); 
		
		/* Arraylists for storing info about all the orders & for storing info about all the customers 
		 * which makes it easier to search within orders using orderId or within customers using customerId
		 */
		
		public static void main(String args[]){
			int n;
			char ch='Y';
			while(ch=='y'||ch=='Y'){
				System.out.println("\n1: Register New Customer\n"
						+ "2: Register new Order\n"
						+ "3: find rate using Customer Id\n"
						+ "4: find rate using OrderId\n");
				n=input.nextInt();
				switch(n){
					case 1: NewCustomer();
							break;
					case 2: NewOrder();
							break;
					case 3: RatebyCID();
							break;
					case 4: RatebyOID();
							break;
					default: System.out.print("\nINVALID Choice!!\n");
				}
				System.out.println("\nContinue ? Y or N : ");
				ch=input.next().charAt(0);
			}
		}
		
		public static void NewCustomer(){
			System.out.println("Enter customer details: \n");
			System.out.println("Enter name: ");
			String name = input.next();
			System.out.println("Enter Id: ");
			int id=input.nextInt();
			Customers c1=new Customers(name,id);
			System.out.println("Registered\n");
			customersList.add(c1);
		}
		
		public static void NewOrder(){
			char ch2='Y';
			while(ch2=='y'||ch2=='Y'){
				System.out.println("Enter the orderid:");
				int cid,oid = 0;
				oid=input.nextInt();
				System.out.println("Enter the CustomerId:");
				cid=input.nextInt();
				
				/*checking whether the customer is registered or not*/
				if(validateCustomerId(cid))
				{
								System.out.println("Enter rate details: 'Rate': ");
									float rate=input.nextFloat();
							
									System.out.println("Enter Rate_type:\n"
									+ "1: Yearly\n"
									+ "2: Halfyearly\n"
									+ "3: Monthly\n"
									+ "4: Weekly");
							
									int rate_type=input.nextInt();
									CustomerOrder o1=new CustomerOrder(oid,cid,rate,rate_type);
									OrderList.add(o1);
							
				}
				else{
								System.out.println("Customer not Registered! ");
								break;
					}
				System.out.println("Issue New order ? Y or N : ");
				ch2=input.next().charAt(0);
				}
					
			}
		
		public static void RatebyCID(){
			System.out.println("\nfetching using CustomerId\n");
			System.out.println("enter the id of customer: ");
			int id=input.nextInt();
			int flag=0;
			if(validateCustomerId(id)){
			//finding customer in the orderList using customer Id
			for(CustomerOrder x: OrderList){
				if(x.getmCustomerId()==id){
					flag=1;
					/*In case there are more than one order for same customer so displaying order id along*/
					System.out.println("Order Id:"+x.getmOrderId()+ "\nRate is "+ x.getmRateDetails().getmRate() +
							" \nRate Type is : "+x.getmRateDetails().getmRateType());
				}
				}
				if(flag==0)
					System.out.println("no order made by this customer yet: ");
			}
			else System.out.println("Customer Not Registered! ");
		}
		
		public static void RatebyOID(){
			System.out.println("\nFetching using OrderId\n");
			System.out.println("enter the id of order: ");
			int id=input.nextInt();
			if(validateOrderId(id)){
			for(CustomerOrder x:OrderList){
				if(x.getmOrderId()==id)
					System.out.println("Rate is "+ x.getmRateDetails().getmRate() +
							" \nRate Type is : "+x.getmRateDetails().getmRateType());
						
			}
			}
			else System.out.println("no order with this Id\n");
		}
		
		/*for validating registered customers*/
		public static boolean validateCustomerId(int id){
			for(Customers x: customersList){
				if(x.getmCustomerId()==id)
						return true;
				}
			return false;
		}
		/*for validating order id*/
		public static boolean validateOrderId(int id){
			for(CustomerOrder x: OrderList){
				if(x.getmOrderId()==id)
					return true;
			}
			return false;
		}	
}

