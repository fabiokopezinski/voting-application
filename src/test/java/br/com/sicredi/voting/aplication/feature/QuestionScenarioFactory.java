package br.com.sicredi.voting.aplication.feature;

import br.com.sicredi.voting.aplication.v1.domain.Question;
import br.com.sicredi.voting.aplication.v1.domain.dto.request.QuestionRequest;
import br.com.sicredi.voting.aplication.v1.domain.dto.response.QuestionResponse;

public class QuestionScenarioFactory {

	public static final Question QUESTION=loadQuestion();
	public static final Question QUESTION_NEW=loadQuestionNew();
	public static final Question QUESTION_GET=loadQuestionGet();
	public static final Question QUESTION_BUILDER=loadQuestionBuilder();
	public static final Question QUESTION_OF=loadQuestionOf();
	public static final QuestionResponse QUESTION_TODTO=loadQuestionToDto();
	public static final QuestionRequest QUESTION_REQUEST=loadQuestionRequest();
	public static final QuestionResponse QUESTION_RESPONSE=loadQuestionResponse();
	
	private static Question loadQuestion() {
		return new Question(1L, "TESTE");
	}

	private static QuestionResponse loadQuestionResponse() {
		return QuestionResponse.builder()
				.questionId(1L)
				.subject("TESTE")
				.build();
	}

	private static QuestionRequest loadQuestionRequest() {
		return QuestionRequest.builder()
				.subject("TESTE")
				.build();
	}

	private static QuestionResponse loadQuestionToDto() {
		Question question=new Question();
		return question.toDTO();
	}
	

	private static Question loadQuestionOf() {
		return Question.of(loadQuestionRequest());
	}

	private static Question loadQuestionBuilder() {
		return Question.builder()
				.questionId(1L)
				.subject("TESTE")
				.build();
	}

	private static Question loadQuestionGet() {
		Question question=new Question();
		question.getQuestionId();
		question.getSubject();
		return question;
	}

	private static Question loadQuestionNew() {
		return new Question(1L,"TESTE");
	}

}

