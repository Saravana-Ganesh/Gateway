package com.virtusa.bo;

public class AnswerBo {
	private String questionId;
	private String AnswerId;
	private String name;
	private String email;
	private String answer;
	private String question;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String answerMasterQuestionId) {
		this.questionId = answerMasterQuestionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswerId() {
		return AnswerId;
	}

	public void setAnswerId(String answerMasterAnswerId) {
		AnswerId = answerMasterAnswerId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
