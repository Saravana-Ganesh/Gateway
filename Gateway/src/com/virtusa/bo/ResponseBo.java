package com.virtusa.bo;

import java.util.List;

public class ResponseBo {

	private String sessionEmail;
	private String sessionName;	
	private String recordName;
	private String status;
	private List<ViewQuestionBo> questionData;
	private List<SearchBo> searchData;
	private List<AnswerBo> AnswerData;
	private String answer;
	
	public String getSessionEmail() {
		return sessionEmail;
	}

	public void setSessionEmail(String sessionEmail) {
		this.sessionEmail = sessionEmail;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public List<ViewQuestionBo> getQuestionData() {
		return questionData;
	}

	public void setQuestionData(List<ViewQuestionBo> questionData) {
		this.questionData = questionData;
	}
	
	public void setSearchData(List<SearchBo> searchData) {
		this.searchData = searchData;
	}
	public List<SearchBo> getSearchData(){
		return searchData;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<AnswerBo> getAnswerData() {
		return AnswerData;
	}

	public void setAnswerData(List<AnswerBo> answerData) {
		AnswerData = answerData;
	}
}
