package br.com.sicredi.voting.aplication.v1.controller.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.voting.aplication.v1.annotation.AssociateResponseGetIdCodeStandard;
import br.com.sicredi.voting.aplication.v1.annotation.AssociatesResponseGetCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/associates")
@Tag(name = "Associados")
public class AssociateQueryController {

	@AssociatesResponseGetCodeStandard
	@GetMapping
	public ResponseEntity<AssociateResponse> findAll() {
		return null;
	}

	@AssociateResponseGetIdCodeStandard
	@GetMapping("/{associateId}")
	public ResponseEntity<AssociateResponse> findById(@PathVariable("associateId") Long associateId) {
		return null;
	}

}
