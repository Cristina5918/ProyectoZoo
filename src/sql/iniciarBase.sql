use zoo;

create table usuario(
	id int not null AUTO_INCREMENT,
    nombre varchar(100),
    apellido varchar(100),
    edad int,
    rol  boolean,
    login varchar(100),
    password varchar(100),
    PRIMARY KEY(id)
);

create table animal(
	id int not null AUTO_INCREMENT,
    nombre varchar(100),
    ojos int,
    patas int,
    peligrosidad int,
    primary key(id)
);


INSERT INTO USUARIO(nombre,apellido,edad,rol,login,password)
VALUES ('admin','',99,1,'admin','admin');

INSERT INTO USUARIO(nombre,apellido,edad,rol,login,password)
VALUES ('cris','alonso',22,0,'cris','cris');


INSERT INTO ANIMAL(nombre,ojos,patas,peligrosidad)
VALUES('Leon',2,4,9);

INSERT INTO ANIMAL(nombre,ojos,patas,peligrosidad)
VALUES('Jirafa',2,4,4);

INSERT INTO ANIMAL(nombre,ojos,patas,peligrosidad)
VALUES('Loro',2,2,2);

INSERT INTO ANIMAL(nombre,ojos,patas,peligrosidad)
VALUES('Elefante',2,4,6);