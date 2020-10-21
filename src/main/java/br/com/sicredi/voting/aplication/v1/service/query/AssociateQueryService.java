package br.com.sicredi.voting.aplication.v1.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;
import br.com.sicredi.voting.aplication.v1.repository.query.AssociateQueryRepository;
import br.com.sicredi.voting.aplication.v1.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("AssociateQueryService")
@AllArgsConstructor
@Slf4j
public class AssociateQueryService {

	private AssociateQueryRepository associateQueryRepository;

	public List<AssociateResponse> findAll() {
		log.info("method=findAll");
		return associateQueryRepository.findAllAssociate();
	}

	public AssociateResponse findById(Long associadoId) {
		log.info("method=findById associadoId={}",associadoId);
		return associateQueryRepository.findByIdAssociate(associadoId).orElseThrow(()-> Message.ASSOCIATE_NOT_FOUND.asBusinessException());
	}
}
