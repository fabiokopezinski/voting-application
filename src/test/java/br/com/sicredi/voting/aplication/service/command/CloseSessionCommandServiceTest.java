package br.com.sicredi.voting.aplication.service.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.SessionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.messaging.producer.Producer;
import br.com.sicredi.voting.aplication.v1.repository.command.SessionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.command.CloseSessionCommandService;

@RunWith(MockitoJUnitRunner.class)
public class CloseSessionCommandServiceTest {

	@InjectMocks
	CloseSessionCommandService service;
	
	@Mock
	SessionQueryRepository sessionQueryRepository;
	
	@Mock
	SessionCommandRepository sessionCommandRepository;
	
	@Mock
	Producer producer;
	
	@Test
	public void close() {
		given(sessionQueryRepository.findById(any())).willReturn(Optional.of(SessionScenarioFactory.SESSION));
		given(sessionCommandRepository.save(any())).willReturn(SessionScenarioFactory.SESSION);
		doNothing().when(producer).sendResult(any());
		service.close(1L);
		
		
	}
	
	
}
