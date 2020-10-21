package br.com.sicredi.voting.aplication.v1.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.voting.aplication.v1.annotation.QuestionResponsePostCodeStandard;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.QuestionRequest;
import br.com.sicredi.voting.aplication.v1.service.command.QuestionCommandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/questions")
@Tag(name = "Pautas")
@AllArgsConstructor
public class QuestionCommandController {

	private QuestionCommandService service;

	@QuestionResponsePostCodeStandard
	@PostMapping
	public ResponseEntity<QuestionResponse> insert(@RequestBody QuestionRequest request) throws NotFoundException {
		QuestionResponse response = service.insert(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
