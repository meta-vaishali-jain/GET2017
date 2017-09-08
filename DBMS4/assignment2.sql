/*===========================================================================================
Author: Vaishali Jain
Description: Assignment 2
=============================================================================================*/

/*Use database Library_Information_System*/
USE Library_Information_System;

/*Create a View which can be used to display member name and all issue details of the member 
using a simple SELECT command.*/
CREATE VIEW member_issue_details
AS
SELECT M.member_name,BI.issue_date,BI.accession_no,BI.due_date
FROM Members M
LEFT JOIN Book_issue BI ON M.member_id=BI.member_id;


SELECT *
FROM member_issue_details;

/*Create a View which contains three columns, member name, member id and full description of 
category, i.e., Faculty, Students and Others instead of F,S and O.*/
CREATE VIEW member_details
AS
SELECT M.member_id,M.member_name,IF(M.category='F',"FACULTY",IF(M.category='S',"STUDENT","OTHERS")) AS Category
FROM Members M;

SELECT *
FROM member_details;

/*Create a View which contains the information – subject name, title, member name, category, issue 
date, due date and return date. If the books have not been returned, NULL should be displayed 
instead of return date.*/

CREATE VIEW book_issue_details
AS
SELECT S.subject_name,T.title_name,M.category,BI.issue_date,BI.due_date,BR.return_date
FROM Subjects S
JOIN Titles T ON S.subject_id=T.subject_id
JOIN Books B ON B.title_id=T.title_id
JOIN Book_issue BI ON BI.accession_no=B.accession_no
JOIN Members M ON BI.member_id= M.member_id
LEFT JOIN Book_return BR ON BI.accession_no=BR.accession_no;

SELECT *
FROM book_issue_details;







