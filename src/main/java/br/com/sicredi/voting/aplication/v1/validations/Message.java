package br.com.sicredi.voting.aplication.v1.validations;

import org.springframework.http.HttpStatus;

import br.com.sicredi.voting.aplication.v1.exception.BusinessException;

public enum Message {

	NOT_FOUND("Não encontrado", HttpStatus.NOT_FOUND),
	SESSION_NOT_FOUND("Não encontrado",HttpStatus.BAD_REQUEST),
	MEETING_AGENDA_EXISTE("Pauta já cadastrado",HttpStatus.BAD_REQUEST),
	MEETING_AGENDA_NOT_FOUND("Pauta não existe",HttpStatus.BAD_REQUEST),
	ASSOCIATE_EXISTE("Associado já cadastrado",HttpStatus.BAD_REQUEST),
	ASSOCIATE_NOT_FOUND("Associado não encontrado",HttpStatus.NOT_FOUND),
	ASSOCIATE_MEMBER_HAS_ALREADY_VOTED("Associado não encontrado",HttpStatus.NOT_FOUND);
	
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
