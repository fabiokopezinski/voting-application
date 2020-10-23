package br.com.sicredi.voting.aplication.service.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.exception.BusinessException;
import br.com.sicredi.voting.aplication.v1.repository.command.QuestionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.command.QuestionCommandService;
import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class QuestionCommandServiceTest {

	@InjectMocks
	QuestionCommandService service;

	@Mock
	QuestionQueryRepository questionQueryRepository;

	@Mock
	QuestionCommandRepository questionCommandRepository;

	@Test
	public void insert_WhenQuestionRequestIsValid_ExpectedCreate() throws NotFoundException {
		given(questionQueryRepository.findBySubject(any())).willReturn(Optional.empty());
		given(questionCommandRepository.save(any())).willReturn(QuestionScenarioFactory.QUESTION);
		QuestionResponse response = service.insert(QuestionScenarioFactory.QUESTION_REQUEST);
		assertNotNull(response);
		verify(questionCommandRepository).save(any());
	}

	@Test(expected = BusinessException.class)
	public void insert_WhenQuestionRequestIsNotValid_ExpectedNotFound() throws NotFoundException {
		given(questionQueryRepository.findBySubject(any()))
				.willReturn(Optional.of(QuestionScenarioFactory.QUESTION_RESPONSE));
		service.insert(QuestionScenarioFactory.QUESTION_REQUEST);
	}

}
