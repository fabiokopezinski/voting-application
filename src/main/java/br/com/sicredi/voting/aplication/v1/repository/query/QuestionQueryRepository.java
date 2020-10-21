package br.com.sicredi.voting.aplication.v1.repository.query;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sicredi.voting.aplication.v1.domain.Question;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;

@Repository
public interface QuestionQueryRepository extends JpaRepository<Question, Long> {

	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse(qs.questionId,"
			+ "qs.subject"
			+ ")FROM Question qs")
	List<QuestionResponse> findAllQuestion();
	
	@Query(value="SELECT new br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse(qs.questionId,"
			+ "qs.subject"
			+ ")FROM Question qs"
			+ " WHERE qs.subject =:subject")
	Optional<QuestionResponse> findBySubject(@Param("subject") String subject);
}
