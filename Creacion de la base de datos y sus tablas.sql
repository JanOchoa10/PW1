CREATE DATABASE IF NOT EXISTS BD_PostCat;
use BD_PostCat;

CREATE TABLE Usuario (
	ID_Usuario		INT 		NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre			VARCHAR(30) NOT NULL,
    ApePaterno 		VARCHAR(30) NOT NULL,
    ApeMaterno 		VARCHAR(30) NOT NULL,
    FecNacimiento 	DATE 		NOT NULL,
    Email			VARCHAR(50) NOT NULL,
    UserName		VARCHAR(30) NOT NULL UNIQUE,
    Contrasena		VARCHAR(30) NOT NULL,
    UserImagen		LONGBLOB	NULL,
    Activo			INT			NOT NULL,
	FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
    CONSTRAINT PK_ID_Usuario_Usuario
    PRIMARY KEY (ID_Usuario)
);


CREATE TABLE Publicacion(
	ID_Publicacion	INT 			NOT NULL UNIQUE AUTO_INCREMENT,
    Texto			VARCHAR(100) 	NULL,
    Imagen			LONGBLOB		NULL,
    Spoiler			INT				NOT NULL,
    ID_Usuario		INT				NOT NULL,
    Activo			INT				NOT NULL,
    FechaDeCreacion	DATETIME		NOT NULL,
	FechaDeCambio	DATETIME		NOT NULL,
    
    
    CONSTRAINT PK_ID_Publicacion_Publicacion
    PRIMARY KEY (ID_Publicacion),
    
    CONSTRAINT FK_ID_Usuario_Publicacion
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

CREATE TABLE Comentario(
	ID_Comentario	INT			NOT NULL UNIQUE AUTO_INCREMENT,
    Texto			VARCHAR(50) NOT NULL,
	Spoiler			INT			NOT NULL,
    ID_Usuario		INT			NOT NULL,
	ID_Publicacion	INT			NOT NULL,
    Activo			INT			NOT NULL,
    FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
	CONSTRAINT PK_ID_Comentario_Comentario
    PRIMARY KEY (ID_Comentario),
    
    CONSTRAINT FK_ID_Usuario_Comentario_Comentario
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario),
    
    CONSTRAINT FK_ID_Publicacion_Comentario
    FOREIGN KEY (ID_Publicacion) REFERENCES Publicacion(ID_Publicacion)
);


CREATE TABLE Usuario_Gusta_Publicacion(
	ID_UGP			INT			NOT NULL UNIQUE AUTO_INCREMENT,
    ID_Usuario		INT			NOT NULL,
    ID_Publicacion	INT			NOT NULL,
    Activo			INT			NOT NULL,
    FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
    CONSTRAINT PK_ID_UGP_UGP
    PRIMARY KEY (ID_UGP),
    
    CONSTRAINT FK_ID_Usuario_UGP
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario),
    
    CONSTRAINT FK_ID_Publicacion_UGP
    FOREIGN KEY (ID_Publicacion) REFERENCES Publicacion(ID_Publicacion)
);

insert into Usuario (Nombre, ApePaterno, ApeMaterno, FecNacimiento, Email, UserName, Contrasena, UserImagen, Activo, FechaDeCreacion, FechaDeCambio)
values ('Jan Anthony', 'Ochoa', 'Retta', '2002-10-29', 'jan8a00@gmail.com', 'JanOchoa10', 'jan8A00!', 'yon.png', 1, current_timestamp(), current_timestamp());

-- UPDATE Publicacion SET Activo = 0 WHERE ID_Publicacion = 18;

-- DELETE FROM Publicacion WHERE ID_Publicacion > 34;
-- INSERT INTO publicacion (Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio) VALUES ("xd","yon.png",0,1,1,current_timestamp(),current_timestamp());

-- SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion WHERE Activo = 1 ORDER BY FechaDeCreacion DESC LIMIT 10 ;

use bd_postcat;
select * from Usuario;
select * from Publicacion;
select * from comentario;
select * from usuario_gusta_publicacion;

select P.ID_Publicacion, P.Texto, P.Imagen, P.Spoiler, P.ID_Usuario, P.Activo, P.FechaDeCreacion, P.FechaDeCambio from Publicacion P left join comentario C on C.ID_Publicacion = P.ID_Publicacion WHERE P.Activo = 1 AND (C.Activo is null OR C.Activo = 1) GROUP BY P.ID_Publicacion ORDER BY COUNT(C.ID_Publicacion) DESC LIMIT 10;

select P.ID_Publicacion, P.Texto, P.Imagen, P.Spoiler, P.ID_Usuario, P.Activo, P.FechaDeCreacion, P.FechaDeCambio from Publicacion P left join usuario_gusta_publicacion C on C.ID_Publicacion = P.ID_Publicacion WHERE P.Activo = 1 AND (C.Activo is null OR C.Activo = 1) GROUP BY P.ID_Publicacion ORDER BY COUNT(C.ID_Publicacion) DESC LIMIT 10;

select C.ID_Publicacion, COUNT(*) from comentario C WHERE C.Activo = 1 GROUP BY C.ID_Publicacion ORDER BY COUNT(*) DESC;

-- SELECT * FROM usuario_gusta_publicacion WHERE Activo = 1 ORDER BY FechaDeCreacion DESC ;

-- delete from comentario where ID_Comentario > 12

-- SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion ORDER BY FechaDeCreacion ASC LIMIT 5
-- SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion ORDER BY FechaDeCreacion DESC LIMIT 5
-- SELECT ID_Publicacion, Texto, Imagen, Spoiler, ID_Usuario, Activo, FechaDeCreacion, FechaDeCambio FROM publicacion ORDER BY FechaDeCreacion DESC LIMIT 10 ;
-- delete from usuario where ID_Usuario = 8

-- SELECT current_timestamp()
-- SELECT * FROM Usuario WHERE UserName = 'JanOchoa10' AND Contrasena = 'jan8a00!';

-- use laboratorio;
-- select * from users; 
-- alter table users add column Activo int;

-- update users set Activo = 1 where idUser > 3
-- drop database bd_postcat;