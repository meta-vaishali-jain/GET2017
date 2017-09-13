CREATE DATABASE Lib_Information_System;

USE Lib_Information_System;

CREATE TABLE Authors(
author_id INT NOT NULL AUTO_INCREMENT,
author_name VARCHAR(20) NOT NULL,
PRIMARY KEY(author_id));

CREATE TABLE Publishers(
publisher_id INT NOT NULL AUTO_INCREMENT,
publisher_name VARCHAR(20) NOT NULL,
PRIMARY KEY(publisher_id));

CREATE TABLE Subjects(
subject_id INT NOT NULL AUTO_INCREMENT,
subject_name VARCHAR(20) NOT NULL,
PRIMARY KEY(subject_id));

CREATE TABLE Members(
member_id INT NOT NULL AUTO_INCREMENT,
member_name VARCHAR(20) NOT NULL,
address_line_one VARCHAR(40) NOT NULL,
address_line_two VARCHAR(40),
category VARCHAR(10) NOT NULL,
PRIMARY KEY(member_id));

CREATE TABLE Titles(
title_id INT AUTO_INCREMENT,
title_name VARCHAR(20) NOT NULL,
subject_id INT,
publisher_id INT,
PRIMARY KEY(title_id),
FOREIGN KEY(subject_id) REFERENCES Subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(publisher_id) REFERENCES Publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
FOREIGN KEY(title_id) REFERENCES Titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(author_id) REFERENCES Authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Books(
accession_no INT,
title_id INT,
purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
price DOUBLE NOT NULL,
status VARCHAR(20) NOT NULL,
PRIMARY KEY(accession_no),
FOREIGN KEY(title_id) REFERENCES Titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Book_issue(
issue_date TIMESTAMP,
accession_no INT,
member_id INT,
due_date TIMESTAMP,
PRIMARY KEY(issue_date ,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES Books(accession_no) ,
FOREIGN KEY(member_id) REFERENCES Members(member_id) 
);

CREATE TABLE Book_return(
return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
accession_no INT,
member_id INT,
issue_date TIMESTAMP,
PRIMARY KEY(return_date,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES Books(accession_no),
FOREIGN KEY(member_id) REFERENCES Members(member_id) ,
FOREIGN KEY(issue_date) REFERENCES Book_issue(issue_date) 
);


DELIMITER $$

CREATE TRIGGER dt_15days

BEFORE INSERT ON `book_issue` FOR EACH ROW

BEGIN

  SET NEW.due_date = now() + INTERVAL 15 DAY;

END;

$$

DELIMITER ;

ALTER TABLE Book_issue
MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

INSERT INTO Authors(author_name) values ("Vaishali");
INSERT INTO Authors(author_name) values ("Naina");
INSERT INTO Authors(author_name) values ("Abc");

SELECT * FROM Authors;

INSERT INTO Subjects(subject_name) values ("C++");
INSERT INTO Subjects(subject_name) values ("Java");

SELECT * FROM Subjects;

INSERT INTO Publishers(publisher_name) values ("New Moon Books");
INSERT INTO Publishers(publisher_name) values ("Scootney Books");

SELECT * FROM Publishers;

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

INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US C++",1,2);

INSERT INTO Titles(title_name,subject_id,publisher_id)
VALUES
("LET US JAVA",2,1);

SELECT * FROM Titles;

INSERT INTO Title_author(title_id,author_id)
VALUES
(1,1);

INSERT INTO Title_author(title_id,author_id)
VALUES
(2,2);

SELECT * FROM Title_Author;

INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(123,1,200.00,"Available");

INSERT  INTO Books(accession_no,title_id,price,status)
VALUES
(456,2,450.00,"Not-Available");

SELECT * FROM Books;

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

INSERT INTO Book_return(accession_no,member_id,issue_date)
VALUES
(123,1,(SELECT issue_date FROM Book_issue WHERE accession_no=123 AND member_id=1));

INSERT INTO Book_return(accession_no,member_id,issue_date)
VALUES
(123,2,(SELECT issue_date FROM Book_issue WHERE accession_no=123 AND member_id=2));

SELECT * FROM Book_return;



SELECT BI.accession_no,M.member_name,BI.issue_date
FROM Book_Issue AS BI
JOIN Books AS B ON BI.accession_no=B.accession_no
JOIN Titles AS T ON T.title_id=B.title_id
JOIN Members AS M ON M.member_id=BI.member_id
WHERE T.title_name="Let us c++";


