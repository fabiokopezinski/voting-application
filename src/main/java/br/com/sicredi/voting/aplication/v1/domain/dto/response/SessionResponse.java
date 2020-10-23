package br.com.sicredi.voting.aplication.v1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class SessionResponse {

	private Long sessionId;
	private Integer duration;
	private Long votesYes;
	private Long votesNo;
	
}
