package br.com.sicredi.voting.aplication.v1.domain.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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

	@CPF
	@Size(groups={OnCreate.class},min=1,max = 14, message = "O campo 'cpf' est� inv�lido no corpo da requisi��o")
	@NotNull(groups={OnCreate.class},message = "O campo 'cpf' � obrigat�rio no corpo da requisi��o")
	private String cpf;
}
