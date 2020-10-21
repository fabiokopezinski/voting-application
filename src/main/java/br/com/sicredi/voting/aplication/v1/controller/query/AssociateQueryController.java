package br.com.sicredi.voting.aplication.v1.controller.query;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.voting.aplication.v1.annotation.AssociateResponseGetIdCodeStandard;
import br.com.sicredi.voting.aplication.v1.annotation.AssociatesResponseGetCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.service.query.AssociateQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/associates")
@Tag(name = "Associados")
@AllArgsConstructor
public class AssociateQueryController {

	private AssociateQueryService service;
	
	@AssociatesResponseGetCodeStandard
	@GetMapping
	public ResponseEntity<List<AssociateResponse>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@AssociateResponseGetIdCodeStandard
	@GetMapping("/{associateId}")
	public ResponseEntity<AssociateResponse> findById(@PathVariable("associateId") Long associateId) {
		return ResponseEntity.ok(service.findById(associateId));
	}

}
