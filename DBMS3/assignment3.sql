/*=================================================================================================
Author : Vaishali Jain
Description:Assignment 3
==================================================================================================*/

/*Use database Library_Information_System*/
USE Library_Information_System;

/*Information of those titles that has been issued for more than two times*/
SELECT  Titles.title_id,Titles.title_name
FROM Titles,book_issue B,books
WHERE books.title_id=Titles.title_id AND B.accession_no=books.accession_no
GROUP BY B.accession_no
HAVING COUNT(B.accession_no)>=2;

/*To display total number of Faculty ,total number of students and others in single row */
SELECT (SELECT COUNT(*) FROM Members WHERE category="Faculty") AS TOTALFACULTY,
        (SELECT COUNT(*)  FROM Members WHERE category="Students") AS TOTALSTUDENTS,
        (SELECT COUNT(*) FROM Members WHERE category!="Faculty" AND category!="Member") AS OTHERS;
        
/* To display information on books issued to members of category other than "F"  */
SELECT M.member_id,M.member_name,M.category,BI.accession_no
FROM Members M,Books B,Book_issue BI
WHERE M.member_id=BI.member_id AND B.accession_no=BI.accession_no AND M.category != "Faculty";

/* To display information for that authors for which at least one book has been purchased */
SELECT A.author_id,A.author_name
FROM Authors A,Title_Author T,books B
WHERE a.author_id=T.author_id AND T.title_id=B.title_id AND T.title_id IN(Select title_id FROM Books);