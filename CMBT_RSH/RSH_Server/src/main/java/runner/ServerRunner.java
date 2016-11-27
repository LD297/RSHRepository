package runner;

import rmi.*;

public class ServerRunner {
	
	public ServerRunner() {
		new RemoteHelper();
		new HotelRemoteHelper();


	}
	
	public static void main(String[] args) {
		new ServerRunner();
	}
}

