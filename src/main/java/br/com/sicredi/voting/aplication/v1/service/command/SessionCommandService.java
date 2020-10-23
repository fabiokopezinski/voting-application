package br.com.sicredi.voting.aplication.v1.service.command;

import java.time.Instant;

import javax.validation.Valid;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.sicredi.voting.aplication.v1.domain.Associate;
import br.com.sicredi.voting.aplication.v1.domain.Question;
import br.com.sicredi.voting.aplication.v1.domain.Session;
import br.com.sicredi.voting.aplication.v1.domain.Vote;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.SessionRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.VoteRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.VoteResponse;
import br.com.sicredi.voting.aplication.v1.job.CloseSession;
import br.com.sicredi.voting.aplication.v1.repository.command.SessionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import br.com.sicredi.voting.aplication.v1.validations.OnCreate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("SessionCommandService")
@AllArgsConstructor
@Validated
@Slf4j
public class SessionCommandService {

	private SessionCommandRepository sessionCommandRepository;
	private SessionQueryRepository sessionQueryRepository;
	private QuestionQueryRepository questionQueryRepository;
	private TaskScheduler taskScheduler;
	private UserInfoCommandService userInfoCommandService;
	private AssociateQueryRepository associateQueryRepository;
	private CloseSessionCommandService closeSessionCommandService;

	@Validated(OnCreate.class)
	public SessionResponse insert(@Valid SessionRequest sessionRequest) {
		Question question = questionQueryRepository.findById(sessionRequest.getQuestionId())
				.orElseThrow(() -> Message.MEETING_AGENDA_NOT_FOUND.asBusinessException());
		Session session = Session.of(sessionRequest,question);
		Session response = sessionCommandRepository.save(session);
		scheduleClosing(response);
		log.info("method=insert sessionId={}", response.getSessionId());

		return response.toDTO();
	}

	@Validated(OnCreate.class)
	public VoteResponse voting(@Valid VoteRequest voteRequest) {
		Session session = sessionQueryRepository.findById(voteRequest.getSessionId())
				.orElseThrow(() -> Message.SESSION_NOT_FOUND.asBusinessException());
			
		Associate associate = associateQueryRepository.findById(voteRequest.getAssociateId())
				.orElseThrow(() -> Message.ASSOCIATE_NOT_FOUND.asBusinessException());

		session.addAssociate(associate);
		
		sessionQueryRepository.findBySessionIdAndAssociate_AssociateId(voteRequest.getSessionId(), voteRequest.getAssociateId())
		.ifPresent(m->{throw Message.ASSOCIATE_MEMBER_HAS_ALREADY_VOTED.asBusinessException();});

		
		if (userInfoCommandService.isAbleToVote(associate.getCpf())) { 
			throw Message.ASSOCIATE_NOT_VOTE.asBusinessException();
		}

		if (session.isClosed()) {
			throw Message.SESSION_END.asBusinessException();
		}
	
		Vote vote = Vote.of(voteRequest, associate, session);
		session.addVotes(vote);
		Session response = sessionCommandRepository.save(session);
	    log.info("method=voting sessionId={}",response.getSessionId());
		return vote.toDTO();
	}
	
	private void scheduleClosing(Session session) {
        Instant instant = calculateClosingTime(session.getDuration());
        taskScheduler.schedule(new CloseSession(session.getSessionId(), closeSessionCommandService), instant);
    }
	
	private Instant calculateClosingTime(Integer duration) {
        return Instant.now().plusSeconds(duration * 60);
    }

}
