-- set up schema and tables for project
DROP TABLE boutique_coffee.BuyCoffee;
DROP TABLE boutique_coffee.PromoteFor;
DROP TABLE boutique_coffee.HasPromotion;
DROP TABLE boutique_coffee.OfferCoffee;
DROP TABLE boutique_coffee.Purchase;
DROP TABLE boutique_coffee.Customer;
DROP TABLE boutique_coffee.MemberLevel;
DROP TABLE boutique_coffee.Promotion;
DROP TABLE boutique_coffee.Coffee;
DROP TABLE boutique_coffee.Store;

DROP SCHEMA boutique_coffee;
CREATE SCHEMA boutique_coffee;

CREATE TABLE boutique_coffee.Store(
    Store_ID SERIAL NOT NULL PRIMARY KEY,
    Name VARCHAR(20),
    Address VARCHAR(20),
    Store_Type VARCHAR(20),
    GPS_Long FLOAT,
    GPS_Lat FLOAT
);

CREATE TABLE boutique_coffee.Coffee(
    Coffee_ID SERIAL NOT NULL PRIMARY KEY,
    Name VARCHAR(20),
    Description VARCHAR(20),
    Intensity INT,
    Price FLOAT,
    Reward_Points FLOAT,
    Redeem_Points FLOAT
);

CREATE TABLE boutique_coffee.Promotion(
    Promotion_ID SERIAL NOT NULL PRIMARY KEY,
    Name VARCHAR(20),
    Start_Date DATE,
    End_Date DATE
);

CREATE TABLE boutique_coffee.MemberLevel(
    MemberLevel_ID SERIAL NOT NULL PRIMARY KEY,
    Name VARCHAR(20),
    Booster_Factor FLOAT
);

CREATE TABLE boutique_coffee.Customer(
    Customer_ID SERIAL NOT NULL PRIMARY KEY,
    First_Name VARCHAR(20),
    Last_Name VARCHAR(20),
    Email VARCHAR(20),
    MemberLevel_ID INT NOT NULL,
    Total_Points FLOAT,
    FOREIGN KEY(MemberLevel_ID) REFERENCES boutique_coffee.MemberLevel
);

CREATE TABLE boutique_coffee.Purchase(
    Purchase_ID SERIAL NOT NULL PRIMARY KEY,
    Customer_ID INT NOT NULL,
    Store_ID INT NOT NULL,
    Purchase_Time Date,
    FOREIGN KEY (Customer_ID) REFERENCES boutique_coffee.Customer,
    FOREIGN KEY (Store_ID) REFERENCES boutique_coffee.Store
);

CREATE TABLE boutique_coffee.OfferCoffee(
    Store_ID INT NOT NULL,
    Coffee_ID INT NOT NULL,
    PRIMARY KEY (Store_ID, Coffee_ID),
    FOREIGN KEY (Store_ID) REFERENCES boutique_coffee.Store,
    FOREIGN KEY (Coffee_ID) REFERENCES boutique_coffee.Coffee
);

CREATE TABLE boutique_coffee.HasPromotion(
    Store_ID INT NOT NULL,
    Promotion_ID INT NOT NULL,
    PRIMARY KEY (Store_ID, Promotion_ID),
    FOREIGN KEY (Store_ID) REFERENCES boutique_coffee.Store,
    FOREIGN KEY (Promotion_ID) REFERENCES boutique_coffee.Promotion
);

CREATE  TABLE boutique_coffee.PromoteFor(
    Promotion_ID INT NOT NULL,
    Coffee_ID INT NOT NULL,
    PRIMARY KEY (Promotion_ID, Coffee_ID),
    FOREIGN KEY (Promotion_ID) REFERENCES boutique_coffee.Promotion,
    FOREIGN KEY (Coffee_ID) REFERENCES boutique_coffee.Coffee
);

CREATE TABLE boutique_coffee.BuyCoffee(
    Purchase_ID INT NOT NULL,
    Coffee_ID INT NOT NULL,
    Purchase_Quantity INT,
    Redeem_Quantity INT,
    PRIMARY KEY (Purchase_ID, Coffee_ID),
    FOREIGN KEY (Purchase_ID) REFERENCES boutique_coffee.Purchase,
    FOREIGN KEY (Coffee_ID) REFERENCES boutique_coffee.Coffee
);

