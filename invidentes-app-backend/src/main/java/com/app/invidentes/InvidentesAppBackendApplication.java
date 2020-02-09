package com.app.invidentes;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Clase prinsipal donde arranca toda la aplicacion con su respectivo metodo main
 * @author pedro
 *
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@SpringBootApplication 
public class InvidentesAppBackendApplication {

	/**
	 * Ajecuta la clase estatica SpringApplication
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(InvidentesAppBackendApplication.class, args);
	}

}
