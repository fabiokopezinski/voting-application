package br.com.sicredi.voting.aplication.v1.messaging.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Consumer {

	private ObjectMapper objectMapper;
	
	@JmsListener(destination = "session-result", containerFactory = "defaultContainerFactory")
	public void receiveMessage(SessionResponse message) {
		try {
			log.info("Resultado da votação recebido: " + objectMapper.writeValueAsString(message));
		} catch (JsonProcessingException e) {
			log.error("Falha ao converter para JSON.", e);
		}
	}
	
}
