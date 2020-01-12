package org.zeroturnaround.jf.homework13;

import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

public class Server 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		// server is listening on port 7070
		ServerSocket ss = new ServerSocket(7070); 
		
		// running infinite loop for getting 
		// client request 
		while (true) 
		{ 
			SocketChannel s = null; 
			
			try
			{ 
				// socket object to receive incoming client requests 
				s = ss.accept(); 
				
				System.out.println(s +" has joined."); 
				
				// obtaining input and out streams 
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				

				// create a new thread object 
				Thread t = new ClientHandler(s, dis, dos); 

				// Invoking the start() method 
				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 
