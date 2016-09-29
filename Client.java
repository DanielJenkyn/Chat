package com.owlr.chat;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by DanielJenkyn on 29/09/2016.
 */
public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		int portNum = 4444;
		try {
			socket = new Socket("localhost", portNum);
		} catch(IOException e) {
			System.err.println("Fatal connection error!");
			e.printStackTrace();
		}
	}
}
