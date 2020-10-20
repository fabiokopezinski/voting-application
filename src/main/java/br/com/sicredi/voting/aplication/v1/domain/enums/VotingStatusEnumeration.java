package br.com.sicredi.voting.aplication.v1.domain.enums;

import lombok.Getter;

@Getter
public enum VotingStatusEnumeration {
    OPEN("Open"), CLOSED("Closed");

    private final String description;

    VotingStatusEnumeration(String description) {
        this.description = description;
    }
}
