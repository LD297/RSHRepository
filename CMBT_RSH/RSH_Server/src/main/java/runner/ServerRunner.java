package runner;

import rmi.*;
import rmi.RemoteHelper;

public class ServerRunner {
	
	public static void main(String[] args) {
		RemoteHelper.getInstance().init();
	}
}

