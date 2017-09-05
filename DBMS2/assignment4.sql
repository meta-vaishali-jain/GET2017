/*=============================================================================
Author-Vaishali Jain
Description: State and city details with each city Zip code which is acting as a 
             primary key.
===============================================================================*/

/*Create databse city_details*/
CREATE DATABASE City_Details;

/*Use database city_details*/
USE City_Details;

/*Create table state*/
CREATE TABLE State(
state_id INT ,
state_name VARCHAR(15),
PRIMARY KEY(state_id)
);

/*Create table city*/
CREATE TABLE City(
zip_code INT,
city_name VARCHAR(15),
state_id INT,
PRIMARY KEY(zip_code),
FOREIGN KEY fk_state_id(state_id) REFERENCES State(state_id)
);

/* Insert data into table state*/
INSERT INTO State(state_id,state_name) VALUES(1,"Rajasthan");
INSERT INTO State(state_id,state_name) VALUES(2,"Bihar");
INSERT INTO State(state_id,state_name) VALUES(3,"Gujrat");
INSERT INTO State(state_id,state_name) VALUES(4,"Madhya Pradesh");
INSERT INTO State(state_id,state_name) VALUES(5,"Goa");
INSERT INTO State(state_id,state_name) VALUES(6,"Andhra Pradesh");
INSERT INTO State(state_id,state_name) VALUES(7,"Maharashtra");

/*Insert data into table city*/
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(302001,"Jaipur",1);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(312001,"Chittorgarh",1);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(403001,"Panjim",5);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(400001,"Mumbai",7);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(320008,"Ahemdabad",3);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(425001,"Indore",4);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(800001,"Patna",2);
INSERT INTO CITY(zip_code,city_name,state_id) VALUES(517101,"Tirupati",6);

/*SQL query for that returns a Resultset containing Zip Code, City Names and States 
ordered by State Name and City Name.*/
SELECT zip_code,city_name,state_name
FROM City C
INNER JOIN State S ON C.state_id = S.state_id
ORDER BY S.state_name,C.city_name;




