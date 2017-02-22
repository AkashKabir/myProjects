package leson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		static Scanner input=new Scanner(System.in);
		public static ArrayList<CustomerOrder> OrderList=new ArrayList<>();	//storing info about all the orders
		public static ArrayList<Customers> customersList=new ArrayList<>(); //storing info about all the customers
		
		public static void main(String args[]){
			NewCustomer();
			NewOrder();
			RatebyCID();
			RatebyOID();
		}
		
		public static void NewCustomer(){
			System.out.println("Enter customer details: 'name'  'id'  'rate'  'rate_type' :--- \n1: Yearly\n2: Halfyearly\n3: Monthly\n4: Weekly");
			String name = input.nextLine();
			int id=input.nextInt();
			float rate=input.nextFloat();
			int rate_type=input.nextInt();
			Customers c1=new Customers(name,id,rate,rate_type);
			System.out.println("Customer object creation");
			customersList.add(c1);
		}
		
		public static void NewOrder(){
			System.out.println("Enter the orderid and customer_id\n");
			int cid,oid = 0;
			oid=input.nextInt();
			cid=input.nextInt();
			CustomerOrder o1=new CustomerOrder(oid,cid);
			OrderList.add(o1);
		}
		
		public static void RatebyCID(){
			System.out.println("fetching using CustomerId\n");
			System.out.println("enter the id of customer: ");
			int id=input.nextInt();
			for(Customers x:customersList){
				if(x.getmCustomerId()==id){
					System.out.println("the rate is "+ x.getmRate()+" type is : "+x.getmRateType());
				}
			}
		}
		
		public static void RatebyOID(){
			System.out.println("Fetching using OrderId\n");
			System.out.println("enter the id of order:");
			int id=input.nextInt();
			for(CustomerOrder x:OrderList){
				if(x.getmOrderId()==id){
					int cd=x.getmCustomerId();
					for(Customers y:customersList){
						if(y.getmCustomerId()==cd){
							System.out.println("the rate is "+ y.getmRate()+" type is : "+y.getmRateType());
						}
					}
				}
			}
		}
}
