-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS courses_sales_v2;
CREATE DATABASE courses_sales_v2;
USE courses_sales_v2;

-- -----------------------------------------------------------------------------
-- - Construction des tables de l'application                       ---
-- -----------------------------------------------------------------------------

-- ----- FORMAT -----
CREATE TABLE format (
	id_format INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO format (name)
VALUES
('Présentiel'),
('Distanciel');

-- ----- COURSE -----
CREATE TABLE course (
	id_course INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255), 
	duration INT NOT NULL,
	price Double NOT NULL DEFAULT 0
) ENGINE = InnoDB;

INSERT INTO course (name, description, duration, price)
VALUES
('Java', 'Java SE 8 : Syntaxe & Poo', 20, 2500.00),
('Java avancé', 'Exceptions, fichiers, Jdbc, thread...', 20, 2200.00),
('Spring', 'Spring Core/Mvc/Security', 20, 2000.00),
('Php Frameworks', 'Symfony', 15, 1500.00),
('C#', 'DoteNet Core', 20, 2300.00);

-- ----- COURSE_FORMAT -----
CREATE TABLE course_format (
    id_course INT NOT NULL,
    id_format INT NOT NULL,

    PRIMARY KEY (id_course, id_format),

    FOREIGN KEY (id_course)
        REFERENCES course(id_course),

    FOREIGN KEY (id_format)
        REFERENCES format(id_format)
) ENGINE = InnoDB;


INSERT INTO course_format(id_course, id_format)
VALUES
(1,1),
(2,1), 
(3,1), 
(4,1), 
(5,1), 
(2,2), 
(4,2);

-- ----- BUYER -----
CREATE TABLE buyer (
    id_buyer INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

INSERT INTO buyer (name, login, password)
VALUES
('universite toulouse', 'univtou@exemple.fr', 'motDePasse');


-- ----- CUSTOMER -----
CREATE TABLE customer (
    id_customer INT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL, 
    phone VARCHAR(50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO customer (last_name, first_name, email, address, phone)
VALUES
('sabatier', 'paul', 'univpaulsabatier@exemple.fr', 'toulouse', '0552525252'),
('Dupont', 'Claire', 'claire.dupont@exemple.fr', 'Bayonne', '0559461234'),
('Martin', 'Julien', 'julien.martin@exemple.fr', 'Biarritz', '0559245678'),
('Davant', 'Marc', 'marc.davant@exemple.fr', 'Saint-Jean-de-Luz', '0559267890');

-- ----- ORDERS -----
CREATE TABLE orders (
    id_order INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    id_buyer INT NOT NULL,
    id_customer INT NOT NULL,
    FOREIGN KEY (id_buyer) REFERENCES buyer(id_buyer),
    FOREIGN KEY (id_customer) REFERENCES customer(id_customer)
) ENGINE = InnoDB;

INSERT INTO orders (date, id_buyer, id_customer)
VALUES
('2026-09-30', 1, 1),
('2026-09-30', 1, 2),
('2026-10-01', 1, 3),
('2026-10-02', 1, 4);


-- ----- ORDER_ITEM -----
CREATE TABLE order_item (
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    id_course INT NOT NULL,
    id_order INT NOT NULL,

    PRIMARY KEY (id_order, id_course),

    FOREIGN KEY (id_course) REFERENCES course(id_course),
    FOREIGN KEY (id_order) REFERENCES orders(id_order)
) ENGINE = InnoDB;

INSERT INTO order_item (quantity, price, id_course, id_order)
VALUES
(1, 2500.00, 1, 1),
(2, 2200.00, 2, 1),
(1, 2000.00, 3, 2),
(3, 1500.00, 4, 3),
(1, 2300.00, 5, 4);
