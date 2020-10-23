package br.com.sicredi.voting.aplication.feature;

import br.com.sicredi.voting.aplication.v1.domain.Associate;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.AssociateRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;

public class AssociateScenarioFactory {

	public static final Associate ASSOCIATE = loadAssociate();
	public static final Associate ASSOCIATE_DIFFERENT = loadAssociateDifferent();
	public static final Associate ASSOCIATE_NEW = loadAssociateNew();
	public static final Associate ASSOCIATE_GET = loadAssociateGet();
	public static final Associate ASSOCIATE_BUILDER = loadAssociateBuilder();
	public static final Associate ASSOCIATE_OF = loadAssociateOf();
	public static final AssociateResponse ASSOCIATE_TODTO = loadAssociateTODTO();
	public static final AssociateRequest ASSOCIATE_REQUEST = loadAssociateRequest();
	public static final AssociateResponse ASSOCIATE_RESPONSE = loadAssociateResponse();

	private static Associate loadAssociate() {
		return new Associate(1L, "58459086046");
	}

	private static AssociateResponse loadAssociateTODTO() {

		Associate associate = new Associate();
		return associate.toDTO();
	}

	private static Associate loadAssociateOf() {
		return Associate.of(loadAssociateRequest());
	}

	private static AssociateResponse loadAssociateResponse() {
		return AssociateResponse.builder().associateId(1L).cpf("58459086046").build();
	}

	private static AssociateRequest loadAssociateRequest() {
		return AssociateRequest.builder().cpf("58459086046").build();
	}

	private static Associate loadAssociateBuilder() {
		return Associate.builder().associateId(1L).cpf("58459086046").build();
	}

	private static Associate loadAssociateGet() {
		Associate associate = new Associate();
		associate.getAssociateId();
		associate.getCpf();
		return associate;
	}

	private static Associate loadAssociateNew() {
		return new Associate(1L, "09768617047");
	}

	private static Associate loadAssociateDifferent() {
		return new Associate(1L, "58459086046");
	}
}
