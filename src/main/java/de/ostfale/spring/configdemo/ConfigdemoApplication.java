package de.ostfale.spring.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigdemoApplication implements CommandLineRunner {

	private final String greeting;
	private final ExampleService exampleService;
	private final Greeter greeter;

	public ConfigdemoApplication(@Value("${example.the-greeting:No greeting available}") final String greeting, ExampleService exampleService, final Greeter greeter) {

		this.greeting = greeting;
		this.exampleService = exampleService;
		this.greeter = greeter;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigdemoApplication.class, args);
	}

	/**
	 * The entry point for running Spring Boot applications as command line applications.
	 * Note that this isn't a static method like the {@link #main(java.lang.String...) }.
	 *
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		this.greeter.sayHello(this.greeting);
		this.exampleService.printConfiguration(System.out);
	}
}
