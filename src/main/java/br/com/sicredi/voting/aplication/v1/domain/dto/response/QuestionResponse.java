package br.com.sicredi.voting.aplication.v1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class QuestionResponse {
	
	private Long questionId;
	private String subject;
}
