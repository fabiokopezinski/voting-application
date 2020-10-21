package br.com.sicredi.voting.aplication.v1.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.repository.query.SessionQueryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("SessionQueryService")
@AllArgsConstructor
@Slf4j
public class SessionQueryService {

	private SessionQueryRepository sessionQueryRepository;
	
	public List<SessionResponse> findAll(){
		log.info("method=findAll");
		return sessionQueryRepository.findAllSession();
	}
}
