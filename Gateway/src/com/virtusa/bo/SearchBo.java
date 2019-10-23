package com.virtusa.bo;

public class SearchBo {
	private String name;
	private String email;
	private String question;
	private int questionId;
	private String[] searchValues;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getSearchValues() {
		return searchValues;
	}

	public void setSearchValues(String[] searchValues) {
		this.searchValues = searchValues;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}
