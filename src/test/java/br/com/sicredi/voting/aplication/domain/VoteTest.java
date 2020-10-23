package br.com.sicredi.voting.aplication.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.VoteScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.Vote;

@RunWith(MockitoJUnitRunner.class)
public class VoteTest {

	@InjectMocks
	Vote vote;

	@Test
	public void EqualsAndHashCode_ExpectedEquals() {

		Vote x = VoteScenarioFactory.VOTE;
		Vote y = VoteScenarioFactory.VOTE_NEW;
		assertNotSame(x, y);
		assertEquals(x.hashCode(), y.hashCode());
		assertEquals(x.toString(), y.toString());
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.equals(y));
	}

	@Test
	public void Vote_ExpectedGetObjects() {
		assertNotNull(VoteScenarioFactory.VOTE_GET);
	}

	
	@Test
	public void Vote_ExpectedBuildNoArgs() {
		new Vote();
	}
	
	@Test
	public void Vote_ExpectedBuildObjects() {
		assertNotNull(VoteScenarioFactory.VOTE_BUILDER);
	}
	
	@Test
	public void Vote_AssociateBuilder_toString() {
		Vote.VoteBuilder builder = Vote.builder();
		String expected = Vote.builder().toString();
		assertEquals(expected, builder.toString());
	}

	@Test
	public void Vote_Of() {
		assertNotNull(VoteScenarioFactory.VOTE_OF);
	}

	@Test
	public void Vote_ToDTO() {
		assertNotNull(VoteScenarioFactory.VOTE_TODTO);
	}
	
	
}
