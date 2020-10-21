package br.com.sicredi.voting.aplication.v1.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class AssociateRequest {

	@Size(groups={OnCreate.class},max = 14, message = "O campo 'cpf' está inválido no corpo da requisição")
	@NotNull(groups={OnCreate.class},message = "O campo 'cpf' é obrigatório no corpo da requisição")
	private String cpf;
}
