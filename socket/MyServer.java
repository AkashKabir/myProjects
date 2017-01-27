package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String args[]) throws IOException{
		try{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			String str2="";
			int i=0;
			String str="";
				//if(i==0){str2="hey";i++;}
				//else if(i==1){str2="client";i++;}
				//else if(i==2){str2="how";i++;}
				//else if(i==3){str2="are";i++;}
				//else if(i==4){str2="stop";i++;}
				str=(String)dis.readUTF();
				System.out.println("client: "+ str);
				//dout.writeUTF(str2);
				//dout.flush();
			ss.close();
			dis.close();
		}catch(Exception e){System.out.println("throws Exception "+e);
	}
}
}
