package br.com.sicredi.voting.aplication.v1.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.repository.query.QuestionQueryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QuestionQueryService")
@AllArgsConstructor
public class QuestionQueryService {
	
	private QuestionQueryRepository questionQueryRepository;
	
	public List<QuestionResponse> findAllQuestion(){
		log.info("method=findAllQuestion");
		return questionQueryRepository.findAllQuestion();
	}

}
