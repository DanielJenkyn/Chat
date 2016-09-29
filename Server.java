package com.owlr.chat;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Server class for chat program.
 */
public class Server {
	public static void main(String[] args) {
		int portNum = 4444;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(portNum);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + portNum);
			System.exit(1);

		}
	}
}
