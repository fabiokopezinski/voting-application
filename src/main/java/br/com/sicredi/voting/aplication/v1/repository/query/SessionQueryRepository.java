package br.com.sicredi.voting.aplication.v1.repository.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Session;

@Repository
public interface SessionQueryRepository extends JpaRepository<Session, Long> {

}
