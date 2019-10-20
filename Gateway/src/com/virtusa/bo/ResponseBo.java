package com.virtusa.bo;

import java.util.List;

public class ResponseBo {

	private String sessionEmail;
	private String sessionName;	
	private String recordName;
	private String status;
	private List<ViewQuestionBo> questionData;
	private List<SearchBo> searchData;
	
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
}
