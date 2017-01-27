package socket;
import java.io.*;
import java.net.*;
public class TwoWayServer
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(560);
      System.out.println("Server  ready for chatting: ");
      Socket sock = sersock.accept( );
      
     // reading from keyboard (keyRead object) InputStreamReader(system.in);
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                     
      // sending to client (pwrite object writes to outputstream)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
 
      // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage;               
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) !=null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
      }               
    }                    
}  
