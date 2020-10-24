package br.com.sicredi.voting.aplication.v1.configuration;

import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@Profile("dev")
@OpenAPIDefinition(
		  info = @Info(
		  title = "Api de votação",
		  description = "" +
		    "Documentção da api ",
		  contact = @Contact(
		    name = "Fábio Kopezinski",  
		    email = "fabiokopezinski@gmail.com"
		  ),
		  license = @License(
		    name = "MIT Licence", 
		    url = "https://github.com/fabiokopezinski/voting-application/blob/main/LICENSE")),
		  servers = @Server(url = "http://localhost:8887/v1")
		)
public class SwaggerDev {

}
