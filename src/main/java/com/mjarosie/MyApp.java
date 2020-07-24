package com.mjarosie;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MyApp implements ApplicationRunner {

	@Autowired
	private ObjectProvider<MyService> myServiceProvider;

	private MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String environment = extractEnvironment(args);
		String clientId = extractClientId(args);
		String clientSecret = extractClientSecret(args);

		myService = myServiceProvider.getObject(environment, clientId, clientSecret);
		myService.doSomething();
	}

	private String extractEnvironment(ApplicationArguments args) {
		List<String> clientSecrets = args.getOptionValues("environment");
		try {
			return clientSecrets.get(0);
		} catch (IndexOutOfBoundsException exception) {
			return "dev"; // Default to dev.
		}
	}

	private String extractClientId(ApplicationArguments args) {
		List<String> clientIds = args.getOptionValues("client_id");
		return clientIds.get(0);
	}

	private String extractClientSecret(ApplicationArguments args) {
		List<String> clientSecrets = args.getOptionValues("client_secret");
		return clientSecrets.get(0);
	}

}
