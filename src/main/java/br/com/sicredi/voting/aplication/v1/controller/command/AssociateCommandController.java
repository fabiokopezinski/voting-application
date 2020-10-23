package br.com.sicredi.voting.aplication.v1.controller.command;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sicredi.voting.aplication.v1.annotation.AssociatesResponsePostCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.AssociateRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.service.command.AssociateCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/associates")
@Tag(name = "Associados")
@AllArgsConstructor
public class AssociateCommandController {

	private AssociateCommandService service;
	
	@AssociatesResponsePostCodeStandard
	@PostMapping
	public ResponseEntity<AssociateResponse> insert(@RequestBody AssociateRequest request) throws NotFoundException{
		AssociateResponse response = service.insert(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{associadoId}")
				.buildAndExpand(response.getAssociateId()).toUri();
		
		return ResponseEntity.created(uri).body(response);
		
	}
}
