package br.com.sicredi.voting.aplication.v1.service.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sicredi.voting.aplication.v1.client.UserInfo;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.UserResponse;
import br.com.sicredi.voting.aplication.v1.domain.enums.UserStatusEnumeration;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserInfoCommandService {

	private UserInfo userInfoClient;

	public Boolean isAbleToVote(String cpf) {

		ResponseEntity<UserResponse> userResponse = userInfoClient.getUser(cpf);

		if (HttpStatus.NOT_FOUND.equals(userResponse.getStatusCode())) {
			throw Message.USER_CPF_LIST.asBusinessException();
		}

		if (userResponse.getStatusCode().isError()) {
			throw Message.USER_LIST_ERROR.asBusinessException();
		}

		return UserStatusEnumeration.ABLE_TO_VOTE.equals(userResponse.getBody().getStatus());
	}

}
