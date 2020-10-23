package br.com.sicredi.voting.aplication.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sicredi.voting.aplication.feature.AssociateScenarioFactory;
import br.com.sicredi.voting.aplication.v1.domain.Associate;

@RunWith(MockitoJUnitRunner.class)
public class AssociateTest {

	@InjectMocks
	Associate associate;

	@Test
	public void EqualsAndHashCode_ExpectedEquals() {

		Associate x = AssociateScenarioFactory.ASSOCIATE;
		Associate y = AssociateScenarioFactory.ASSOCIATE_NEW;
		assertNotSame(x, y);
		assertEquals(x.hashCode(), y.hashCode());
		assertEquals(x.toString(), y.toString());
		assertTrue(x.hashCode() == y.hashCode());
		assertTrue(x.equals(y));
	}

	@Test
	public void Associate_ExpectedGetObjects() {
		assertNotNull(AssociateScenarioFactory.ASSOCIATE_GET);
	}

	@Test
	public void Associate_ExpectedBuildNoArgs() {
		new Associate();
	}

	@Test
	public void Associate_ExpectedBuildObjects() {
		assertNotNull(AssociateScenarioFactory.ASSOCIATE_BUILDER);
	}

	@Test
	public void Associate_AssociateBuilder_toString() {
		Associate.AssociateBuilder builder = Associate.builder();
		String expected = Associate.builder().toString();
		assertEquals(expected, builder.toString());
	}

	@Test
	public void Associate_Of() {
		assertNotNull(AssociateScenarioFactory.ASSOCIATE_OF);
	}

	@Test
	public void Associate_ToDTO() {
		assertNotNull(AssociateScenarioFactory.ASSOCIATE_TODTO);
	}

}
