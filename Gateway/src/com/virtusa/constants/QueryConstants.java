package com.virtusa.constants;

public class QueryConstants {
	/*
	 * The below query is to retrieve the questions and corresponding
	 * people who asked that question from  Question_Master table
	 */
	public static final String TIMELINE_QUESTIONS="SELECT UP.NAME,UP.EMAIL,QUESTION,QM.QUESTIONID,NVL(count(AM.questionId),0) as ANSWER_COUNT\r\n" + 
			"FROM USERPROFILE UP INNER JOIN QUESTION_MASTER QM\r\n" + 
			"ON UP.EMAIL = QM.EMAIL\r\n" + 
			"left outer join answer_master AM \r\n" + 
			"on QM.questionid = AM.questionid\r\n" + 
			"WHERE QM.IS_DELETE=0\r\n" + 
			"group by QM.QUESTIONID,UP.NAME,UP.EMAIL,QUESTION\r\n" + 
			"ORDER BY QM.QUESTIONID DESC"; 
	
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
	 * Below query is used for delete the question
	 */
	public static final String DELETE_QUESTION = "UPDATE "+TableConstants.QUESTION_MASTER+" "
			+" SET "+TableConstants.IS_DELETE+"=? WHERE "+TableConstants.QUESTION_Id+"=?";
	/*
	 * Below query is used for edit the question
	 */
	public static final String EDIT_QUESTION =  "UPDATE "+TableConstants.QUESTION_MASTER+" "
			+" SET "+TableConstants.QUESTION+"=? WHERE "+TableConstants.QUESTION_Id+"=?";
	/*
	 * Below query is used for insert the Answer
	 */
	public static final String INSERT_ANSWER = "INSERT INTO "+TableConstants.ANSWER_MASTER+"("+TableConstants.ANSWER+","
			+TableConstants.ANSWER_MASTER_QUESTION_Id+","+TableConstants.ANSWER_MASTER_EMAIL+")VALUES(?,?,?)";
	
	/*
	 * The below query is used for check answer already exists
	 */
	public static final String CHECK_ANSWER ="SELECT "+TableConstants.ANSWER+" FROM "+TableConstants.ANSWER_MASTER
			+" WHERE "+TableConstants.ANSWER_MASTER_EMAIL+"=? AND "+TableConstants.ANSWER_MASTER_QUESTION_Id+"=?";
	
	/*
	 * The below query is for updating the answer
	 */
	public static final String UPDATE_ANSWER = "UPDATE "+TableConstants.ANSWER_MASTER+" SET "+TableConstants.ANSWER+"=? "
			+ " WHERE "+TableConstants.ANSWER_MASTER_QUESTION_Id+"=? AND "+TableConstants.ANSWER_MASTER_EMAIL+"=?";
	/*
	 * View Answer
	 */
	public static final String VIEW_ANSWER = "select "
			+ " UP.name,AM.email,am.questionid,am.answerid,answer from question_master QM inner join Answer_master AM \r\n" + 
			"on qm.questionid = am.questionid  inner join userprofile UP on Am.email = up.email\r\n" + 
			"where qm.is_delete =0 and am.is_delete=0 and am.questionid=?";
}
