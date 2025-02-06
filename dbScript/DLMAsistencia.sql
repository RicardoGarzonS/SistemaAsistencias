--database: ../database/Asistencias.sqlite

INSERT INTO Rol (IdRol, Nombre) 
VALUES 
(1, 'Administrador')
,(2, 'Docente')
,(3, 'Estudiante');

INSERT INTO Usuario (IdRol, NombreUsuario, Clave, Cedula, CorreoInstitucional) 
VALUES 
(1, 'Admin', '123', '1755874109', 'admin@gmail.com'); 

INSERT INTO Dia (Nombre)
VALUES
('Lunes')
,('Martes')
,('Miercoles')
,('Jueves')
,('Viernes');


-- PARA PRUEBAS BORRAR LUEGO

INSERT INTO Rol (IdRol, Nombre) 
VALUES 
(1, 'Estudiante');

INSERT INTO Dia (Nombre) VALUES ('Lunes');

INSERT INTO Materia (Nombre) VALUES ('ProgramacionII');

INSERT INTO Lector (CodigoAula) VALUES (303);

INSERT INTO Usuario (IdRol, NombreUsuario, Clave, Cedula, CorreoInstitucional) 
VALUES 
(1, 'Juan', '123', '1755874109', 'correo1'),
(1, 'Paola', '123', '17558741209', 'correo2'); 

INSERT INTO Clase (IdMateria, IdDia, HoraInicio, HoraFin) VALUES
(1, 1, '14:00', '16:00');

INSERT INTO Inscripcion (IdUsuario, IdClase, IdLector, Año) VALUES
(1, 1, 1, '2024'),
(2, 1, 1, '2024');

INSERT INTO Asistencia (IdInscripcion, Fecha, HoraEntrada, HoraSalida) VALUES
(1, '2025/02/05', '14:00', '16:00'),
(2, '2025/02/05', '14:00', '16:00');