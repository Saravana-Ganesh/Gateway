--Model 1: Signup form backend structure
--Create table for signup page
CREATE TABLE UserProfile(
	Id int,
	Name VARCHAR(50)  NOT NULL,
	Email varchar(25),
	PhoneNumber number NOT NULL,
	CreatedDate date,
	CONSTRAINT PRIMARY_KEY PRIMARY KEY(Email)
	
);

--Alter for  signup page
Alter Table UserProfile Add CONSTRAINT IDENTITY_INSERT UNIQUE(Id);
alter table userprofile add  password varchar(50);


--Procedure...This will execueted by server automatically after inserting data in UserProfile table
create or replace PROCEDURE Identity_Insert_UserProfile 
IS
BEGIN
UPDATE UserProfile SET id =  (select count(email) from UserProfile) WHERE id is null;
--select to_char(sysdate,'DD/MM/YYYY HH24:MI:SS') from dual;
UPDATE UserProfile SET CREATEDDATE = (select CURRENT_DATE from dual) where CREATEDDATE is null;
commit;
END;