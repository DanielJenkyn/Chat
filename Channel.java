package com.owlr.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Created by DanielJenkyn on 30/09/2016.
 */
public class Channel implements Runnable {

	private DatagramSocket socket;
	private boolean isRunning;

	public void bind(int port) throws SocketException {
		socket = new DatagramSocket();
	}

	public void start() {
		Thread thread = new Thread(this);
		thread.start();

	}

	public void stop() {
		isRunning = false;
		socket.close();
	}

	@Override
	public void run() {
		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

		isRunning = true;
		while (isRunning) {
			try {
				socket.receive(packet);
				String msg = new String(buffer, 0, packet.getLength());
			} catch (IOException e) {
				break;
			}
		}
	}

	public void sendTo(InetSocketAddress address, String msg) throws IOException {
		byte[] buffer = msg.getBytes();

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		packet.setSocketAddress(address);
		socket.send(packet);
	}

}
