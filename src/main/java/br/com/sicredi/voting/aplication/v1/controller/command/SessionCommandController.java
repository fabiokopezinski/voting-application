package br.com.sicredi.voting.aplication.v1.controller.command;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sicredi.voting.aplication.v1.annotation.SessionResponsePostCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.SessionRequest;
import br.com.sicredi.voting.aplication.v1.service.command.SessionCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sessions")
@Tag(name = "Sessoes")
@AllArgsConstructor
public class SessionCommandController {

	private SessionCommandService service;
	
	@SessionResponsePostCodeStandard
	@PostMapping
	public ResponseEntity<SessionResponse> insert(@RequestBody SessionRequest session) {
		SessionResponse response = service.insert(session);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sessionId}")
				.buildAndExpand(response.getSessionId()).toUri();
		return ResponseEntity.created(uri).body(response);
	}
}
