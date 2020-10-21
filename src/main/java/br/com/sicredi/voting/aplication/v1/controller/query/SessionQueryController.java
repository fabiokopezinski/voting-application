package br.com.sicredi.voting.aplication.v1.controller.query;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.voting.aplication.v1.annotation.SessionResponseGetCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;
import br.com.sicredi.voting.aplication.v1.service.query.SessionQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/sessions")
@Tag(name = "Sessoes")
@AllArgsConstructor
public class SessionQueryController {

	private SessionQueryService service;
	
	@SessionResponseGetCodeStandard
	@GetMapping
	public ResponseEntity<List<SessionResponse>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
}
