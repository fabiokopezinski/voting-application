package br.com.sicredi.voting.aplication.v1.domain.dto.response;

import br.com.sicredi.voting.aplication.v1.domain.enums.UserStatusEnumeration;
import lombok.Data;

@Data
public class UserResponse {

	 private UserStatusEnumeration status;
}
