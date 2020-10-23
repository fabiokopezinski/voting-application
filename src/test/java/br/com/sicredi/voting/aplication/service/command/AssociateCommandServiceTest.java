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

import br.com.sicredi.voting.aplication.feature.AssociateScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.exception.BusinessException;
import br.com.sicredi.voting.aplication.v1.repository.command.AssociateCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.command.AssociateCommandService;
import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AssociateCommandServiceTest {

	@InjectMocks
	AssociateCommandService service;

	@Mock
	AssociateCommandRepository associateCommandRepository;
	@Mock
	AssociateQueryRepository associateQueryRepository;

	@Test
	public void insert_WhenAssociateRequestIsValid_ExpectedOk() throws NotFoundException {
		given(associateQueryRepository.findByCpf(any())).willReturn(Optional.empty());
		given(associateCommandRepository.save(any())).willReturn(AssociateScenarioFactory.ASSOCIATE);
		AssociateResponse response = service.insert(AssociateScenarioFactory.ASSOCIATE_REQUEST);
		assertNotNull(response);
		verify(associateCommandRepository).save(any());
	}
	
	@Test(expected=BusinessException.class)
	public void insert_WhenAssociateIdIsPresent_ExpectedBusiness() throws NotFoundException {
		given(associateQueryRepository.findByCpf(any())).willReturn(Optional.of(AssociateScenarioFactory.ASSOCIATE_RESPONSE));
		service.insert(AssociateScenarioFactory.ASSOCIATE_REQUEST);
	}

}
