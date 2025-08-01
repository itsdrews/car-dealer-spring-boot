package drew_dev.demo;

import drew_dev.demo.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarDealerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.exhibitMenu();
	}
}
