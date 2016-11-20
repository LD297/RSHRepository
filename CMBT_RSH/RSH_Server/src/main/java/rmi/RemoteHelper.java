package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.dao.userdao.CreditRecordListDao;
import data.daoimpl.logindaoimpl.*;
import data.daoimpl.userdaoimpl.*;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
	//	DataRemoteObject dataRemoteObject;
		LoginDaoImpl loginDaoImpl = null;
		CreditRecordListDaoImpl creditRecordListDaoImpl = null;
		UserDaoImpl userDaoImpl = null;
		try {
			loginDaoImpl = new LoginDaoImpl();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/LoginDaoImpl",
					loginDaoImpl);

			creditRecordListDaoImpl = new CreditRecordListDaoImpl();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/CreditRecordListDaoImpl",
					creditRecordListDaoImpl);

			userDaoImpl = new UserDaoImpl();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/UserDaoImpl",
					userDaoImpl);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}

