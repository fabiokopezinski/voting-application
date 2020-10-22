package br.com.sicredi.voting.aplication.v1.domain.enums;

import lombok.Getter;

@Getter
public enum SessionStatus {

	OPEN("Open"), CLOSED("Closed");

    private final String description;

    SessionStatus(String description) {
        this.description = description;
    }
}
