package br.com.sicredi.voting.aplication.v1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;
import br.com.sicredi.voting.aplication.v1.dto.request.QuestionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "questionId")
@Builder
@Table(name = "TB_PAUTA")
public class Question implements DomainEntity<QuestionResponse> {

	@Id
	@Column(name = "CD_PAUTA", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
	@SequenceGenerator(name = "question_seq", allocationSize = 1)
	private Long questionId;

	@Column(unique = true, name = "TEMA", length = 100, nullable = false)
	private String subject;
		
	public static Question of(QuestionRequest request) {
		return Question.builder().subject(request.getSubject()).build();
	}

	@Override
	public QuestionResponse toDTO() {
		return QuestionResponse.builder().questionId(this.questionId).subject(this.subject).build();
	}
}
