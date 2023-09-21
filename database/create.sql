-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-21 11:27:10.554

-- tables
-- Table: client
CREATE TABLE customer (
                        id serial  NOT NULL,
                        registration_code int  NOT NULL,
                        customer_full_name varchar(255)  NOT NULL,
                        email varchar(255)  NOT NULL,
                        phone_number varchar(20)  NOT NULL,
                        CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
                         id serial  NOT NULL,
                         order_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         customer_id int  NOT NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_line
CREATE TABLE order_line (
                            id serial  NOT NULL,
                            product_quantity int  NOT NULL,
                            order_id int  NOT NULL,
                            product_id int  NOT NULL,
                            CONSTRAINT order_line_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         product_name varchar(255)  NOT NULL,
                         sku_code varchar(8)  NOT NULL,
                         unit_price int  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: order_client (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_client
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_line_order (table: order_line)
ALTER TABLE order_line ADD CONSTRAINT order_line_order
    FOREIGN KEY (order_id)
        REFERENCES "order" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_line_product (table: order_line)
ALTER TABLE order_line ADD CONSTRAINT order_line_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

