package br.com.sicredi.voting.aplication.v1.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sicredi.voting.aplication.v1.validations.OnCreate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class QuestionRequest {

	@Size(groups={OnCreate.class},min=1,max = 255, message = "O campo 'subject' está inválido no corpo da requisição")
	@NotNull(groups={OnCreate.class},message = "O campo 'subject' é obrigatório no corpo da requisição")
	private String subject;
}
