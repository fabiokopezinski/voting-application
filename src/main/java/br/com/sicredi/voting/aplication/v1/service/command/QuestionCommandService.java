package br.com.sicredi.voting.aplication.v1.service.command;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.sicredi.voting.aplication.v1.domain.Question;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.QuestionRequest;
import br.com.sicredi.voting.aplication.v1.repository.command.QuestionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import br.com.sicredi.voting.aplication.v1.validations.OnCreate;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("QuestionCommandService")
@AllArgsConstructor
@Validated
@Slf4j
public class QuestionCommandService {

	private QuestionQueryRepository questionQueryRepository;
	private QuestionCommandRepository questionCommandRepository;

	@Transactional
	@Validated(OnCreate.class)
	public QuestionResponse insert(@Valid QuestionRequest request) throws NotFoundException {
		questionQueryRepository.findBySubject(request.getSubject()).ifPresent(qs -> {
			throw Message.MEETING_AGENDA_EXISTE.asBusinessException();
		});
		Question question = Question.of(request);
		Question response = questionCommandRepository.save(question);
		
		log.info("method=insert questionId={}", response.getQuestionId());
		
		return response.toDTO();
	}

}
