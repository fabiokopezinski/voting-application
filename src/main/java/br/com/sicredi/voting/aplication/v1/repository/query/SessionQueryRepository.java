package br.com.sicredi.voting.aplication.v1.repository.query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Session;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse;

@Repository

public interface SessionQueryRepository extends JpaRepository<Session, Long> {

	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.SessionResponse(sr.sessionId,"
			+ "sr.duration,"
			+ "sr.votesYes,"
			+ "sr.votesNo "
			+ " ) FROM Session sr WHERE sr.status=1")
	List<SessionResponse> findAllSession();
	Optional<Session> findBySessionIdAndAssociate_AssociateId(Long sessionId,Long associateId);
	
}
