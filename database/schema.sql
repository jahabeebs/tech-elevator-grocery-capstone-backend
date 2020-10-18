BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS certification CASCADE;
DROP TABLE IF EXISTS certification_product;
DROP TABLE IF EXISTS category_product;
DROP SEQUENCE IF EXISTS seq_certification_id;
DROP SEQUENCE IF EXISTS seq_category_id;
DROP SEQUENCE IF EXISTS seq_brand_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

CREATE SEQUENCE seq_certification_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_category_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_brand_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE brand (
        brand_id int DEFAULT nextval('seq_brand_id'::regclass) NOT NULL,
        brand_name varchar(255) NOT NULL,
        CONSTRAINT pk_brand_id primary key (brand_id)
);

CREATE TABLE category (
        category_id int DEFAULT nextval('seq_category_id'::regclass) NOT NULL,
        category_name varchar(255) NOT NULL,
        CONSTRAINT pk_category_id primary key (category_id)
);

CREATE TABLE certification (
        certification_id int DEFAULT nextval('seq_certification_id'::regclass) NOT NULL,
        certification_name varchar(255) NOT NULL,
        CONSTRAINT pk_certification_id primary key (certification_id)
);

CREATE TABLE category_product (
        category_id int NOT NULL,
        product_id int NOT NULL,
        CONSTRAINT pk_category_product_category_id_product_id primary key (category_id, product_id),
        CONSTRAINT fk_category_id foreign key (category_id) references category (category_id)
);

CREATE TABLE certification_product (
        product_id int NOT NULL,
        certification_id int NOT NULL, 
        CONSTRAINT pk_certification_product_certification_id_product_id primary key (certification_id, product_id),
        CONSTRAINT fk_certification_id foreign key (certification_id) references certification (certification_id)
);

CREATE TABLE product (
        product_id int NOT NULL,
        title varchar(255) NOT NULL,
        category_id int NOT NULL,
        brand_id int NOT NULL,
        details varchar(255),
        image varchar(255),
        price decimal NOT NULL,
        weight decimal NOT NULL,
        sale boolean,
        CONSTRAINT pk_product primary key (product_id),
        CONSTRAINT fk_brand_id foreign key (brand_id) references brand (brand_id),
        CONSTRAINT fk_category_id foreign key (category_id) references category (category_id)
);

ALTER TABLE certification_product add foreign key (product_id) references product (product_id);
ALTER TABLE category_product add foreign key (product_id) references product (product_id);

COMMIT TRANSACTION;
