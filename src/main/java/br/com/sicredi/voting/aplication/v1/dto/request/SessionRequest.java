package br.com.sicredi.voting.aplication.v1.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
public class SessionRequest {
	
	@Min(groups = { OnCreate.class}, value = 0, message = "O campo 'questionId' está inválido no corpo da requisição")
	@Max(groups = { OnCreate.class}, value = 99999999, message = "O campo 'questionId' está inválido no corpo da requisição")
	private Long questionId;
	
	@Min(groups = { OnCreate.class}, value = 0, message = "O campo 'duration' está inválido no corpo da requisição")
	@Max(groups = { OnCreate.class}, value = 99999999, message = "O campo 'duration' está inválido no corpo da requisição")
	private Integer duration;

}
