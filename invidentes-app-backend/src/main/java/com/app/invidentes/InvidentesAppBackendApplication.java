package com.app.invidentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Clase prinsipal donde arranca toda la aplicacion con su respectivo metodo main
 * @author pedro
 *
 */
@CrossOrigin(origins = {"*"})
@SpringBootApplication 
public class InvidentesAppBackendApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Ajecuta la clase estatica SpringApplication
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(InvidentesAppBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		
		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}
		
	}


}
