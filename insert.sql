-- sample data (must have at least 3 stores, 20 customers, 50 purchases)

-- STORE TABLE
INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Starbucks', '4022 Fifth Ave', 'Coffee', '37.3', '20.8');

INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Dunkin', '3907 Forbes Ave', 'Coffee', '22.20', '45.01');

INSERT INTO boutique_coffee.Store (Store_ID, Name, Address, Store_Type, GPS_Long, GPS_Lat)
VALUES (DEFAULT, 'Crazy Mocha', '207 Oakland Ave', 'Coffee', '80.23', '85.85');

-- MEMBER LEVEL TABLE
INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Regular', .35);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Gold', .70);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Platinum', 1.10);

INSERT INTO boutique_coffee.memberlevel(memberlevel_id, name, booster_factor)
VALUES (DEFAULT, 'Diamond', 1.89);


-- CUSTOMERS TABLE
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

-- PURCHASE TABLE
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

-- COFFEE TABLE
INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'Caffe Misto', 'Brewed Coffee w/Milk', 5, 3.95, 35, 50);

INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'Iced Coffee', 'Ice Brewed Coffee', 3, 4.95, 45, 60);

INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'OG. Blend Vanilla', 'Vanilla flavor', 5, 2.99, 20, 35);

INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'Dark Roast Mocha', 'Dark Roase w/ Mocha', 7, 4.99, 50, 65);

INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'Regular Coffee', 'Coffee Blend', 6, 5.49, 55, 70);

INSERT INTO boutique_coffee.coffee(coffee_id, name, description, intensity, price, reward_points, redeem_points)
VALUES (DEFAULT, 'Ice Coffee', 'Iced Coffee', 2, 3.49, 15, 30);

-- PROMOTION TABLE
INSERT INTO boutique_coffee.promotion(promotion_id, name, start_date, end_date)
VALUES (DEFAULT, 'Caffe Misto Deal', '06/01/2019', '07/20/2019');

INSERT INTO boutique_coffee.promotion(promotion_id, name, start_date, end_date)
VALUES (DEFAULT, 'DR Mocha Deal', '06/10/2019', '07/25/2019');

INSERT INTO boutique_coffee.promotion(promotion_id, name, start_date, end_date)
VALUES (DEFAULT, 'Ice Coffee Deal', '06/25/2019', '07/25/2019');

-- OFFER COFFEE TABLE
INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (1, 1);

INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (1, 2);

INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (2, 3);

INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (2, 4);

INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (3, 5);

INSERT INTO boutique_coffee.offercoffee(store_id, coffee_id)
VALUES (3, 6);

-- HAS PROMOTION TABLE
INSERT INTO boutique_coffee.haspromotion(store_id, promotion_id)
VALUES (1, 1);

INSERT INTO boutique_coffee.haspromotion(store_id, promotion_id)
VALUES (2, 2);

INSERT INTO boutique_coffee.haspromotion(store_id, promotion_id)
VALUES (3, 3);

-- PROMOTE FOR TABLE
INSERT INTO boutique_coffee.promotefor(promotion_id, coffee_id)
VALUES (1, 1);

INSERT INTO boutique_coffee.promotefor(promotion_id, coffee_id)
VALUES (2, 4);

INSERT INTO boutique_coffee.promotefor(promotion_id, coffee_id)
VALUES (3, 6);

-- BUY COFFEE TABLE
INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (1, 1, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (2, 2, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (3, 1, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (4, 2, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (5, 1, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (6, 2, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (7, 3, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (8, 4, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (9, 3, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (10, 4, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (11, 3, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (12, 4, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (13, 5, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (14, 6, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (15, 5, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (16, 6, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (17, 5, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (18, 6, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (19, 1, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (20, 2, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (21, 3, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (22, 4, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (23, 3, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (24, 4, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (25, 3, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (26, 4, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (27, 5, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (28, 6, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (29, 5, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (30, 6, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (31, 5, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (32, 6, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (33, 1, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (34, 2, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (35, 1, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (36, 2, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (37, 1, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (38, 1, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (39, 4, 6, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (40, 4, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (41, 5, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (42, 6, 3, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (43, 6, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (44, 1, 1, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (45, 2, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (46, 1, 5, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (47, 4, 6, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (48, 3, 4, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (49, 6, 2, 1);

INSERT INTO boutique_coffee.buycoffee(purchase_id, coffee_id, purchase_quantity, redeem_quantity)
VALUES (50, 6, 3, 1);
