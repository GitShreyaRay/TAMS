package io.fullstackbasics.talent_fulfillment_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fullstackbasics.io.tams_core_api.configuration.AxonXStreamConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Import({AxonXStreamConfig.class})
public class TalentFulfillmentServiceApplication {
	@Value("${spring.application.name}")
	private String serviceName;

	@Autowired
	private Environment environment;

	@GetMapping("/test")
	public String getTest() {
		return "Test from the " + serviceName + " "+environment.getProperty("local.server.port");
	}


	public static void main(String[] args) {
		SpringApplication.run(TalentFulfillmentServiceApplication.class, args);
	}

}
