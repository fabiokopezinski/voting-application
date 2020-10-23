package br.com.sicredi.voting.aplication.feature;

import java.util.ArrayList;
import java.util.List;

import br.com.sicredi.voting.aplication.v1.domain.Session;
import br.com.sicredi.voting.aplication.v1.domain.Vote;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.SessionRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.SessionStatus;

public class SessionScenarioFactory {

	public static final Session SESSION = loadSession();
	public static final Session SESSION_NEW = loadSessionNew();
	public static final Session SESSION_GET = loadSessionGet();
	public static final Session SESSION_BUILDER = loadSessionBuilder();
	public static final Session SESSION_OF = loadSessionOf();
	public static final SessionResponse SESSION_TODTO = loadSessionToDTO();
	public static final SessionRequest SESSION_REQUEST = loadSessionRequest();
	public static final SessionResponse SESSION_RESPONSE = loadSessionResponse();

	private static Session loadSession() {
		List<Vote> votes = new ArrayList<Vote>();
		votes.add(VoteScenarioFactory.VOTE_YES);
		votes.add(VoteScenarioFactory.VOTE_NO);
		return new Session(1L, 1, 1L, 1L, SessionStatus.CLOSED, votes, QuestionScenarioFactory.QUESTION,
				AssociateScenarioFactory.ASSOCIATE);
	}

	private static Session loadSessionNew() {
		List<Vote> votes = new ArrayList<Vote>();
		votes.add(VoteScenarioFactory.VOTE_YES);
		votes.add(VoteScenarioFactory.VOTE_NO);
		return new Session(1L, 1, 1L, 1L, SessionStatus.CLOSED, votes, QuestionScenarioFactory.QUESTION,
				AssociateScenarioFactory.ASSOCIATE);
	}

	private static SessionResponse loadSessionResponse() {
		return SessionResponse.builder().duration(1).sessionId(1L).votesNo(1L).votesYes(1L).build();
	}

	private static SessionResponse loadSessionToDTO() {
		List<Vote> votes = new ArrayList<Vote>();
		votes.add(VoteScenarioFactory.VOTE_YES);
		votes.add(VoteScenarioFactory.VOTE_NO);
		return new Session(1L, 1, 1L, 1L, SessionStatus.CLOSED, votes, QuestionScenarioFactory.QUESTION,
				AssociateScenarioFactory.ASSOCIATE).toDTO();
	}

	private static SessionRequest loadSessionRequest() {
		return new SessionRequest(1L, 1);
	}

	private static Session loadSessionOf() {
		return Session.of(new SessionRequest(1L, 1), QuestionScenarioFactory.QUESTION);
	}

	private static Session loadSessionBuilder() {
		List<Vote> votes = new ArrayList<Vote>();
		votes.add(VoteScenarioFactory.VOTE_YES);
		votes.add(VoteScenarioFactory.VOTE_NO);
		return Session.builder()
				.associate(AssociateScenarioFactory.ASSOCIATE)
				.duration(1)
				.question(QuestionScenarioFactory.QUESTION)
				.sessionId(1L)
				.status(SessionStatus.OPEN)
				.votesNo(1L)
				.votesYes(1L)
				.votes(votes)
				.build();
	}

	private static Session loadSessionGet() {
		Session session=new Session();
		session.getAssociate();
		session.getDuration();
		session.getQuestion();
		session.getSessionId();
		session.getStatus();
		session.getVotes();
		session.getVotesYes();
		session.getVotesNo();
		return session;
	}

}
