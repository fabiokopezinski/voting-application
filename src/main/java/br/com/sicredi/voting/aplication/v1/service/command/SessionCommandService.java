package br.com.sicredi.voting.aplication.v1.service.command;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.sicredi.voting.aplication.v1.domain.Question;
import br.com.sicredi.voting.aplication.v1.domain.Session;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.VoteResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import br.com.sicredi.voting.aplication.v1.dto.request.SessionRequest;
import br.com.sicredi.voting.aplication.v1.dto.request.VoteRequest;
import br.com.sicredi.voting.aplication.v1.repository.command.SessionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.command.VoteCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.VoteQueryRepository;
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
	private SessionQueryRepository 	 sessionQueryRepository;
	private QuestionQueryRepository  questionQueryRepository;
	private VoteCommandRepository    voteCommandRepository;
	private VoteQueryRepository 	 voteQueryRepository;
	
	@Validated(OnCreate.class)
	@Transactional
	public SessionResponse insert(@Valid SessionRequest sessionRequest) {
		Question question=questionQueryRepository.findById(sessionRequest.getQuestionId()).orElseThrow(()->Message.MEETING_AGENDA_NOT_FOUND.asBusinessException());
		Session session=Session.of(sessionRequest);
		session.addQuestion(question.getQuestionId());
		Session response = sessionCommandRepository.save(session);
		

		log.info("method=insert sessionId={}",response.getSessionId());
		
		return response.toDTO();
	}
	
	@Validated(OnCreate.class)
	@Transactional
	public VoteResponse voting(@Valid VoteRequest vote) {
		sessionQueryRepository.findById(vote.getSessionId()).orElseThrow(()->Message.SESSION_NOT_FOUND.asBusinessException());
		voteQueryRepository.findByAssociate_AssociateId(vote.getAssociateId()).ifPresent(m->{throw  Message.ASSOCIATE_MEMBER_HAS_ALREADY_VOTED.asBusinessException();});
		
		return null;
	}

}
