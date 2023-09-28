package Kuehne.Nagle.OMSA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the OMSA (Order Management System Application).
 */
@SpringBootApplication
public class OmsaApplication {

	/**
	 * The main method that starts the OMSA application.
	 *
	 * @param args The command-line arguments (if any).
	 */
	public static void main(String[] args) {
		SpringApplication.run(OmsaApplication.class, args);
	}

}
