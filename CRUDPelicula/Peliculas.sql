CREATE TABLE PELICULAS(
    ID NUMBER PRIMARY KEY,
    NOMBRE NVARCHAR2(50),
    ANIO_ESTRENO NUMBER,
    GENERO NVARCHAR2(50),
    DURACION NVARCHAR2(50)
);

INSERT INTO PELICULAS VALUES (1, 'Los juegos del hambre: Sinsajo', 2015, 'Accion', '2h 17m' );
INSERT INTO PELICULAS VALUES (2, 'Avengers: Infinity War', 2018, 'Accion', '2h 40m' );
INSERT INTO PELICULAS VALUES (3, 'Amor de media noche', 2018, 'Romance', '1h 34m' );
INSERT INTO PELICULAS VALUES (4, 'El gran showman', 2017, 'Musical', '1h 46m' );
INSERT INTO PELICULAS VALUES (5, 'Todos caen', 2019, 'Comedia', '2h 00m' );

SELECT * FROM PELICULAS;
COMMIT;