package com.rmi;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RmiApp {
	public static void main(String[] args) {
		SpringApplication.run(RmiApp.class, args);
	}

	@Bean
	public CommandLineRunner getCommandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.setProperty("java.rmi.server.hostname", "192.168.21.172");
				String host = InetAddress.getLocalHost().getHostAddress();
				int rmiPort = 1099;
				String bindName = "say";
				LocateRegistry.createRegistry(rmiPort);
				ISayHello hello = new SayHelloImpl();
				String rmi = "rmi://" + host + ":" + rmiPort + "/" + bindName;
				Naming.rebind(rmi, hello);
				System.out.println("rmi start : " + rmi);
			}
		};
	}
}
