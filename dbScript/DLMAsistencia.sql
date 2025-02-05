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