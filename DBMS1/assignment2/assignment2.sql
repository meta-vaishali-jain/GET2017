/* <=======================================================================================================
-Author:<Vaishali Jain>
-Description: Create database library information system and creates different table in it with constraints 
			  and perform some operation on it
===========================================================================================================>*/
/*<=========================================================================================================
Question 1
============================================================================================================>*/
/* Create database Library_Information_System*/
CREATE DATABASE Library_Information_System;
/* Use Library_Information_System database to work */
USE Library_Information_System;

/*Create table authors*/
CREATE TABLE Authors(
author_id INT NOT NULL AUTO_INCREMENT,
author_name VARCHAR(20) NOT NULL,
PRIMARY KEY(author_id));

/*create command to create table Publishers*/
CREATE TABLE Publishers(
publisher_id INT NOT NULL AUTO_INCREMENT,
publisher_name VARCHAR(20) NOT NULL,
PRIMARY KEY(publisher_id));

/* create command to create table subject*/
CREATE TABLE Subjects(
subject_id INT NOT NULL AUTO_INCREMENT,
subject_name VARCHAR(20) NOT NULL,
PRIMARY KEY(subject_id));

/*create command to create table Members*/
CREATE TABLE Members(
member_id INT NOT NULL AUTO_INCREMENT,
member_name VARCHAR(20) NOT NULL,
address_line_one VARCHAR(40) NOT NULL,
address_line_two VARCHAR(40),
category VARCHAR(10) NOT NULL,
PRIMARY KEY(member_id));

/*create command to create table Titles*/
CREATE TABLE Titles(
title_id INT AUTO_INCREMENT,
title_name VARCHAR(20) NOT NULL,
subject_id INT,
publisher_id INT,
PRIMARY KEY(title_id),
FOREIGN KEY(subject_id) REFERENCES Subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(publisher_id) REFERENCES Publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*create command to create table Title_author*/
CREATE TABLE Title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
FOREIGN KEY(title_id) REFERENCES Titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(author_id) REFERENCES Authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/*create command to create table Books*/
CREATE TABLE Books(
accession_no INT,
title_id INT,
purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
price DOUBLE NOT NULL,
status VARCHAR(20) NOT NULL,
PRIMARY KEY(accession_no),
FOREIGN KEY(title_id) REFERENCES Titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/* create command to create table Book_issue*/
CREATE TABLE Book_issue(
issue_date TIMESTAMP,
accession_no INT,
member_id INT,
due_date TIMESTAMP,
PRIMARY KEY(issue_date ,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES Books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(member_id) REFERENCES Members(member_id) ON DELETE CASCADE ON UPDATE CASCADE
);

/* create command to create table Book_return*/
CREATE TABLE Book_return(
return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
accession_no INT,
member_id INT,
issue_date TIMESTAMP,
PRIMARY KEY(return_date,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES Books(accession_no),
FOREIGN KEY(member_id) REFERENCES Members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(issue_date) REFERENCES Book_issue(issue_date) ON DELETE CASCADE ON UPDATE CASCADE
);

/*<=========================================================================================================
Question 2
============================================================================================================>*/
SHOW TABLES;

/*<=========================================================================================================
Question 3
============================================================================================================>*/

/*Trigger to set the due date of the table of book_issue to 15 days +issue date*/
DELIMITER $$

CREATE TRIGGER dt_15days

BEFORE INSERT ON `book_issue` FOR EACH ROW

BEGIN

  SET NEW.due_date = now() + INTERVAL 15 DAY;

END;

$$

DELIMITER ;

/* set issue_date attribute to current time*/
ALTER TABLE Book_issue
MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

/*<=========================================================================================================
Question 4
============================================================================================================>*/

/* Drop foreign key of member id from all tables before droping member table to avoid foreign key constraints*/
ALTER TABLE Book_return
DROP FOREIGN KEY book_return_ibfk_2 ;

ALTER TABLE Book_issue
DROP FOREIGN KEY book_issue_ibfk_2 ;

/* Drop table members*/
DROP TABLE Members;

/*<=========================================================================================================
Question 5
============================================================================================================>*/

/* To create Member table again*/
CREATE TABLE Members(
member_id INT NOT NULL AUTO_INCREMENT,
member_name VARCHAR(20) NOT NULL,
address_line_one VARCHAR(40) NOT NULL,
address_line_two VARCHAR(40),
category VARCHAR(10) NOT NULL,
PRIMARY KEY(member_id));

/* Again add foreign key constraint to the database*/
ALTER TABLE Book_return
ADD FOREIGN KEY(member_id) REFERENCES Members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Book_issue
ADD FOREIGN KEY(member_id) REFERENCES Members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;


