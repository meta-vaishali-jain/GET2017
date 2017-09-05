/*=============================================================================
Author-Vaishali Jain
Description: creation of databse of all the products details with their categories
===============================================================================*/

/*Create database containing product details*/
CREATE DATABASE Product_Details;

/* Use database product_details*/
USE Product_Details;

/* Create table category where parent_category_id references to category_id*/
CREATE TABLE Category(
category_id INT,
category_name VARCHAR(20),
parent_category_id INT,
PRIMARY KEY(category_id),
FOREIGN KEY fk_parent_category_id(parent_category_id) REFERENCES Category(category_id)
);

/*Insertion of data into table using txt file*/
LOAD DATA LOCAL INFILE 'C:\\Users\\user11\\Desktop\\details.txt.txt' INTO TABLE Category
FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n';

/*SQL query:to display all the categories along with its Parent category.*/
SELECT C.category_id,C.category_name,C.parent_category_id
FROM Category C;

/*SQL query:to display all the categories along with its Parent category.
Result should be sorted on Parent Category.*/
SELECT C.category_id,C.category_name,C.parent_category_id
FROM Category C
ORDER BY C.parent_category_id;

/*SQL query:to display all the categories along with its Parent category.
If category is top category then display “Top Category” in Parent category.*/ 
SELECT C.category_id,F.category_name,
IFNULL(F.category_name,"Top Category") as parentCategoryName
FROM Category C
LEFT JOIN Category F
ON C.parent_category_id=F.category_id;

/* SQL Query to display only top categories*/
SELECT category_id,category_name
FROM Category
WHERE ISNULL(parent_category_id);



