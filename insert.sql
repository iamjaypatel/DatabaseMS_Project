-- sample data (must have at least 3 stores, 20 customers, 50 purchases)

-- STORES INSERTS
INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Starbucks', '4022 Fifth Ave', 'Coffee', '37.3', '20.8');

INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Crazy Mohca', '207 Oakland Ave', 'Coffee', '22.20', '45.01');

INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Arriviste Coffee Bar', '5730 Ellsworth Ave', 'Coffee', '80.23', '85.85');

-- MEMBER LEVEL INSERTS
INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Regular', .35);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Gold', .70);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Platinum', 1.10);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Diamond', 1.89);


-- CUSTOMERS INSERTS
INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Jerimiah', 'Heath', 'HJ234@coffee.com', 1, 10);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Weston', 'Riggs', 'RW543@coffee.com', 2, 30);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Cyrus', 'Rangel', 'RC264@coffee.com', 3, 45);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Alberto', 'Hansen', 'HA121@coffee.com', 4, 90);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Roberto', 'Mooney', 'MR980@coffee.com', 1, 34);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Lucy', 'Mcclain', 'ML324@coffee.com', 3, 45);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Leah', 'Roberson', 'RL567@coffee.com', 2, 67);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Jorge', 'Frank', 'FJ890@coffee.com', 4, 34);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Hanna', 'Belvins', 'BH012@coffee.com', 3, 23);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'India', 'Byrd', 'BI345@coffee.com', 4, 56);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Danika', 'Robbins', 'RD678@coffee.com', 1, 43);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Urijah', 'Ochoa', 'OU901@coffee.com', 1, 31);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Emely', 'Carney', 'CE258@coffee.com', 2, 29);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Rene', 'Fletcher', 'FR369@coffee.com', 3, 89);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Janiya', 'Terrell', 'TJ401@coffee.com', 1, 72);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Allen', 'Hood', 'HA803@coffee.com', 2, 74);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Luna', 'Martin', 'ML712@coffee.com', 1, 26);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Simon', 'Lucero', 'LS306@coffee.com', 2, 98);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Edith', 'Rollins', 'RE603@coffee.com', 4, 97);

INSERT INTO boutique_coffee.customer(customer_id, first_name, last_name, email, memberlevel_id, total_points)
VALUES (DEFAULT, 'Kyler', 'Gilbert', 'GK161@coffee.com', 3, 21);

-- PURCHASES
INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 1, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 2, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 3, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 4, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 5, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 6, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 7, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 8, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 9, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 10, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 11, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 12, 2, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 13, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 14, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 15, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 16, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 17, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 18, 3, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 19, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 20, 1, '06/30/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 1, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 2, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 3, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 4, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 5, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 6, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 7, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 8, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 9, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 10, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 11, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 12, 3, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 13, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 14, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 15, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 16, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 17, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 18, 1, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 19, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 20, 2, '07/01/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 1, 3, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 2, 3, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 3, 3, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 8, 1, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 9, 1, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 10, 1, '07/02/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 13, 2, '07/03/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 14, 2, '07/03/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 19, 3, '07/03/2019');

INSERT INTO boutique_coffee.purchase(purchase_id, customer_id, store_id, purchase_time)
VALUES (DEFAULT, 20, 3, '07/03/2019');
