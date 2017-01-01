package runner;

import rmi.*;
import rmi.RemoteHelper;

public class ServerRunner {
	
	public static void main(String[] args) {
		new Launcher().startLaunch(args);
		RemoteHelper.getInstance().init();
		
	}
}

