package br.com.sicredi.voting.aplication.controller.command;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.controller.command.QuestionCommandController;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.QuestionRequest;
import br.com.sicredi.voting.aplication.v1.service.command.QuestionCommandService;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionCommandController.class)
public class QuestionCommandControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	QuestionCommandService service;
	
	@Test
	public void insert_WhenQuestionIsValid_ExpectedOk() throws Exception {
		given(service.insert(any(QuestionRequest.class))).willReturn(QuestionScenarioFactory.QUESTION_RESPONSE);
		mockMvc.perform(post("/questions").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(QuestionScenarioFactory.QUESTION_REQUEST))).andExpect(status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new ParameterNamesModule());
			mapper.registerModule(new Jdk8Module());
			mapper.registerModule(new JavaTimeModule());
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
