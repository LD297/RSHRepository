package runner;

import rmi.*;

public class ServerRunner {
	
	public static void main(String[] args) {
		RemoteHelper.getInstance().init();
	}
}

