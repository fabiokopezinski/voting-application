package br.com.sicredi.voting.aplication.v1.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		  info = @Info(
		  title = "Api de votação",
		  description = "" +
		    "Documentação da api ",
		  contact = @Contact(
		    name = "Fábio Kopezinski",  
		    email = "fabiokopezinski@gmail.com"
		  ),
		  license = @License(
		    name = "MIT Licence", 
		    url = "https://github.com/fabiokopezinski/voting-application/blob/main/LICENSE")),
		  servers = @Server(url = "http://localhost:8080/v1")
		)
public class Swagger {

	
}
