package br.com.sicredi.voting.aplication.service.query;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.query.QuestionQueryService;

@RunWith(MockitoJUnitRunner.class)
public class QuestionQueryServiceTest {

	@InjectMocks
	QuestionQueryService service;
	
	@Mock
	QuestionQueryRepository repository;
	
	@Test
	public void findAllQuestion_WhenExisteQuestion_Expected() {
		given(repository.findAllQuestion()).willReturn(Arrays.asList(QuestionScenarioFactory.QUESTION_RESPONSE));
		List<QuestionResponse> response = service.findAllQuestion();
		assertNotNull(response);
		verify(repository).findAllQuestion();
	}
}
