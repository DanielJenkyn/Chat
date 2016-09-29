package com.owlr.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class for chat program.
 */
public class Server {
	public static void main(String args[]) {

		ServerSocket echoServer = null;
		String line;

		BufferedReader is;
		PrintStream os;
		Socket clientSocket = null;

		try {
			echoServer = new ServerSocket(2222);
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println("The server started. To stop it press <CTRL><C>.");
		try {
			clientSocket = echoServer.accept();
			is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new PrintStream(clientSocket.getOutputStream());

			while (true) {
				line = is.readLine();
				os.println("From server: " + line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
