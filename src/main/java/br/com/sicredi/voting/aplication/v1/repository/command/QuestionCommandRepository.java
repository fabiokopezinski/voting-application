package br.com.sicredi.voting.aplication.v1.repository.command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Question;

@Repository
public interface QuestionCommandRepository extends JpaRepository<Question, Long> {

}
