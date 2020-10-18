BEGIN TRANSACTION;

UPDATE product SET image = 'https://i5.wal.co/asr/7b1d70df-149d-4ce9-a73b-d77318fb71e9.1552c8b49262ea2173c148a122ca8a1d.jpeg?odnWidth=undefined&odnHeight=undefined&odnBg=ffffff' WHERE product_id = 8;

ALTER TABLE product ADD inventory INT;

CREATE TABLE purchases (
product_id int NOT NULL,
item_quantity int NOT NULL,

FOREIGN KEY (product_id) REFERENCES product (product_id)
);


UPDATE product SET inventory = 30 WHERE product_id = 1;
UPDATE product SET inventory = 60 WHERE product_id = 2;
UPDATE product SET inventory = 40 WHERE product_id = 3;
UPDATE product SET inventory = 40 WHERE product_id = 4;
UPDATE product SET inventory = 40 WHERE product_id = 5;
UPDATE product SET inventory = 20 WHERE product_id = 6;
UPDATE product SET inventory = 40 WHERE product_id = 7;
UPDATE product SET inventory = 30 WHERE product_id = 8;
UPDATE product SET inventory = 30 WHERE product_id = 9;
UPDATE product SET inventory = 20 WHERE product_id = 10;
UPDATE product SET inventory = 30 WHERE product_id = 11;
UPDATE product SET inventory = 15 WHERE product_id = 12;
UPDATE product SET inventory = 30 WHERE product_id = 13;
UPDATE product SET inventory = 30 WHERE product_id = 14;
UPDATE product SET inventory = 10 WHERE product_id = 15;
UPDATE product SET inventory = 20 WHERE product_id = 16;
UPDATE product SET inventory = 20 WHERE product_id = 17;
UPDATE product SET inventory = 20 WHERE product_id = 18;
UPDATE product SET inventory = 20 WHERE product_id = 19;
UPDATE product SET inventory = 25 WHERE product_id = 20;
UPDATE product SET inventory = 25 WHERE product_id = 21;
UPDATE product SET inventory = 20 WHERE product_id = 22;
UPDATE product SET inventory = 25 WHERE product_id = 23;
UPDATE product SET inventory = 30 WHERE product_id = 24;
UPDATE product SET inventory = 80 WHERE product_id = 25;
UPDATE product SET inventory = 40 WHERE product_id = 26;
UPDATE product SET inventory = 20 WHERE product_id = 27;
UPDATE product SET inventory = 10 WHERE product_id = 28;
UPDATE product SET inventory = 30 WHERE product_id = 29;
UPDATE product SET inventory = 20 WHERE product_id = 30;
UPDATE product SET inventory = 60 WHERE product_id = 31;
UPDATE product SET inventory = 20 WHERE product_id = 32;
UPDATE product SET inventory = 20 WHERE product_id = 33;
UPDATE product SET inventory = 10 WHERE product_id = 34;
UPDATE product SET inventory = 20 WHERE product_id = 35;
UPDATE product SET inventory = 10 WHERE product_id = 36;
UPDATE product SET inventory = 30 WHERE product_id = 37;
UPDATE product SET inventory = 20 WHERE product_id = 38;
UPDATE product SET inventory = 20 WHERE product_id = 39;
UPDATE product SET inventory = 20 WHERE product_id = 40;
UPDATE product SET inventory = 20 WHERE product_id = 41;
UPDATE product SET inventory = 15 WHERE product_id = 42;
UPDATE product SET inventory = 60 WHERE product_id = 43;
UPDATE product SET inventory = 40 WHERE product_id = 44;
UPDATE product SET inventory = 60 WHERE product_id = 45;
UPDATE product SET inventory = 20 WHERE product_id = 46;
UPDATE product SET inventory = 20 WHERE product_id = 47;
UPDATE product SET inventory = 20 WHERE product_id = 48;
UPDATE product SET inventory = 20 WHERE product_id = 49;
UPDATE product SET inventory = 20 WHERE product_id = 50;
UPDATE product SET inventory = 20 WHERE product_id = 51;
UPDATE product SET inventory = 30 WHERE product_id = 52;
UPDATE product SET inventory = 10 WHERE product_id = 53;
UPDATE product SET inventory = 30 WHERE product_id = 54;
UPDATE product SET inventory = 80 WHERE product_id = 55;
UPDATE product SET inventory = 20 WHERE product_id = 56;
UPDATE product SET inventory = 20 WHERE product_id = 57;
UPDATE product SET inventory = 20 WHERE product_id = 58;
UPDATE product SET inventory = 20 WHERE product_id = 59;
UPDATE product SET inventory = 20 WHERE product_id = 60;
UPDATE product SET inventory = 20 WHERE product_id = 61;
UPDATE product SET inventory = 30 WHERE product_id = 62;
UPDATE product SET inventory = 60 WHERE product_id = 63;
UPDATE product SET inventory = 40 WHERE product_id = 64;
UPDATE product SET inventory = 50 WHERE product_id = 65;
UPDATE product SET inventory = 40 WHERE product_id = 66;
UPDATE product SET inventory = 40 WHERE product_id = 67;
UPDATE product SET inventory = 40 WHERE product_id = 68;
UPDATE product SET inventory = 30 WHERE product_id = 69;
UPDATE product SET inventory = 40 WHERE product_id = 70;


COMMIT TRANSACTION;