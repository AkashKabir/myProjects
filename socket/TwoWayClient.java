package socket;
import java.io.*;
import java.net.*;
public class TwoWayClient
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("localhost",560);
                               
     // reading from keyboard (keyRead object)
     BufferedReader keyRead = 
    		 new BufferedReader(new InputStreamReader(System.in));
     
     // sending to client (pwrite object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);
 
    // receiving from server ( receiveRead  object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     System.out.println("This is the client side : let's Start ");
 
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        pwrite.flush();                    // flush the data
        if((receiveMessage = receiveRead.readLine()) != null) //receive from server
        {	
        	if(receiveMessage.toString().equals("stop"))
        		System.out.println("bye bye");
        	else
        		System.out.println(receiveMessage); // displaying at DOS prompt
        }         
      }               
    }                    
}
