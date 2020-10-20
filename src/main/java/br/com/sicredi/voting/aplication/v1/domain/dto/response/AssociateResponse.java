package br.com.sicredi.voting.aplication.v1.domain.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AssociateResponse {

	
	private Long associadoId;
	private String cpf;
}
