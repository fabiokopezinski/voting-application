package br.com.sicredi.voting.aplication.controller.query;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sicredi.voting.aplication.feature.SessionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.controller.query.SessionQueryController;
import br.com.sicredi.voting.aplication.v1.service.query.SessionQueryService;

@RunWith(SpringRunner.class)
@WebMvcTest(SessionQueryController.class)
public class SessionQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SessionQueryService service;
	
	@Test
	public void findAll_WhenSessionExiste_ExpectedOK() throws Exception {
		given(service.findAll()).willReturn(Arrays.asList(SessionScenarioFactory.SESSION_RESPONSE));
		mockMvc.perform(get("/sessions")).andExpect(status().isOk());
	}
	
}
