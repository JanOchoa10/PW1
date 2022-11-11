CREATE DATABASE BD_PostCat;

use BD_PostCat;

CREATE TABLE Usuario (
	ID_Usuario		INT 		NOT NULL UNIQUE,
    Nombre			VARCHAR(30) NOT NULL,
    ApePaterno 		VARCHAR(30) NOT NULL,
    ApeMaterno 		VARCHAR(30) NOT NULL,
    FecNacimiento 	DATE 		NOT NULL,
    Email			VARCHAR(50) NOT NULL,
    UserName		VARCHAR(30) NOT NULL,
    Contrasena		VARCHAR(30) NOT NULL,
    UserImagen		LONGBLOB	NULL,
    Activo			INT			NOT NULL,
	FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
    CONSTRAINT PK_ID_Usuario
    PRIMARY KEY (ID_Usuario)
);


CREATE TABLE Publicacion(
	ID_Publicacion	INT 			NOT NULL UNIQUE,
    Texto			VARCHAR(100) 	NULL,
    Imagen			LONGBLOB		NULL,
    Spoiler			INT				NOT NULL,
    ID_Usuario		INT				NOT NULL,
    Activo			INT				NOT NULL,
    FechaDeCreacion	DATETIME		NOT NULL,
	FechaDeCambio	DATETIME		NOT NULL,
    
    
    CONSTRAINT PK_ID_Publicacion
    PRIMARY KEY (ID_Publicacion),
    
    CONSTRAINT FK_ID_Usuario
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

CREATE TABLE Comentario(
	ID_Comentario	INT			NOT NULL UNIQUE,
    Texto			VARCHAR(50) NOT NULL,
	Spoiler			INT			NOT NULL,
    ID_Usuario		INT			NOT NULL,
	ID_Publicacion	INT			NOT NULL,
    Activo			INT			NOT NULL,
    FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
	CONSTRAINT PK_ID_Comentario
    PRIMARY KEY (ID_Comentario),
    
    CONSTRAINT FK_ID_Usuario
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario),
    
    CONSTRAINT FK_ID_Publicacion
    FOREIGN KEY (ID_Publicacion) REFERENCES Publicacion(ID_Publicacion)
);


CREATE TABLE Usuario_Gusta_Publicacion(
	ID_UGP			INT			NOT NULL UNIQUE,
    ID_Usuario		INT			NOT NULL,
    ID_Publicacion	INT			NOT NULL,
    Activo			INT			NOT NULL,
    FechaDeCreacion	DATETIME	NOT NULL,
	FechaDeCambio	DATETIME	NOT NULL,
    
    CONSTRAINT PK_ID_UGP
    PRIMARY KEY (ID_UGP),
    
    CONSTRAINT FK_ID_Usuario
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario),
    
    CONSTRAINT FK_ID_Publicacion
    FOREIGN KEY (ID_Publicacion) REFERENCES Publicacion(ID_Publicacion)
);