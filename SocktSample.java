package br.com.bruno.kernel.conectivity;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.bruno.kernel.Kernel;

public class SocktSample {

	ServerSocket server;

	Socket client, sokect;

	BufferedReader inServer;

	static int count;

	BufferedInputStream inClint;

	PrintStream outClient, outSever;

	SocktSample() {
		try {
			server = new ServerSocket(4444);
			while (true) {
				client = server.accept();
				Client x = new Client();
				x.client = client;
				x.inServer = new BufferedReader(new InputStreamReader(x.client
						.getInputStream()));
				x.outClient = new PrintStream(x.client.getOutputStream());
				Thread t = new Thread(x, "" + count++);
				t.start();
			}
			// while (true) {
			// String string = inServer.readLine();
			// outClient.write(string.getBytes());
			// System.out.println("IN:" + string);
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		SocktSample x = new SocktSample();
		System.out.println("started");
	}

}

class Client implements Runnable {

	public BufferedReader inServer;

	public PrintStream outClient;

	public Socket client, sokect;

	public void run() {

		while (true) {
			try {
				String string = inServer.readLine();
				outClient.write(string.getBytes());
				System.out.println("IN:" + Thread.currentThread().getName()+ string);
				Kernel x = Kernel.getInstance();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}