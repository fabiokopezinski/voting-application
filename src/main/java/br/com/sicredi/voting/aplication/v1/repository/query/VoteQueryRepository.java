package br.com.sicredi.voting.aplication.v1.repository.query;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Vote;

@Repository
public interface VoteQueryRepository extends JpaRepository<Vote, Long> {
	
	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.Vote(vt.voteId,"
			+ "vt.vote, "
			+ "vt.associate,"
			+ "vt.session"
			+ ") FROM Vote vt "
			+ "WHERE vt.associate.associateId =:associate")
	Optional<Vote> findByAssociateId(@Param("associate")Long associate);
}
