package br.com.sicredi.voting.aplication.v1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SessionResponse {

	private Long sessionId;
	private Integer duration;
	private Long votesYes;
	private Long votesNo;
	
}
