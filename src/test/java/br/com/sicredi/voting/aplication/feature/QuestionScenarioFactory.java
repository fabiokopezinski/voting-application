package br.com.sicredi.voting.aplication.feature;

import br.com.sicredi.voting.aplication.v1.domain.Question;

public class QuestionScenarioFactory {

	public static final Question QUESTION=loadQuestion();
	public static final Question QUESTION_NEW=loadQuestionNew();
	public static final Question QUESTION_GET=loadQuestionGet();
	
	private static Question loadQuestion() {
		return new Question(1L, "TESTE");
	}

	private static Question loadQuestionGet() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Question loadQuestionNew() {
		return new Question(1L,"T");
	}

}

