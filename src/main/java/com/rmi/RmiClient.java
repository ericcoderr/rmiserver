package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String rmiPort = System.getProperty("rmi.port");
		if (rmiPort == null) {
//			rmiPort = "1099";
			rmiPort = "32010";
		}
		String host = System.getProperty("rmi.host");
		if (host == null) {
			host = "192.168.21.172";
//			host = "127.0.0.1";
		}
		ISayHello sayHello = (ISayHello) Naming.lookup("rmi://" + host + ":" + rmiPort + "/say");
		System.out.println(sayHello);
		String s = sayHello.sayHello();
		System.out.println(s);
	}
}
