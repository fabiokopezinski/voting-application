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
import org.springframework.scheduling.TaskScheduler;

import br.com.sicredi.voting.aplication.feature.AssociateScenarioFactory;
import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.feature.SessionScenarioFactory;
import br.com.sicredi.voting.aplication.feature.VoteScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.exception.BusinessException;
import br.com.sicredi.voting.aplication.v1.repository.command.SessionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.command.CloseSessionCommandService;
import br.com.sicredi.voting.aplication.v1.service.command.SessionCommandService;
import br.com.sicredi.voting.aplication.v1.service.command.UserInfoCommandService;

@RunWith(MockitoJUnitRunner.class)
public class SessionCommandServiceTest {

	@InjectMocks
	SessionCommandService service;

	@InjectMocks
	CloseSessionCommandService closeSessionCommandService;

	@InjectMocks
	UserInfoCommandService userInfoCommandService;

	@Mock
	SessionCommandRepository sessionCommandRepository;
	@Mock
	SessionQueryRepository sessionQueryRepository;
	@Mock
	QuestionQueryRepository questionQueryRepository;
	@Mock
	TaskScheduler taskScheduler;
	@Mock
	AssociateQueryRepository associateQueryRepository;

	@Test
	public void insert_WhenSessionRequestIsValid_ExpectedOk() {
		given(questionQueryRepository.findById(any())).willReturn(Optional.of(QuestionScenarioFactory.QUESTION));
		given(sessionCommandRepository.save(any())).willReturn(SessionScenarioFactory.SESSION);
		SessionResponse response = service.insert(SessionScenarioFactory.SESSION_REQUEST);
		assertNotNull(response);
		verify(sessionCommandRepository).save(any());
	}
	
	@Test(expected = BusinessException.class)
	public void insert_WhenSessionRequestIsNotValid_ExpectedOk() {
		given(questionQueryRepository.findById(any())).willReturn(Optional.empty());
	    service.insert(SessionScenarioFactory.SESSION_REQUEST);
		
	}

	@Test(expected = BusinessException.class)
	public void voting_WhenSessionIdIsNotValid_ExpectedNotFound() {
		service.voting(VoteScenarioFactory.VOTE_REQUEST);
	}
	
	@Test(expected = BusinessException.class)
	public void voting_WhenAssociateNotValid_ExpectedNotFound() {
		given(sessionQueryRepository.findById(any())).willReturn(Optional.of(SessionScenarioFactory.SESSION));
		service.voting(VoteScenarioFactory.VOTE_REQUEST);
	}
	
	@Test(expected = BusinessException.class)
	public void voting_WhenSessionIsNotValid_ExpectedNotFound() {
		given(sessionQueryRepository.findById(any())).willReturn(Optional.of(SessionScenarioFactory.SESSION));
		given(associateQueryRepository.findById(any())).willReturn(Optional.of(AssociateScenarioFactory.ASSOCIATE));
		given(sessionQueryRepository.findBySessionIdAndAssociate_AssociateId(any(),any())).willReturn(Optional.of(SessionScenarioFactory.SESSION));
		service.voting(VoteScenarioFactory.VOTE_REQUEST);
	}
	
}
