CREATE DATABASE gestionPedidosCRUD

USE gestionPedidosCRUD

CREATE TABLE cliente(
		id int IDENTITY PRIMARY KEY NOT NULL,
		nombre varchar(35),
		apellido varchar(35),
		email varchar(45)
);

INSERT INTO cliente VALUES ('Juan','Castillejo','juanc01@gmail.com')