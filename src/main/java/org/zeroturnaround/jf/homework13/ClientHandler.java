package org.zeroturnaround.jf.homework13;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;


class ClientHandler extends Thread 
{ 
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss"); 
	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
	


	public ClientHandler(SocketChannel s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		while (true) 
		{ 
			try { 

				// Ask user what he wants 
				dos.writeUTF(s +" has joined."); 
				dos.writeUTF("hey "+ s ); 
				
				// receive the answer from client 
				received = dis.readUTF(); 
				
				if(received.equals("Exit")) 
				{ 
					dos.writeUTF(s + " has left");
					System.out.println(s + " has left");
					this.s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} 
				
				
 
				dos.writeUTF(s+":" + recieved);

						
					
				
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		} 
		
		try
		{ 
			// closing resources 
			this.dis.close(); 
			this.dos.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
