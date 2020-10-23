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

import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.controller.query.QuestionQueryController;
import br.com.sicredi.voting.aplication.v1.service.query.QuestionQueryService;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionQueryController.class)
public class QuestionQueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuestionQueryService service;
	
	@Test
	public void findAllQuestion_WhenSessionExiste_ExpectedOK() throws Exception {
		given(service.findAllQuestion()).willReturn(Arrays.asList(QuestionScenarioFactory.QUESTION_RESPONSE));
		mockMvc.perform(get("/questions")).andExpect(status().isOk());
	}
}
