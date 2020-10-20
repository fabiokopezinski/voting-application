package br.com.sicredi.voting.aplication.v1.domain.enums;

import lombok.Getter;

@Getter
public enum VoteEnumeration {
	
	YES("Yes"), NO("No");

    private final String value;

    VoteEnumeration(String value) {
        this.value = value;
    }
}
