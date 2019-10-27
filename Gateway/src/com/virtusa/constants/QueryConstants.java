package com.virtusa.constants;

public class QueryConstants {
	/*
	 * The below query is to retrieve the questions and corresponding
	 * people who asked that question from  Question_Master table
	 */
	public static final String TIMELINE_QUESTIONS="SELECT UP.NAME,UP.EMAIL,QUESTION,QUESTIONID FROM USERPROFILE UP INNER JOIN QUESTION_MASTER QM\r\n" + 
			"ON UP.EMAIL = QM.EMAIL\r\n WHERE QM.IS_DELETE=0" + 
			"ORDER BY QUESTIONID DESC"; 
	
	/*
	 * The below query is used for retrieve the search result data
	 */
	public static final String SEARCH_QUERY = "SELECT UP.NAME,UP.EMAIL,QUESTION,QUESTIONID FROM USERPROFILE UP\r\n" + 
			"			INNER JOIN QUESTION_MASTER QM\r\n" + 
			"			ON UP.EMAIL = QM.EMAIL\r\n" + 
			"            where \r\n" + 
			"		    upper(QUESTION) like upper(?)"
			+ "         and QM.is_delete=0";
	/*
	 * Below query is used for delete the qusetion
	 */
	public static final String DELETE_QUESTION = "UPDATE "+TableConstants.QUESTION_MASTER+" "
			+" SET "+TableConstants.IS_DELETE+"=? WHERE "+TableConstants.QUESTION_Id+"=?";
	/*
	 * Below query is used for edit the qusetion
	 */
	public static final String EDIT_QUESTION =  "UPDATE "+TableConstants.QUESTION_MASTER+" "
			+" SET "+TableConstants.QUESTION+"=? WHERE "+TableConstants.QUESTION_Id+"=?";
}