/*=============================================================================
Author-Vaishali Jain
Description: Select Commands on Library_Information_System Database
===============================================================================*/


/* Select database Library_Information_System*/
USE Library_Information_System;

/*Select command to display all the columns of the members table*/
SELECT *
FROM Members;

/*Select command to display member_id,member_name,category columns of the members table*/
SELECT member_id,member_name,category
FROM Members;

/*Select command to display member_id,member_name,category columns of the members table
where category="F"*/
SELECT member_id,member_name,category
FROM Members
WHERE category="F";

/* Select command to display DISTINCT category in members table*/ 
SELECT DISTINCT category
FROM Members;

/* Select command to display member_name and category in descending order based on member_name*/
SELECT member_name,category
FROM Members
ORDER BY member_name DESC;

/*Select command to display all the titles their subject id and publisher id*/
SELECT title_name,subject_name,publisher_name
FROM Titles,Publishers,subjects
WHERE Titles.subject_id=subjects.subject_id AND TITLES.publisher_id=publishers.publisher_id;

/*Select command to display number of persons present in each category*/
SELECT category,COUNT(category)  
FROM members        
GROUP BY category;  

/*Select command to display name of those members who belongs to category to which Shreya belongs*/
SELECT E.member_name
FROM members as E 
LEFT JOIN members as F
ON E.category=F.category 
WHERE F.member_name="Shreya";

/*Select command to display name of those members who belongs to category to which "Keshav Sharma" belongs*/
SELECT E.member_name
FROM members as E 
LEFT JOIN members as F
ON E.category=F.category 
WHERE F.member_name="Keshav Sharma";

/*Select command to display info of all the books issued ,issue_date,accession_no,member_id,return_date*/
SELECT E.issue_date,E.accession_no,E.member_id,F.return_date
FROM book_issue as E
LEFT JOIN book_return as F
ON E.accession_no=F.accession_no AND E.member_id=F.member_id ;







