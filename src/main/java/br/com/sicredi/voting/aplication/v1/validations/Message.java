package br.com.sicredi.voting.aplication.v1.validations;

import org.springframework.http.HttpStatus;

import br.com.sicredi.voting.aplication.v1.exception.BusinessException;

public enum Message {

	NOT_FOUND("N�o encontrado", HttpStatus.NOT_FOUND),
	SESSION_NOT_FOUND("Sess�o n�o encontrado",HttpStatus.BAD_REQUEST),
	SESSION_END("Sess�o encerrada",HttpStatus.BAD_REQUEST),
	MEETING_AGENDA_EXISTE("Pauta j� cadastrado",HttpStatus.BAD_REQUEST),
	MEETING_AGENDA_NOT_FOUND("Pauta n�o existe",HttpStatus.BAD_REQUEST),
	USER_CPF_LIST("Cpf n�o encontrado na lista de votantes",HttpStatus.BAD_REQUEST),
	USER_LIST_ERROR("Falha ao consultar a lista de votantes",HttpStatus.BAD_REQUEST),
	ASSOCIATE_EXISTE("Associado j� cadastrado",HttpStatus.BAD_REQUEST),
	ASSOCIATE_NOT_FOUND("Associado n�o encontrado",HttpStatus.NOT_FOUND),
	ASSOCIATE_NOT_VOTE("Associado n�o pode votar",HttpStatus.BAD_REQUEST),
	ASSOCIATE_MEMBER_HAS_ALREADY_VOTED("Associado j� votou nessa pauta",HttpStatus.NOT_FOUND);
	
	private String value;
	private String description;
	private HttpStatus statusCode;

	private Message(String value, HttpStatus statusCode) {
		this.value = value;
		this.statusCode = statusCode;
	}

	private Message(String value, String description, HttpStatus statusCode) {
		this.value = value;
		this.description = description;
		this.statusCode = statusCode;
	}

	private Message(String value) {
		this.value = value;
	}

	public String getMessage() {
		return this.value;
	}

	public HttpStatus getStatus() {
		return this.statusCode;
	}

	public String getDescription() {
		return description;
	}

	public BusinessException asBusinessException() {
		return BusinessException.builder().httpStatusCode(this.getStatus())
				.code(String.valueOf(this.getStatus().value())).message(this.getMessage())
				.description(this.getDescription()).build();
	}
}
