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

import br.com.sicredi.voting.aplication.feature.SessionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.query.SessionQueryService;

@RunWith(MockitoJUnitRunner.class)
public class SessionQueryServiceTest {

	@InjectMocks
	SessionQueryService service;

	@Mock
	SessionQueryRepository sessionQueryRepository;

	@Test
	public void findAll_WhenExisteSessionClose_ExpectedList() {

		given(sessionQueryRepository.findAllSession())
				.willReturn(Arrays.asList(SessionScenarioFactory.SESSION_RESPONSE));

		List<SessionResponse> response = service.findAll();

		assertNotNull(response);

		verify(sessionQueryRepository).findAllSession();

	}
}
