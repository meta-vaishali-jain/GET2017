/* <=======================================================================================================
-Author:<Vaishali Jain>
-Description: To perform INSERT ,DELETE and UPDATE commands on database
===========================================================================================================>*/
/*<=========================================================================================================
Question 1
============================================================================================================>*/

/* Use Library_Information_System*/
USE Library_Information_System;

/*insert data in authors table*/
INSERT INTO Authors(author_name) values ("Vaishali");
INSERT INTO Authors(author_name) values ("Naina");

SELECT * FROM Authors;

/* insert data in subjects table*/
INSERT INTO Subjects(subject_name) values ("C++");
INSERT INTO Subjects(subject_name) values ("Java");

SELECT * FROM Subjects;

/*insert data in publishers table */
INSERT INTO Publishers(publisher_name) values ("New Moon Books");
INSERT INTO Publishers(publisher_name) values ("Scootney Books");

SELECT * FROM Publishers;

/*insert data in members table*/
INSERT INTO Members(member_name,address_line_one,address_line_two,category) 
VALUES
("Shreya","Sanganer","Sanganer","F");

INSERT INTO Members(member_name,address_line_one,address_line_two,category) 
VALUES
("Anushtha","Mansarovar","","F");

INSERT INTO Members(member_name,address_line_one,address_line_two,category) 
VALUES
("Amit","abc","Bangalore","M");

SELECT * FROM Members;

/* insert data in title table*/
INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US C++",1,2);

INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US JAVA",2,1);

SELECT * FROM Titles;

/* insert data in Title_author table*/
INSERT INTO Title_author(title_id,author_id)
VALUES
(1,1);

INSERT INTO Title_author(title_id,author_id)
VALUES
(2,2);

SELECT * FROM Title_Author;

/*insert data into books table*/
INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(123,1,200.00,"Available");

INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(456,2,450.00,"Not-Available");

SELECT * FROM Books;

/*insert data into book_issue table*/
INSERT INTO Book_issue(accession_no,member_id)
VALUES
(123,2);

INSERT INTO Book_issue(accession_no,member_id)
VALUES
(123,1);

INSERT INTO Book_issue(accession_no,member_id)
VALUES
(456,3);

SELECT * FROM Book_issue;

/*insert data into book_return table*/
INSERT INTO Book_return(accession_no,member_id,issue_date)
VALUES
(123,1,(SELECT issue_date FROM Book_issue WHERE accession_no=123 AND member_id=1));

INSERT INTO Book_return(accession_no,member_id,issue_date)
VALUES
(123,2,(SELECT issue_date FROM Book_issue WHERE accession_no=123 AND member_id=2));

SELECT * FROM Book_return;

/*<=========================================================================================================
Question 2
============================================================================================================>*/

/*Change value of address_line_two column of Members table with “Jaipur”.*/

SET SQL_SAFE_UPDATES=0;
UPDATE Members
SET address_line_two="Jaipur";

SELECT * FROM Members;

/*<=========================================================================================================
Question 3
============================================================================================================>*/

/*Change value of address_line_one column of Members table with value “EPIP, Sitapura” for the members belonging to category “F”.*/

UPDATE Members
SET address_line_one="EPIP, Sitapura"
WHERE category="F";

SELECT * FROM Members;

ALTER TABLE book_return
DROP FOREIGN KEY book_return_ibfk_1;

ALTER TABLE book_return
DROP FOREIGN KEY book_return_ibfk_2;

/*<=========================================================================================================
Question 3
============================================================================================================>*/

/* To delete all rows from table publishers*/
DELETE FROM Publishers;

ALTER TABLE Books AUTO_INCREMENT = 1;

ALTER TABLE Publishers AUTO_INCREMENT = 1;

ALTER TABLE Titles AUTO_INCREMENT = 1;


/*<=========================================================================================================
Question 4
============================================================================================================>*/

/*Insert the sample data back in Publishers table using substitution variables.*/
SET @publisher_name="New Moon Books";
/*inserting back data in publishers table*/
INSERT INTO publishers(publisher_name)  VALUES (@publisher_name);

SET @publisher_name="Scootney Books";
/*inserting back data in publishers table*/
INSERT INTO publishers(publisher_name)  VALUES (@publisher_name);

/*Again insertion of data in all tables*/
INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US C++",1,2);

INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US JAVA",2,1);


INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(123,1,200.00,"Available");

INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(456,2,450.00,"Not-Available");


/*<=========================================================================================================
Question 5
============================================================================================================>*/

/*Delete those rows of Titles table belonging to Publisher with publisher_id = 1*/
DELETE FROM TITLES
WHERE publisher_id=1;

