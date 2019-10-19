/*
Table Structure for Storing question in database
*/

CREATE TABLE QUESTION_MASTER(
	Email varchar(25)  REFERENCES UserProfile (Email),
	QuestionId int,
	Question VARCHAR(4000),
	is_delete int,
	CONSTRAINT PRIMARY_KEY_for_Question_Table PRIMARY KEY(QuestionId)	
);


--PROCEDURE FOR IDENTITY INSERT 
create or replace PROCEDURE Identity_QUESTION_MASTER
IS
BEGIN
	update QUESTION_MASTER set QUESTIONID=(select count(*) from QUESTION_MASTER) where QUESTIONID=0;
commit;
END;