package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {
	private static final long serialVersionUID = 1L;

	public SayHelloImpl() throws RemoteException {
		super(1099);
//		try {
//			RMISocketFactory.setSocketFactory(new MyRMISocket());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Say hello,welcome!";
	}

}
