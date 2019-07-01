CREATE SCHEMA dbProject;

CREATE TABLE dbProject.Store
(
    Store_ID   int primary key,
    Name       varchar2(20),
    Address    varchar2(20),
    Store_Type varchar2(20),
    GPS_Long   float,
    GPS_Lat    float
);

CREATE TABLE dbProject.Coffee
(
    Coffee_ID     int primary key,
    Name          varchar2(20),
    Description   varchar2(20),
    Intensity     int,
    Price         float,
    Reward_Points float,
    Redeem_Points float
);

CREATE TABLE dbProject.Promotion
(
    Promotion_ID int primary key,
    Name         varchar2(20),
    Start_Date   date,
    End_Date     date
);

CREATE TABLE dbProject.MemberLevel
(
    MemberLevel_ID int primary key,
    Name           varchar2(20),
    Booster_Factor float
);

CREATE TABLE dbProject.Customer
(

);

CREATE TABLE dbProject.Purchase
(

);

CREATE TABLE dbProject.OfferCoffee
(

);

CREATE TABLE dbProject.HasPromotion
(

);

CREATE TABLE dbProject.PromoteFor
(

);

CREATE TABLE dbProject.BuyCoffee
(

);