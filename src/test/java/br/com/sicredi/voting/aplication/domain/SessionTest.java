package br.com.sicredi.voting.aplication.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.SessionScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.Session;

@RunWith(MockitoJUnitRunner.class)
public class SessionTest {
	
	@InjectMocks
	Session session;

	@Test
	public void EqualsAndHashCode_ExpectedEquals() {

		Session x = SessionScenarioFactory.SESSION;
		Session y = SessionScenarioFactory.SESSION_NEW;
		assertNotSame(x, y);
		assertEquals(x.hashCode(), y.hashCode());
		assertEquals(x.toString(), y.toString());
		assertTrue(x.equals(y));
	}
	
	@Test
	public void Session_ExpectedGetObjects() {
		assertNotNull(SessionScenarioFactory.SESSION_GET);
	}

	@Test
	public void Session_ExpectedBuildNoArgs() {
		new Session();
	}

	@Test
	public void Session_ExpectedBuildObjects() {
		assertNotNull(SessionScenarioFactory.SESSION_BUILDER);
	}

	@Test
	public void Session_AssociateBuilder_toString() {
		Session.SessionBuilder builder = Session.builder();
		String expected = Session.builder().toString();
		assertEquals(expected, builder.toString());
	}

	@Test
	public void Session_Of() {
		assertNotNull(SessionScenarioFactory.SESSION_OF);
	}

	@Test
	public void Session_ToDTO() {
		assertNotNull(SessionScenarioFactory.SESSION_TODTO);
	}
}
