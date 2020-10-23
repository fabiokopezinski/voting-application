package br.com.sicredi.voting.aplication.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.QuestionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class QuestionTest {
	
	@InjectMocks
	Question question;

	@Test
	public void EqualsAndHashCode_ExpectedEquals() {
		Question x=QuestionScenarioFactory.QUESTION;
		Question y=QuestionScenarioFactory.QUESTION_NEW;
		
		assertNotSame(x, y);
		assertEquals(x.hashCode(), y.hashCode());
		assertEquals(x.toString(), y.toString());
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.equals(y)); 
	}
	
	@Test
	public void Question_ExpectedBuildNoArgs() {
		new Question();
	}
	
	@Test
	public void Question_ExpectedGetObjects() {
		assertNotNull(QuestionScenarioFactory.QUESTION_GET);
	}
	
	@Test
	public void Question_ExpectedBuildObjects() {
		assertNotNull(QuestionScenarioFactory.QUESTION_BUILDER);
	}
	
	
	@Test
	public void Question_QuestionBuilder_toString() {
		Question.QuestionBuilder builder=Question.builder();
		String expected=Question.builder().toString();
		assertEquals(expected, builder.toString());
	}
	
	
	@Test
	public void Question_of() {
		assertNotNull(QuestionScenarioFactory.QUESTION_OF);
	}
	
	@Test
	public void Question_ToDTO() {
		assertNotNull(QuestionScenarioFactory.QUESTION_TODTO);
	}
	
	
	
	
	
	
	
}
