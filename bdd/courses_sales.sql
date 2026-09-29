-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS courses_sales;
CREATE DATABASE courses_sales;
USE courses_sales;

-- -----------------------------------------------------------------------------
-- - Construction des tables de l'application                       ---
-- -----------------------------------------------------------------------------
CREATE TABLE format (
	id_format INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE = InnoDB;

INSERT INTO format (name)
VALUES
('Présentiel'),
('Distanciel');


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
(4,2)

