package br.com.sicredi.voting.aplication.v1.service.command;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.sicredi.voting.aplication.v1.domain.Associate;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.AssociateRequest;
import br.com.sicredi.voting.aplication.v1.repository.command.AssociateCommandRepository;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import br.com.sicredi.voting.aplication.v1.validations.OnCreate;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("AssociateCommandService")
@AllArgsConstructor
@Validated
@Slf4j
public class AssociateCommandService {

	private AssociateCommandRepository associateCommandRepository;
	private AssociateQueryRepository associateQueryRepository;

	@Validated(OnCreate.class)
	public AssociateResponse insert(@Valid AssociateRequest request) throws NotFoundException {
		associateQueryRepository.findByCpf(request.getCpf()).ifPresent(asr -> {
			throw Message.ASSOCIATE_EXISTE.asBusinessException();
		});
		Associate associado = Associate.of(request);
		Associate response = associateCommandRepository.save(associado);
		
		log.info("method=insert associateId={}", response.getAssociateId());
		
		return response.toDTO();
	}
}
