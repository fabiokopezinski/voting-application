package br.com.sicredi.voting.aplication.v1.dto.request;

import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionVoteRequest {

	private Long questionId;
	private Long associateId;
	private VoteEnumeration vote;
}
