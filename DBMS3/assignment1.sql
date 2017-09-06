/*=================================================================================================
Author : Vaishali Jain
Description:ASsignment 1
==================================================================================================*/

/*Use database Library_Information_System*/
USE Library_Information_System;

/*Command to display information on books issued for more than two months*/ 
SELECT M.member_name ,M.member_id,T.title_name,B.accession_no,BI.issue_date,BI.due_date, TIMESTAMPDIFF(MONTH,bi.issue_date,IFNULL(BR.return_date,now())) AS Months
FROM book_issue  BI 
JOIN books  B ON BI.accession_no= B.accession_no 
JOIN titles T ON B.title_id=T.title_id
JOIN members M ON BI.member_id = M.member_id
LEFT JOIN book_return BR ON BI.accession_no=BR.accession_no AND BI.member_id=BR.member_id AND BI.issue_date=BR.issue_date
WHERE  TIMESTAMPDIFF(MONTH,BI.issue_date,IFNULL(BR.return_date,now()))>=2
ORDER BY member_name,title_name;

/* Command to display those rows having maximum length for member name */
SELECT member_name,LENGTH(member_name)
FROM Members
WHERE LENGTH(member_name)=(SELECT MAX(LENGTH(member_name)) FROM Members);

/* Command to display  total number of books issued so far */
SELECT COUNT(DISTINCT issue_date,accession_no,member_id) AS NUMBEROFBOOKSISSUED
FROM Book_issue;

















        
        
