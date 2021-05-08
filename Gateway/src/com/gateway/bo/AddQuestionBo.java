package com.gateway.bo;

public class AddQuestionBo {
	private String question;
	private String session_email;
	
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion() {
		return question;
	}
	public String getSession_email() {
		return session_email;
	}
	public void setSession_email(String session_email) {
		this.session_email = session_email;
	}
}
