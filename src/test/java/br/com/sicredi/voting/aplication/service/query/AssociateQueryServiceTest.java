package br.com.sicredi.voting.aplication.service.query;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.AssociateScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.exception.BusinessException;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.service.query.AssociateQueryService;
import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AssociateQueryServiceTest {

	@InjectMocks
	AssociateQueryService service;
	
	@Mock
	AssociateQueryRepository associateQueryRepository;
	
	@Test
	public void findAll_WhenExisteAssociate_ExpectedList() {
		given(associateQueryRepository.findAllAssociate()).willReturn(Arrays.asList(AssociateScenarioFactory.ASSOCIATE_RESPONSE));
		List<AssociateResponse> listAssociates = service.findAll();
		assertNotNull(listAssociates);
		verify(associateQueryRepository).findAllAssociate();
	}
	
	@Test
	public void findById_WhenAssociateIdIsValid_ExpectedOk() throws NotFoundException {
		given(associateQueryRepository.findByIdAssociate(any())).willReturn(Optional.of(AssociateScenarioFactory.ASSOCIATE_RESPONSE));
		AssociateResponse response = service.findById(AssociateScenarioFactory.ASSOCIATE.getAssociateId());
		assertNotNull(response);
		verify(associateQueryRepository).findByIdAssociate(any());
	}
	
	
	@Test(expected = BusinessException.class)
	public void findById_WhenAssociateIdIsNotValid_ExpectedNotFound() throws NotFoundException{
		service.findById(AssociateScenarioFactory.ASSOCIATE.getAssociateId());
	}
	
	
	
	
	
}
