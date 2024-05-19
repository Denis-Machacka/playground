// Hauptklasse zum Starten der Anwendung
package ch.zhaw.deeplearningjava.playground;

// Importe zum Starten der Anwendung
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaygroundApplication {

	// Main Methode zum Starten der Spring Boot Anwendung
	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

}
