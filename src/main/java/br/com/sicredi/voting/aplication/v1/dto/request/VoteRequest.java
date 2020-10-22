package br.com.sicredi.voting.aplication.v1.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sicredi.voting.aplication.v1.domain.enums.VoteEnumeration;
import br.com.sicredi.voting.aplication.v1.validations.OnCreate;
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
public class VoteRequest {

	@Min(groups = { OnCreate.class}, value = 0, message = "O campo 'sessionId' está inválido no corpo da requisição")
	@Max(groups = { OnCreate.class}, value = 99999999, message = "O campo 'sessionId' está inválido no corpo da requisição")
	private Long sessionId;
	
	@Min(groups = { OnCreate.class}, value = 0, message = "O campo 'associateId' está inválido no corpo da requisição")
	@Max(groups = { OnCreate.class}, value = 99999999, message = "O campo 'associateId' está inválido no corpo da requisição")
	private Long associateId;
	
	//@Size(groups={OnCreate.class},min=2,max = 4, message = "O campo 'vote' está inválido no corpo da requisição")
	@NotNull(groups={OnCreate.class},message = "O campo 'vote' é obrigatório no corpo da requisição")
	private VoteEnumeration vote;
}
