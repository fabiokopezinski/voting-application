package br.com.sicredi.voting.aplication.v1.controller.query;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.voting.aplication.v1.annotation.QuestionResponseGetCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.service.query.QuestionQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/questions")
@Tag(name = "Pautas")
@AllArgsConstructor
public class QuestionQueryController {
	
	private QuestionQueryService service;
	
	@QuestionResponseGetCodeStandard
	@GetMapping
	public ResponseEntity<List<QuestionResponse>> findAllQuestion(){
		return ResponseEntity.ok().body(service.findAllQuestion());
	}

}
