package br.com.sicredi.voting.aplication.v1.repository.query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Associate;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse;

@Repository
public interface AssociateQueryRepository extends JpaRepository<Associate, Long> {
	
	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse(asr.associateId,"
			+ "asr.cpf "
			+ " ) FROM Associate asr ")
	List<AssociateResponse> findAllAssociate();
	
	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse(asr.associateId,"
			+ " asr.cpf"
			+ " ) FROM Associate asr"
			+ " WHERE asr.associateId =:associateId ")
	Optional<AssociateResponse> findByIdAssociate(@Param("associateId")Long associateId);
	
	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.AssociateResponse(asr.associateId,"
			+ " asr.cpf"
			+ " ) FROM Associate asr"
			+ " WHERE asr.cpf =:cpf ")
	Optional<AssociateResponse> findByCpf(@Param("cpf") String cpf);

}
