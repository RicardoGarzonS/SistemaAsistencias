--database: ../database/Asistencias.sqlite

DROP TABLE IF EXISTS Asistencia;
DROP TABLE IF EXISTS Inscripcion;
DROP TABLE IF EXISTS Lector;
DROP TABLE IF EXISTS Clase;
DROP TABLE IF EXISTS Dia;
DROP TABLE IF EXISTS Materia;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Rol;

CREATE TABLE Rol (
     IdRol                  INTEGER PRIMARY KEY AUTOINCREMENT

    ,Nombre                 VARCHAR(10) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime')) 
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

CREATE TABLE Usuario (
     IdUsuario              INTEGER PRIMARY KEY UNIQUE
    ,IdRol                  INTEGER NOT NULL REFERENCES Rol(IdRol)
    ,NombreUsuario          VARCHAR(20) NOT NULL 
    ,Clave                  VARCHAR(20) NOT NULL
    ,Cedula                 VARCHAR(10) NOT NULL UNIQUE
    ,CorreoInstitucional    VARCHAR(40) NOT NULL UNIQUE

    ,Estado                 INTEGER NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

CREATE TABLE Materia (
     IdMateria              INTEGER PRIMARY KEY AUTOINCREMENT

    ,Nombre                 VARCHAR(40) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

CREATE TABLE Dia (
     IdDia                  INTEGER PRIMARY KEY AUTOINCREMENT

    ,Nombre                 VARCHAR(10) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);


CREATE TABLE Clase (
     IdClase                INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdMateria              INTEGER NOT NULL REFERENCES Materia(IdMateria)
    ,IdDia                  INTEGER NOT NULL REFERENCES Dia(IdDia)

    ,HoraInicio             TEXT NOT NULL
    ,HoraFin                TEXT NOT NULL

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

CREATE TABLE Lector (
     IdLector               INTEGER PRIMARY KEY AUTOINCREMENT

    ,CodigoAula             VARCHAR(10) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

CREATE TABLE Inscripcion (
     IdInscripcion          INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdUsuario              INTEGER NOT NULL REFERENCES Usuario(IdUsuario)
    ,IdClase                INTEGER NOT NULL REFERENCES Clase(IdClase)
    ,IdLector               INTEGER NOT NULL REFERENCES Lector(IdLector)

    ,Año                    VARCHAR(4) NOT NULL

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);


CREATE TABLE Asistencia (
     IdAsistencia           INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdInscripcion          INTEGER NOT NULL REFERENCES Inscripcion(IdInscripcion)

    ,Fecha                  DATE NOT NULL
    ,HoraEntrada            TEXT NOT NULL /* Se deberia cambiar al formato de hora para hacer un split y poder ver si la asistencia cuenta*/
    ,HoraSalida             TEXT NOT NULL /* Se deberia cambiar al formato de hora para hacer un split y poder ver si la asistencia cuenta*/
    ,Justificacion          BOOLEAN

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCreacion          DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
    ,FechaModificacion      DATE NOT NULL DEFAULT (DATE('now', 'localtime'))
);

