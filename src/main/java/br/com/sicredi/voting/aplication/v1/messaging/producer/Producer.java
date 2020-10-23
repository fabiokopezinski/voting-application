package br.com.sicredi.voting.aplication.v1.messaging.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class Producer {
	
	private JmsTemplate jmsTemplate;
	
	public void sendResult(SessionResponse session) {
        String destination = "session-result";
        jmsTemplate.convertAndSend(destination, session);
        log.info("Enviando para {} a mensagem: {}", destination, session);
    }
	
	
}
