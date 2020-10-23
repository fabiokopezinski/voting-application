package br.com.sicredi.voting.aplication.controller.query;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sicredi.voting.aplication.feature.AssociateScenarioFactory;
import br.com.sicredi.voting.aplication.v1.controller.query.AssociateQueryController;
import br.com.sicredi.voting.aplication.v1.service.query.AssociateQueryService;

@RunWith(SpringRunner.class)
@WebMvcTest(AssociateQueryController.class)
public class AssociateQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AssociateQueryService service;
	
	@Test
	public void findAll_WhenAssociateExiste_ExpectedOK() throws Exception {
		given(service.findAll()).willReturn(Arrays.asList(AssociateScenarioFactory.ASSOCIATE_RESPONSE));
		mockMvc.perform(get("/associates")).andExpect(status().isOk());
	}
	
	@Test
	public void findById_WhenLongIsValid_ExpectedOK() throws Exception {
		given(service.findById(any())).willReturn(AssociateScenarioFactory.ASSOCIATE_RESPONSE);
		mockMvc.perform(get("/associates/1")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}
