package br.com.sicredi.voting.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class AplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicationApplication.class, args);
	}

}
