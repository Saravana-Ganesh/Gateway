package com.virtusa.constants;

public class QueryConstants {
	/*
	 * The below query is to retrieve the questions and corresponding
	 * people who asked that question from  Question_Master table
	 */
	public static final String TIMELINE_QUESTIONS="SELECT UP.NAME,UP.EMAIL,QUESTION,QUESTIONID FROM USERPROFILE UP INNER JOIN QUESTION_MASTER QM\r\n" + 
			"ON UP.EMAIL = QM.EMAIL\r\n" + 
			"ORDER BY QUESTIONID DESC"; 
	
	/*
	 * The below query is used for retrieve the search result data
	 */
	public static final String SEARCH_QUERY = "SELECT UP.NAME,UP.EMAIL,QUESTION,QUESTIONID FROM USERPROFILE UP\r\n" + 
			"			INNER JOIN QUESTION_MASTER QM\r\n" + 
			"			ON UP.EMAIL = QM.EMAIL\r\n" + 
			"            where \r\n" + 
			"		    upper(QUESTION) like upper(?)";

}
