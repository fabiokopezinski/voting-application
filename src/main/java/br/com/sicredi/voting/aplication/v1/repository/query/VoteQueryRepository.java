package br.com.sicredi.voting.aplication.v1.repository.query;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Vote;

@Repository
public interface VoteQueryRepository extends JpaRepository<Vote, Long> {
	Optional<Vote> findByAssociate_AssociateId(Long associateId);
}
