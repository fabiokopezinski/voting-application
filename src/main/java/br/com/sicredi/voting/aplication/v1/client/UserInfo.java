package br.com.sicredi.voting.aplication.v1.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.UserResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserInfo {

	private RestTemplate restTemplate;

    private final String URL = "https://user-info.herokuapp.com";

    public ResponseEntity<UserResponse> getUser(String cpf) {
        return restTemplate.getForEntity(URL.concat("/users/{cpf}"), UserResponse.class, cpf);
    }
}
