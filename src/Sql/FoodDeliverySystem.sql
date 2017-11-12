/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  caveon
 * Created: Nov 12, 2017
 */

CREATE TABLE ITEM(
Item_ID         VARCHAR(5) NOT NULL primary key,
ItemPrice       DOUBLE,
ItemName        VARCHAR(30),
ItemDescription VARCHAR(80),
ItemStatus      VARCHAR(1)
);

INSERT INTO ITEM VALUES ('I0001',3.50,'Signature Chicken Rice','Rice,Chicken Meat','Y')