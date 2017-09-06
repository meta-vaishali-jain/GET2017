/*=================================================================================================
Author : Vaishali Jain
Description:ASsignment 2
==================================================================================================*/

/*Use database Library_Information_System*/
USE Library_Information_System;

/*Command to display subject wise information on number of books purchased */
SELECT S.subject_id,S.subject_name,COUNT(T.title_id) AS NUMBEROFBOOKS
FROM Subjects S
LEFT JOIN Titles T ON T.subject_id=S.subject_id
GROUP BY S.subject_id;

/* To display those rows where a book can be returned after two months */
SELECT * 
FROM Book_issue
WHERE TIMESTAMPDIFF(MONTH,issue_date,due_date)>2;

/* To display the list of books having price greater than the minimum price */
SELECT *
FROM Books
WHERE price>(SELECT MIN(price) FROM Books);
