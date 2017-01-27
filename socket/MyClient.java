package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
	public static void main(String args[]) throws IOException{
		try{
		Socket s =new Socket("localhost",6666);
		DataOutputStream dout= new DataOutputStream(s.getOutputStream());
		DataInputStream din=new DataInputStream(s.getInputStream());
		String st2="";
		int i=0;
		while(i<5){
			if(i==0){st2="hello";i++;}
			else if(i==1){st2="server";i++;}
			else if(i==2){st2="will";i++;}
			else if(i==3){st2="you";i++;}
			else if(i==4){st2="stop";i++;}
			//st=(String)din.readUTF();
			//System.out.println("server: "+st);
			dout.writeUTF(st2);	
		}
		dout.flush();
		dout.close();
		s.close();
	} catch(Exception e){System.out.println("exception occurs "+e);}
}
}
