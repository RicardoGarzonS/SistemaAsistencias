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

    ,Estado                 VARCHAR(1) NOT NULL
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);

CREATE TABLE Usuario (
     IdUsuario              INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdRol                  INTEGER NOT NULL REFERENCES Rol(IdRol)

    ,IdTarjeta              INTEGER NOT NULL UNIQUE
    ,NombreUsuario          VARCHAR(20) NOT NULL UNIQUE
    ,Clave                  VARCHAR(20) NOT NULL
    ,Cedula                 VARCHAR(10) NOT NULL UNIQUE
    ,CorreoInstitucional    VARCHAR(40) NOT NULL UNIQUE

    ,Estado                 INTEGER NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);

CREATE TABLE Materia (
     IdMateria              INTEGER PRIMARY KEY AUTOINCREMENT

    ,Nombre                 VARCHAR(40) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);

CREATE TABLE Dia (
     IdDia                  INTEGER PRIMARY KEY AUTOINCREMENT

    ,Nombre                 VARCHAR(10) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);


CREATE TABLE Clase (
     IdClase                INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdMateria              INTEGER NOT NULL REFERENCES Materia(IdMateria)
    ,IdDia                  INTEGER NOT NULL REFERENCES Dia(IdDia)

    ,HoraInicio             INTEGER NOT NULL
    ,HoraFin                INTEGER NOT NULL

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);

CREATE TABLE Lector (
     IdLector               INTEGER PRIMARY KEY AUTOINCREMENT

    ,CodigoAula             VARCHAR(10) NOT NULL UNIQUE

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);

CREATE TABLE Inscripcion (
     IdInscripcion          INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdUsuario              INTEGER NOT NULL REFERENCES Usuario(IdUsuario)
    ,IdClase                INTEGER NOT NULL REFERENCES Clase(IdClase)
    ,IdLector               INTEGER NOT NULL REFERENCES Lector(IdLector)

    ,Año                    VARCHAR(4) NOT NULL

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT ('A')
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);


CREATE TABLE Asistencia (
     IdAsistencia           INTEGER PRIMARY KEY AUTOINCREMENT

    ,IdInscripcion          INTEGER NOT NULL REFERENCES Inscripcion(IdInscripcion)

    ,Fecha                  DATE NOT NULL
    ,HoraEntrada            INTEGER
    ,HoraSalida             INTEGER
    ,Justificacion          BOOLEAN

    ,Estado                 VARCHAR(1) NOT NULL DEFAULT 'A'
    ,FechaCreacion          DATETIME NOT NULL
    ,FechaModificacion      DATETIME
);
