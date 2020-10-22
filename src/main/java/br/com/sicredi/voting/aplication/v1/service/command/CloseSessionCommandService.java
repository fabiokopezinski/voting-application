package br.com.sicredi.voting.aplication.v1.service.command;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.sicredi.voting.aplication.v1.domain.Session;
import br.com.sicredi.voting.aplication.v1.domain.enums.SessionStatus;
import br.com.sicredi.voting.aplication.v1.repository.command.SessionCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CloseSessionCommandService {

	private SessionQueryRepository sessionQueryRepository;
	private SessionCommandRepository sessionCommandRepository;
	
	@Transactional
	public void close(Long id) {
		Session response = sessionQueryRepository.findById(id).orElseThrow(()->Message.SESSION_NOT_FOUND.asBusinessException());
		response.setStatus(SessionStatus.CLOSED);
		sessionCommandRepository.save(response);
	}
}
