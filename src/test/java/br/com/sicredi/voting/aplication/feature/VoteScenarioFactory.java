package br.com.sicredi.voting.aplication.feature;

import br.com.sicredi.voting.aplication.v1.domain.Vote;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.VoteRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.VoteResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;

public class VoteScenarioFactory {
	public static final Vote VOTE = loadVote();
	public static final Vote VOTE_YES = loadVoteYes();
	public static final Vote VOTE_NO = loadVoteNo();
	public static final Vote VOTE_NEW = loadVoteNew();
	public static final Vote VOTE_GET = loadVoteGet();
	public static final Vote VOTE_BUILDER = loadVoteBuilder();
	public static final Vote VOTE_OF = loadVoteOf();
	public static final VoteResponse VOTE_TODTO = loadVoteToDto();
	public static final VoteRequest VOTE_REQUEST = loadVoteRequest();
	public static final VoteResponse VOTE_RESPONSE = loadVoteResponse();

	private static Vote loadVote() {
		return new Vote(1L, VoteEnumeration.YES, AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);
	}
	
	private static Vote loadVoteNew() {
		return new Vote(1L, VoteEnumeration.YES,AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);
	}

	private static Vote loadVoteNo() {
		return new Vote(1L, VoteEnumeration.NO, AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);

	}

	private static Vote loadVoteYes() {
		return new Vote(1L, VoteEnumeration.YES, AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);

	}

	private static VoteResponse loadVoteResponse() {
		return VoteResponse.builder().associate(AssociateScenarioFactory.ASSOCIATE_RESPONSE).vote(VoteEnumeration.YES)
				.build();
	}

	private static VoteRequest loadVoteRequest() {
		return VoteRequest.builder().associateId(1L).sessionId(1L).vote(VoteEnumeration.YES).build();
	}

	private static VoteResponse loadVoteToDto() {

		Vote vote = new Vote(1L, VoteEnumeration.NO, AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);

		return vote.toDTO();
	}

	private static Vote loadVoteOf() {
		return Vote.of(loadVoteRequest(), AssociateScenarioFactory.ASSOCIATE, SessionScenarioFactory.SESSION);
	}

	private static Vote loadVoteBuilder() {
		return Vote.builder().associate(AssociateScenarioFactory.ASSOCIATE).session(SessionScenarioFactory.SESSION)
				.vote(VoteEnumeration.NO).voteId(1L).build();
	}

	private static Vote loadVoteGet() {
		Vote vote = new Vote();
		vote.getAssociate();
		vote.getSession();
		vote.getVote();
		vote.getVoteId();
		return vote;
	}
}
