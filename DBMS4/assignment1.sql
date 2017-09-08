/*===========================================================================================
Author: Vaishali Jain
Description: Assignment 1
=============================================================================================*/

/*Use database Library_Information_System*/
USE Library_Information_System;

/*SELECT command to display name of those members who belong to the category as to which member
“Jon Snow” belongs.*/
SELECT member_name
FROM Members
WHERE category=(SELECT category FROM Members WHERE member_name= "Jon Snow");

/*SELECT command to display information on the books that have not been returned till date. 
The information should include book issue date, title, member name and due date.*/
SELECT BI.issue_date,T.title_name,M.member_name,BI.due_date
FROM Book_issue BI
JOIN  Members M ON BI.member_id=M.member_id
JOIN Books B ON BI.accession_no=B.accession_no
JOIN Titles T ON B.title_id=T.title_id
WHERE BI.accession_no NOT IN(SELECT accession_no FROM Book_return BR WHERE BI.issue_date= BR.issue_date 
                        AND BI.accession_no=BR.accession_no AND BI.member_id=BR.member_id);
                        


/* SELECT command to display information on the books that have been returned after their 
due dates. The information should include book issue date, title, member name and due date.*/

SELECT BI.issue_date,T.title_name,M.member_name,BI.due_date
FROM Book_issue BI
JOIN  Members M ON BI.member_id=M.member_id
JOIN Books B ON BI.accession_no=B.accession_no
JOIN Titles T ON B.title_id=T.title_id
WHERE BI.due_date < (SELECT BR.return_date FROM Book_return BR WHERE BI.issue_date= BR.issue_date 
                    AND BI.accession_no=BR.accession_no AND BI.member_id=BR.member_id);
                    
/*SELECT command to display information of those books whose price is equal to the most expensive
book purchased so far.*/
SELECT B.accession_no,B.title_id,T.title_name,B.purchase_date,B.price,B.status
FROM Books B
JOIN Titles T ON B.title_id=T.title_id
WHERE B.price=(SELECT MAX(price) FROM Books);

/*SELECT command to display the second maximum price of a book.*/
SELECT MAX(B.price)
FROM Books B
WHERE B.price NOT IN(SELECT MAX(price) FROM Books);


                    
                  