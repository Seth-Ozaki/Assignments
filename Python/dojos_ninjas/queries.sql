-- Forward engineer the dojos_ninjas ERD

-- Create a .txt file where you'll save each of your queries from below

-- Query: Create 3 new dojos

-- Query: Delete the 3 dojos you just created

-- Query: Create 3 more dojos

-- Query: Create 3 ninjas that belong to the first dojo

-- Query: Create 3 ninjas that belong to the second dojo

-- Query: Create 3 ninjas that belong to the third dojo

-- Query: Retrieve all the ninjas from the first dojo

-- Query: Retrieve all the ninjas from the last dojo

-- Query: Retrieve the last ninja's dojo

-- Query: Use a JOIN to retrieve the ninja with id 6 as well as the data from its dojo. 
-- Be sure to do this in one query using a join statement.

-- Query: Use a JOIN to retrieve all the ninjas as well as that ninja's dojo, 
-- note, you will see repeated data on dojos as a dojo can have many ninjas!

USE dojo_ninjas;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM ninjas WHERE id IS NOT NULL;
DELETE FROM dojos WHERE id IS NOT NULL;

INSERT INTO dojos (id, name)
VALUES (1, 'dojo1'), (2, 'dojo2'), (3, 'dojo3');

SELECT *
FROM dojos;

-- ---------------------------------------------

DELETE FROM dojos WHERE id IS NOT NULL;

SELECT *
FROM dojos;

INSERT INTO dojos (id, name)
VALUES (1, 'dojo1_again'), (2, 'dojo2_again'), (3, 'dojo3_again');

SELECT * 
FROM dojos;

-- ---------------------------------------------


INSERT INTO ninjas (id, first_name, last_name, age, dojo_id)
VALUES (1, 'Ninja', '1', 12, 1), (2, 'Ninja', '2', 12, 1), (3, 'Ninja', '3', 12, 1);

INSERT INTO ninjas (id, first_name, last_name, age, dojo_id)
VALUES (4, 'Ninja', '4', 15, 2), (5, 'Ninja', '5', 15, 2), (6, 'Ninja', '6', 15, 2);

INSERT INTO ninjas (id, first_name, last_name, age, dojo_id)
VALUES (7, 'Ninja', '7', 18, 3), (8, 'Ninja', '8', 18, 3), (9, 'Ninja', '9', 18, 3);

SELECT *
FROM ninjas;

-- ---------------------------------------------

-- SELECT *
-- FROM ninjas 
-- WHERE dojo_id = 1;

-- ---------------------------------------------

-- SELECT *
-- FROM ninjas
-- WHERE dojo_id=3;

-- ---------------------------------------------

-- SELECT dojo_id
-- FROM ninjas 
-- ORDER BY id DESC
-- LIMIT 1;

-- ---------------------------------------------

-- SELECT * 
-- FROM ninjas
-- JOIN dojos ON dojos.id = ninjas.dojo_id
-- WHERE ninjas.id = 6;

-- ---------------------------------------------

-- SELECT * 
-- FROM ninjas
-- JOIN dojos ON dojos.id = ninjas.dojo_id;

