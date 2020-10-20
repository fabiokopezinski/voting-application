package br.com.sicredi.voting.aplication.v1.domain.dto.response;

import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class VoteResponse {

	private Long voteId;
	private VoteEnumeration vote;
	private AssociateResponse associate; 
}
