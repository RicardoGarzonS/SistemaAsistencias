--database: ../database/Asistencias.sqlite

INSERT INTO Rol (IdRol, Nombre) 
VALUES 
 (3, 'Administrador')
,(2, 'Docente')
,(1, 'Estudiante');

INSERT INTO Dia (Nombre) VALUES 
 ('Lunes')
,('Martes')
,('Miercoles')
,('Jueves')
,('Viernes');


INSERT INTO Materia (Nombre) VALUES
 ('Ecuaciones Diferenciales')                       --ESPINOSA PABLO
 ,('Mate compu')                                    --HERRERA ERICK
 ,('Analisis de socieconomica y politica de EC')    --ZHINGRE RAUL
 ,('Fundamentos de Electronica')                    --MARTINEZ SILVIA
 ,('ProgramacionII')                                --PACCHA PATRICIO
 ,('Clubes');


INSERT INTO Lector (CodigoAula) VALUES (303);

INSERT INTO Usuario (IdUsuario, IdRol, NombreUsuario, Clave, Cedula, CorreoInstitucional) 
VALUES 
 (0007349650, 3,'Admin',                '123Admin',    '1701234567',        'admin@epn.edu.ec')
,(0007412445, 2,'PACCHA PATRICIO',      '123',         '1709876543',        'profe.PP@epn.edu.ec')
,(0007521860, 2,'ESPINOSA PABLO',       '123',         '1712345678',        'profe.EP@epn.edu.ec')
,(0007963578, 2,'HERRERA ERICK',        '123',         '1744321098',        'profe.HE@epn.edu.ec')
,(0007296421, 2,'MARTINEZ SILVIA',      '123',         '1723456789',        'profe.MS@epn.edu.ec')
,(0006968501, 2,'ZHINGRE RAUL',         '123',         '1727654321',        'profe.ZR@epn.edu.ec')
,(0007010128, 1,'Ricardo',              '123',         '1734567890',        'ricardo@epn.edu.ec')
,(0007276783, 1,'Aron',                 '123',         '1051638427',        'aron@epn.edu.ec')
,(0008057905, 1,'Sebas',                '123',         '0728193560',        'sebas@epn.edu.ec')
,(0007681765, 1,'Hector',               '123',         '1394051827',        'hector@epn.edu.ec');

INSERT INTO Clase (IdMateria, IdDia, HoraInicio, HoraFin) VALUES
 (1, 1, '09:00',     '11:00')
,(2, 1, '14:00',    '16:00')
,(4, 2, '09:00',     '11:00')
,(6, 2, '14:00',    '16:00')
,(2, 2, '16:00',    '18:00')
,(1, 3, '09:00',     '11:00')
,(1, 3, '11:00',    '13:00')
,(5, 3, '14:00',    '16:00')
,(4, 4, '09:00',     '11:00')
,(5, 4, '14:00',    '16:00')
,(4, 4, '16:00',    '18:00')
,(3, 5, '09:00',     '11:00')
,(5, 5, '14:00',    '16:00')
,(2, 5, '16:00',    '18:00');

INSERT INTO Inscripcion (IdUsuario, IdClase, IdLector, Año) VALUES
------PORFESORES--------------------------------------------------------------

-- PACCHA PATRICIO (ProgramacionII - Clases 8,10,13)
 ( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1709876543'), 8, 1, '2024')  -- Miércoles 14:00-16:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1709876543'), 10, 1, '2024') -- Jueves 14:00-16:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1709876543'), 13, 1, '2025') -- Viernes 14:00-16:00

-- ESPINOSA PABLO (Ecuaciones Diferenciales - Clases 1,6,7)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1712345678'), 1, 1, '2024')  -- Lunes 9:00-11:00 
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1712345678'), 6, 1, '2024')  -- Miércoles 9:00-11:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1712345678'), 7, 1, '2025')  -- Miércoles 11:00-13:00

-- HERRERA ERICK (Mate compu - Clases 2,5,14)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1744321098'), 2, 1, '2024')  -- Lunes 14:00-16:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1744321098'), 5, 1, '2024')  -- Martes 16:00-18:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1744321098'), 14, 1, '2025') -- Viernes 16:00-18:00

-- MARTINEZ SILVIA (Fundamentos Electrónica - Clases 3,9,11)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1723456789'), 3, 1, '2024')  -- Martes 9:00-11:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1723456789'), 9, 1, '2024')  -- Jueves 9:00-11:00
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1723456789'), 11, 1, '2025') -- Jueves 16:00-18:00

-- ZHINGRE RAUL (Análisis Socioeconómico - Clase 12)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1727654321'), 12, 1, '2025') -- Viernes 9:00-11:00

------ESTUDIANTES--------------------------------------------------------------
-- Ricardo (IdUsuario = 7)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 1, 1,  '2024')  -- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 2, 1,  '2024')  -- Mate compu (Lunes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 4, 1,  '2024')  -- Fundamentos de Electrónica (Martes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 6, 1,  '2024')  -- Clubes (Martes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 7, 1,  '2024')  -- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 8, 1,  '2024')  -- Programación II (Miércoles 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 9, 1,  '2024')  -- Fundamentos de Electrónica (Jueves 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 10, 1, '2025') -- Programación II (Jueves 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 11, 1, '2025') -- Análisis Socioeconómico (Viernes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1734567890'), 12, 1, '2025') -- Mate compu (Viernes 16:00-18:00)

-- Aron (IdUsuario = 8)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 1, 1,  '2024')  -- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 2, 1,  '2024')  -- Mate compu (Lunes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 4, 1,  '2024')  -- Fundamentos de Electrónica (Martes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 6, 1,  '2024')  -- Clubes (Martes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 7, 1,  '2024')  -- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 8, 1,  '2024')  -- Programación II (Miércoles 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 9, 1,  '2024')  -- Fundamentos de Electrónica (Jueves 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 10, 1, '2025') -- Programación II (Jueves 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 11, 1, '2025') -- Análisis Socioeconómico (Viernes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1051638427'), 12, 1, '2025') -- Mate compu (Viernes 16:00-18:00)

-- Sebas (IdUsuario = 9)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 1, 1,   '2024')  -- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 2, 1,   '2024')  -- Mate compu (Lunes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 4, 1,   '2024')  -- Fundamentos de Electrónica (Martes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 6, 1,   '2024')  -- Clubes (Martes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 7, 1,   '2024')  -- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 8, 1,   '2024')  -- Programación II (Miércoles 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 9, 1,   '2024')  -- Fundamentos de Electrónica (Jueves 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 10, 1,  '2025') -- Programación II (Jueves 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 11, 1,  '2025') -- Análisis Socioeconómico (Viernes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '0728193560'), 12, 1,  '2025') -- Mate compu (Viernes 16:00-18:00)

-- Hector (IdUsuario = 10)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 1, 1,   '2024')  -- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 2, 1,   '2024')  -- Mate compu (Lunes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 4, 1,   '2024')  -- Fundamentos de Electrónica (Martes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 6, 1,   '2024')  -- Clubes (Martes 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 7, 1,   '2024')  -- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 8, 1,   '2024')  -- Programación II (Miércoles 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 9, 1,   '2024')  -- Fundamentos de Electrónica (Jueves 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 10, 1,  '2025') -- Programación II (Jueves 14:00-16:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 11, 1,  '2025') -- Análisis Socioeconómico (Viernes 9:00-11:00)
,( (SELECT IdUsuario FROM Usuario WHERE Cedula = '1394051827'), 12, 1,  '2025'); -- Mate compu (Viernes 16:00-18:00)


INSERT INTO Asistencia (IdInscripcion, Fecha, HoraEntrada, HoraSalida) VALUES
-- PACCHA PATRICIO (IdInscripcion 1-3)
-- Clase 8 (Miércoles 14:00-16:00)
 (1, '2024/02/07', '14:00', '16:00')
,(1, '2024/02/14', '14:00', '16:00')
,(1, '2024/02/21', '14:00', '16:00')
,(1, '2024/02/28', '14:00', '16:00')
,(1, '2025/01/06', '14:00', '16:00')
,(1, '2025/01/13', '14:00', '16:00')
,(1, '2025/01/20', '14:00', '16:00')

-- Clase 10 (Jueves 14:00-16:00)
,(2, '2024/02/08', '14:00', '16:00')
,(2, '2024/02/15', '14:00', '16:00')
,(2, '2024/02/22', '14:00', '16:00')
,(2, '2024/02/29', '14:00', '16:00')
,(2, '2024/01/07', '14:00', '16:00')
,(2, '2024/01/14', '14:00', '16:00')
,(2, '2025/01/21', '14:00', '16:00')

-- Clase 13 (Viernes 14:00-16:00)
,(3, '2024/02/09', '14:00', '16:00')
,(3, '2024/02/16', '14:00', '16:00')
,(3, '2024/02/23', '14:00', '16:00')
,(3, '2024/03/01', '14:00', '16:00')
,(3, '2025/01/08', '14:00', '16:00')
,(3, '2025/01/15', '14:00', '16:00')
,(3, '2025/02/07', '14:00', '16:00')

-- ESPINOSA PABLO (IdInscripcion 4-6)
-- Clase 1 (Lunes 9:00-11:00)
,(4, '2024/02/05', '09:00', '11:00')
,(4, '2024/02/12', '09:00', '11:00')
,(4, '2024/02/19', '09:00', '11:00')
,(4, '2024/02/26', '09:00', '11:00')
,(4, '2025/01/04', '09:00', '11:00')
,(4, '2025/01/11', '09:00', '11:00')
,(4, '2025/02/10', '09:00', '11:00')

-- Clase 6 (Miércoles 9:00-11:00)
,(5, '2024/02/07', '09:00', '11:00')
,(5, '2024/02/14', '09:00', '11:00')
,(5, '2024/02/21', '09:00', '11:00')
,(5, '2024/02/28', '09:00', '11:00')
,(5, '2025/01/06', '09:00', '11:00')
,(5, '2025/01/13', '09:00', '11:00')
,(5, '2025/01/20', '09:00', '11:00')

-- Clase 7 (Miércoles 11:00-13:00)
,(6, '2024/02/07', '11:00', '13:00')
,(6, '2024/02/14', '11:00', '13:00')
,(6, '2024/02/21', '11:00', '13:00')
,(6, '2024/02/28', '11:00', '13:00')
,(6, '2025/01/06', '11:00', '13:00')
,(6, '2025/01/13', '11:00', '13:00')
,(6, '2025/01/20', '11:00', '13:00')

-- HERRERA ERICK (IdInscripcion 7-9)
-- Clase 2 (Lunes 14:00-16:00)
,(7, '2024/02/05', '14:00', '16:00')
,(7, '2024/02/12', '14:00', '16:00')
,(7, '2024/02/19', '14:00', '16:00')
,(7, '2024/02/26', '14:00', '16:00')
,(7, '2025/01/04', '14:00', '16:00')
,(7, '2025/01/11', '14:00', '16:00')
,(7, '2025/02/10', '14:00', '16:00')

-- Clase 5 (Martes 16:00-18:00)
,(8, '2024/02/06', '16:00', '18:00')
,(8, '2024/02/13', '16:00', '18:00')
,(8, '2024/02/20', '16:00', '18:00')
,(8, '2024/02/27', '16:00', '18:00')
,(8, '2025/01/05', '16:00', '18:00')
,(8, '2025/01/12', '16:00', '18:00')
,(8, '2025/01/19', '16:00', '18:00')

-- Clase 14 (Viernes 16:00-18:00)
,(9, '2024/02/09', '16:00', '18:00')
,(9, '2024/02/16', '16:00', '18:00')
,(9, '2024/02/23', '16:00', '18:00')
,(9, '2024/03/01', '16:00', '18:00')
,(9, '2025/01/08', '16:00', '18:00')
,(9, '2025/01/15', '16:00', '18:00')
,(9, '2025/02/07', '16:00', '18:00')

-- MARTINEZ SILVIA (IdInscripcion 10-12)
-- Clase 3 (Martes 9:00-11:00)
,(10, '2024/02/06', '09:00', '11:00')
,(10, '2024/02/13', '09:00', '11:00')
,(10, '2024/02/20', '09:00', '11:00')
,(10, '2024/02/27', '09:00', '11:00')
,(10, '2025/01/05', '09:00', '11:00')
,(10, '2025/01/12', '09:00', '11:00')
,(10, '2025/01/19', '09:00', '11:00')

-- Clase 9 (Jueves 9:00-11:00)
,(11, '2024/02/08', '09:00', '11:00')
,(11, '2024/02/15', '09:00', '11:00')
,(11, '2024/02/22', '09:00', '11:00')
,(11, '2024/02/29', '09:00', '11:00')
,(11, '2025/01/07', '09:00', '11:00')
,(11, '2025/01/14', '09:00', '11:00')
,(11, '2025/01/21', '09:00', '11:00')

-- Clase 11 (Jueves 16:00-18:00)
,(12, '2024/02/08', '16:00', '18:00')
,(12, '2024/02/15', '16:00', '18:00')
,(12, '2024/02/22', '16:00', '18:00')
,(12, '2024/02/29', '16:00', '18:00')
,(12, '2025/01/07', '16:00', '18:00')
,(12, '2025/01/14', '16:00', '18:00')
,(12, '2025/01/21', '16:00', '18:00')

-- ZHINGRE RAUL (IdInscripcion 13)
-- Clase 12 (Viernes 9:00-11:00)
,(13, '2024/02/09', '09:00', '11:00')
,(13, '2024/02/16', '09:00', '11:00')
,(13, '2024/02/23', '09:00', '11:00')
,(13, '2024/03/01', '09:00', '11:00')
,(13, '2025/01/08', '09:00', '11:00')
,(13, '2025/01/15', '09:00', '11:00')
,(13, '2025/02/07', '09:00', '11:00')

-- Ricardo (IdInscripcion = 14 a 23)
-- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,(14, '2024/04/01', '00:00', '00:00')        -- Falta el 1 de abril
,(14, '2024/02/05', '09:00', '11:00')  -- Asiste el 5 de febrero
,(14, '2024/04/08', '09:00', '11:00')  -- Asiste el 8 de abril 
,(14, '2024/02/12', '00:00', '00:00')        -- Falta el 12 de febrero
,(14, '2024/02/19', '09:00', '11:00')  -- Asiste el 19 de febrero
,(14, '2024/02/26', '09:00', '11:00')  -- Asiste el 26 de febrero
,(14, '2025/01/04', '09:00', '11:00')  -- Asiste el 4 de marzo
,(14, '2025/01/11', '00:00', '00:00')        -- Falta el 11 de marzo
,(14, '2025/02/10', '09:00', '11:00')  -- Asiste el 18 de enero

-- Mate compu (Lunes 14:00-16:00)
,(15, '2024/04/01', '00:00', '00:00')        -- Falta el 1 de abril
,(15, '2024/02/05', '14:00', '16:00')  -- Asiste el 5 de febrero
,(15, '2024/04/08', '14:00', '16:00')  -- Asiste el 8 de abril
,(15, '2024/02/12', '14:00', '16:00')  -- Asiste el 12 de febrero
,(15, '2024/02/19', '00:00', '00:00')        -- Falta el 19 de febrero
,(15, '2024/02/26', '14:00', '16:00')  -- Asiste el 26 de febrero
,(15, '2025/01/04', '14:00', '16:00')  -- Asiste el 4 de marzo
,(15, '2025/01/11', '14:00', '16:00')  -- Asiste el 11 de marzo
,(15, '2025/02/10', '00:00', '00:00')        -- Falta el 18 de enero

-- Fundamentos de Electrónica (Martes 9:00-11:00)
,(16, '2024/04/02', '09:00', '11:00')  -- Asiste el 2 de abril
,(16, '2024/02/06', '09:00', '11:00')  -- Asiste el 6 de febrero
,(16, '2024/04/09', '00:00', '00:00')        -- Falta el 9 de abril
,(16, '2024/02/13', '09:00', '11:00')  -- Asiste el 13 de febrero
,(16, '2024/02/20', '09:00', '11:00')  -- Asiste el 20 de febrero
,(16, '2024/02/27', '00:00', '00:00')        -- Falta el 27 de febrero
,(16, '2025/01/05', '09:00', '11:00')  -- Asiste el 5 de marzo
,(16, '2025/01/12', '09:00', '11:00')  -- Asiste el 12 de marzo
,(16, '2025/01/19', '09:00', '11:00')  -- Asiste el 19 de marzo

-- Clubes (Martes 14:00-16:00)
,(17, '2024/02/06', '14:00', '16:00')  -- Asiste el 6 de febrero
,(17, '2024/02/13', '00:00', '00:00')        -- Falta el 13 de febrero
,(17, '2024/02/20', '14:00', '16:00')  -- Asiste el 20 de febrero
,(17, '2024/02/27', '14:00', '16:00')  -- Asiste el 27 de febrero
,(17, '2024/03/05', '14:00', '16:00')  -- Asiste el 5 de marzo
,(17, '2024/03/12', '00:00', '00:00')        -- Falta el 12 de marzo
,(17, '2025/01/19', '14:00', '16:00')  -- Asiste el 19 de marzo
,(17, '2025/01/02', '14:00', '16:00')  -- Asiste el 2 de abril
,(17, '2025/01/09', '14:00', '16:00') -- Asiste el 9 de abril

-- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,(18, '2024/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero
,(18, '2024/02/14', '09:00', '11:00')  -- Asiste el 14 de febrero
,(18, '2024/02/21', '00:00', '00:00')        -- Falta el 21 de febrero
,(18, '2024/02/28', '09:00', '11:00')  -- Asiste el 28 de febrero
,(18, '2025/01/06', '09:00', '11:00')  -- Asiste el 6 de marzo
,(18, '2025/01/13', '09:00', '11:00')  -- Asiste el 13 de marzo
,(18, '2025/01/20', '00:00', '00:00')        -- Falta el 20 de marzo

-- Programación II (Miércoles 14:00-16:00)
,(19, '2024/02/07', '14:00', '16:00')  -- Asiste el 7 de febrero
,(19, '2024/02/14', '00:00', '00:00')        -- Falta el 14 de febrero
,(19, '2024/02/21', '14:00', '16:00')  -- Asiste el 21 de febrero
,(19, '2024/02/28', '14:00', '16:00')  -- Asiste el 28 de febrero
,(19, '2025/01/06', '14:00', '16:00')  -- Asiste el 6 de marzo
,(19, '2025/01/13', '14:00', '16:00')  -- Asiste el 13 de marzo
,(19, '2025/01/20', '14:00', '16:00')  -- Asiste el 20 de marzo

-- Fundamentos de Electrónica (Jueves 9:00-11:00)
,(20, '2024/02/08', '09:00', '11:00')  -- Asiste el 8 de febrero
,(20, '2024/02/15', '09:00', '11:00')  -- Asiste el 15 de febrero
,(20, '2024/02/22', '09:00', '11:00')  -- Asiste el 22 de febrero
,(20, '2024/02/29', '00:00', '00:00')        -- Falta el 29 de febrero
,(20, '2025/01/07', '09:00', '11:00')  -- Asiste el 7 de marzo
,(20, '2025/01/14', '09:00', '11:00')  -- Asiste el 14 de marzo
,(20, '2025/01/21', '09:00', '11:00')  -- Asiste el 21 de marzo5
-- Programación II (Jueves 14:00-16:00)
,(21, '2024/02/08', '14:00', '16:00')  -- Asiste el 8 de febrero
,(21, '2024/02/15', '00:00', '00:00')        -- Falta el 15 de febrero
,(21, '2024/02/22', '14:00', '16:00')  -- Asiste el 22 de febrero
,(21, '2024/02/29', '14:00', '16:00')  -- Asiste el 29 de febrero
,(21, '2024/01/07', '14:00', '16:00')  -- Asiste el 7 de marzo
,(21, '2025/01/14', '00:00', '00:00')        -- Falta el 14 de marzo
,(21, '2025/01/21', '14:00', '16:00')  -- Asiste el 21 de marzo

-- Análisis Socioeconómico (Viernes 9:00-11:00)
,(22, '2024/02/09', '09:00', '11:00')  -- Asiste el 9 de febrero
,(22, '2024/02/16', '09:00', '11:00')  -- Asiste el 16 de febrero
,(22, '2024/02/23', '00:00', '00:00')        -- Falta el 23 de febrero
,(22, '2024/03/01', '09:00', '11:00')  -- Asiste el 1 de marzo
,(22, '2025/01/08', '09:00', '11:00')  -- Asiste el 8 de enero
,(22, '2025/01/15', '09:00', '11:00')  -- Asiste el 15 de enero
,(22, '2025/02/07', '00:00', '00:00')        -- Falta el 7 de febrero

-- Mate compu (Viernes 16:00-18:00)
,(23, '2024/02/09', '16:00', '18:00') -- Asiste el 9 de febrero
,(23, '2024/02/16', '00:00', '00:00')       -- Falta el 16 de febrero
,(23, '2024/02/23', '16:00', '18:00') -- Asiste el 23 de febrero
,(23, '2024/03/01', '16:00', '18:00') -- Asiste el 1 de marzo
,(23, '2025/01/08', '16:00', '18:00') -- Asiste el 8 de enero
,(23, '2025/01/15', '00:00', '00:00')       -- Falta el 15 de enero
,(23, '2025/02/07', '16:00', '18:00') -- Asiste el 7 de febrero

-- Aron (IdInscripcion = 24 a 33)
-- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,(24, '2024/02/05', '09:00', '11:00')  -- Asiste el 5 de febrero
,(24, '2024/02/12', '09:00', '11:00')  -- Asiste el 12 de febrero
,(24, '2024/02/19', '00:00', '00:00')        -- Falta el 19 de febrero
,(24, '2024/02/26', '09:00', '11:00')  -- Asiste el 26 de febrero
,(24, '2025/01/04', '09:00', '11:00')  -- Asiste el 4 de marzo
,(24, '2025/01/11', '00:00', '00:00')        -- Falta el 11 de marzo
,(24, '2025/02/10', '09:00', '11:00')  -- Asiste el 18 de enero

-- Mate compu (Lunes 14:00-16:00)
,(25, '2024/02/05', '14:00', '16:00')  -- Asiste el 5 de febrero
,(25, '2024/02/12', '00:00', '00:00')        -- Falta el 12 de febrero
,(25, '2024/02/19', '14:00', '16:00')  -- Asiste el 19 de febrero
,(25, '2024/02/26', '14:00', '16:00')  -- Asiste el 26 de febrero
,(25, '2025/01/04', '14:00', '16:00')  -- Asiste el 4 de marzo
,(25, '2025/01/11', '14:00', '16:00')  -- Asiste el 11 de marzo
,(25, '2025/02/10', '00:00', '00:00')        -- Falta el 18 de enero

-- Fundamentos de Electrónica (Martes 9:00-11:00)
,(26, '2024/02/06', '09:00', '11:00')  -- Asiste el 6 de febrero
,(26, '2024/02/13', '09:00', '11:00')  -- Asiste el 13 de febrero
,(26, '2024/02/20', '00:00', '00:00')        -- Falta el 20 de febrero
,(26, '2024/02/27', '09:00', '11:00')  -- Asiste el 27 de febrero
,(26, '2025/01/05', '09:00', '11:00')  -- Asiste el 5 de marzo
,(26, '2025/01/12', '09:00', '11:00')  -- Asiste el 12 de marzo
,(26, '2025/01/19', '09:00', '11:00')  -- Asiste el 19 de marzo

-- Clubes (Martes 14:00-16:00)
,(27, '2024/02/06', '14:00', '16:00')  -- Asiste el 6 de febrero
,(27, '2024/02/13', '14:00', '16:00')  -- Asiste el 13 de febrero
,(27, '2024/02/20', '14:00', '16:00')  -- Asiste el 20 de febrero
,(27, '2024/02/27', '00:00', '00:00')        -- Falta el 27 de febrero
,(27, '2025/01/05', '14:00', '16:00')  -- Asiste el 5 de marzo
,(27, '2025/01/12', '00:00', '00:00')        -- Falta el 12 de marzo
,(27, '2025/01/19', '14:00', '16:00')  -- Asiste el 19 de marzo

-- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,(28, '2024/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero
,(28, '2024/02/14', '09:00', '11:00')  -- Asiste el 14 de febrero
,(28, '2024/02/21', '09:00', '11:00')  -- Asiste el 21 de febrero
,(28, '2024/02/28', '00:00', '00:00')        -- Falta el 28 de febrero
,(28, '2025/01/06', '09:00', '11:00')  -- Asiste el 6 de marzo
,(28, '2025/01/13', '09:00', '11:00')  -- Asiste el 13 de marzo
,(28, '2025/01/20', '09:00', '11:00')  -- Asiste el 20 de marzo

-- Programación II (Miércoles 14:00-16:00)
,(29, '2024/04/03', '00:00', '00:00')        -- Falta el 3 de abril
,(29, '2024/02/07', '14:00', '16:00')  -- Asiste el 7 de febrero
,(29, '2024/02/14', '00:00', '00:00')        -- Falta el 14 de febrero
,(29, '2024/02/21', '14:00', '16:00')  -- Asiste el 21 de febrero
,(29, '2024/02/28', '14:00', '16:00')  -- Asiste el 28 de febrero
,(29, '2024/03/06', '14:00', '16:00')  -- Asiste el 6 de marzo
,(29, '2025/01/13', '14:00', '16:00')  -- Asiste el 13 de marzo
,(29, '2025/01/20', '00:00', '00:00')        -- Falta el 20 de marzo
,(29, '2025/02/10', '14:00', '16:00')  -- Asiste el 10 de abril

-- Fundamentos de Electrónica (Jueves 9:00-11:00)
,(30, '2024/02/08', '09:00', '11:00')  -- Asiste el 8 de febrero
,(30, '2024/02/15', '09:00', '11:00')  -- Asiste el 15 de febrero
,(30, '2024/02/22', '00:00', '00:00')        -- Falta el 22 de febrero
,(30, '2024/02/29', '09:00', '11:00')  -- Asiste el 29 de febrero
,(30, '2025/01/07', '09:00', '11:00')  -- Asiste el 7 de marzo
,(30, '2025/01/14', '09:00', '11:00')  -- Asiste el 14 de marzo
,(30, '2025/01/21', '09:00', '11:00')  -- Asiste el 21 de marzo

-- Programación II (Jueves 14:00-16:00)
,(31, '2024/02/08', '14:00', '16:00')  -- Asiste el 8 de febrero
,(31, '2024/02/15', '14:00', '16:00')  -- Asiste el 15 de febrero
,(31, '2024/02/22', '14:00', '16:00')  -- Asiste el 22 de febrero
,(31, '2024/02/29', '00:00', '00:00')        -- Falta el 29 de febrero
,(31, '2025/01/07', '14:00', '16:00')  -- Asiste el 7 de marzo
,(31, '2025/01/14', '14:00', '16:00')  -- Asiste el 14 de marzo
,(31, '2025/01/21', '00:00', '00:00')        -- Falta el 21 de marzo

-- Análisis Socioeconómico (Viernes 9:00-11:00)
,(32, '2024/02/09', '09:00', '11:00')  -- Asiste el 9 de febrero
,(32, '2024/02/16', '00:00', '00:00')        -- Falta el 16 de febrero
,(32, '2024/02/23', '09:00', '11:00')  -- Asiste el 23 de febrero
,(32, '2024/03/01', '09:00', '11:00')  -- Asiste el 1 de marzo
,(32, '2025/01/08', '09:00', '11:00')  -- Asiste el 8 de enero
,(32, '2025/01/15', '09:00', '11:00')  -- Asiste el 15 de enero
,(32, '2025/02/07', '00:00', '00:00')        -- Falta el 7 de febrero

-- Mate compu (Viernes 16:00-18:00)
,(33, '2024/02/09', '16:00', '18:00')  -- Asiste el 9 de febrero
,(33, '2024/02/16', '16:00', '18:00')  -- Asiste el 16 de febrero
,(33, '2024/02/23', '00:00', '00:00')        -- Falta el 23 de febrero
,(33, '2024/03/01', '16:00', '18:00')  -- Asiste el 1 de marzo
,(33, '2025/01/08', '16:00', '18:00')  -- Asiste el 8 de enero
,(33, '2025/01/15', '00:00', '00:00')        -- Falta el 15 de enero
,(33, '2025/02/07', '16:00', '18:00') -- Asiste el 7 de febrero

-- Sebas (IdInscripcion = 34 a 43)
-- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,(34, '2024/02/05', '09:00', '11:00')  -- Asiste el 5 de febrero
,(34, '2024/02/12', '00:00', '00:00')        -- Falta el 12 de febrero
,(34, '2024/02/19', '09:00', '11:00')  -- Asiste el 19 de febrero
,(34, '2024/02/26', '09:00', '11:00')  -- Asiste el 26 de febrero
,(34, '2025/01/04', '09:00', '11:00')  -- Asiste el 4 de marzo
,(34, '2025/02/10', '09:00', '11:00')  -- Asiste el 11 de marzo
,(34, '2025/02/10', '00:00', '00:00')        -- Falta el 18 de enero

-- Mate compu (Lunes 14:00-16:00)
,(35, '2024/02/05', '14:00', '16:00')  -- Asiste el 5 de febrero
,(35, '2024/02/12', '14:00', '16:00')  -- Asiste el 12 de febrero
,(35, '2024/02/19', '14:00', '16:00')  -- Asiste el 19 de febrero
,(35, '2024/02/26', '00:00', '00:00')        -- Falta el 26 de febrero
,(35, '2025/01/04', '14:00', '16:00')  -- Asiste el 4 de marzo
,(35, '2025/01/11', '14:00', '16:00')  -- Asiste el 11 de marzo
,(35, '2025/02/10', '14:00', '16:00')  -- Asiste el 18 de enero

-- Fundamentos de Electrónica (Martes 9:00-11:00)
,(36, '2024/02/06', '09:00', '11:00')  -- Asiste el 6 de febrero
,(36, '2024/02/13', '09:00', '11:00')  -- Asiste el 13 de febrero
,(36, '2024/02/20', '09:00', '11:00')  -- Asiste el 20 de febrero
,(36, '2024/02/27', '09:00', '11:00')  -- Asiste el 27 de febrero
,(36, '2025/01/05', '00:00', '00:00')        -- Falta el 5 de marzo
,(36, '2025/01/12', '09:00', '11:00')  -- Asiste el 12 de marzo
,(36, '2025/01/19', '09:00', '11:00')  -- Asiste el 19 de marzo

-- Clubes (Martes 14:00-16:00)
,(37, '2024/02/06', '14:00', '16:00')  -- Asiste el 6 de febrero
,(37, '2024/02/13', '00:00', '00:00')        -- Falta el 13 de febrero
,(37, '2024/02/20', '14:00', '16:00')  -- Asiste el 20 de febrero
,(37, '2024/02/27', '14:00', '16:00')  -- Asiste el 27 de febrero
,(37, '2024/03/05', '14:00', '16:00')  -- Asiste el 5 de marzo
,(37, '2024/03/12', '14:00', '16:00')  -- Asiste el 12 de marzo
,(37, '2025/01/19', '00:00', '00:00')        -- Falta el 19 de marzo
,(37, '2025/01/02', '00:00', '00:00')        -- Falta el 2 de abril
,(37, '2025/01/09', '14:00', '15:30')  -- Sale temprano

-- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,(38, '2024/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero
,(38, '2024/02/14', '09:00', '11:00')  -- Asiste el 14 de febrero
,(38, '2024/02/21', '00:00', '00:00')        -- Falta el 21 de febrero
,(38, '2024/02/28', '09:00', '11:00')  -- Asiste el 28 de febrero
,(38, '2025/01/06', '09:00', '11:00')  -- Asiste el 6 de marzo
,(38, '2025/01/13', '09:00', '11:00')  -- Asiste el 13 de marzo
,(38, '2025/01/20', '09:00', '11:00')  -- Asiste el 20 de marzo

-- Programación II (Miércoles 14:00-16:00)
,(39, '2024/02/07', '14:00', '16:00')  -- Asiste el 7 de febrero
,(39, '2024/02/14', '14:00', '16:00')  -- Asiste el 14 de febrero
,(39, '2024/02/21', '14:00', '16:00')  -- Asiste el 21 de febrero
,(39, '2024/02/28', '00:00', '00:00')        -- Falta el 28 de febrero
,(39, '2025/01/06', '14:00', '16:00')  -- Asiste el 6 de marzo
,(39, '2025/01/13', '14:00', '16:00')  -- Asiste el 13 de marzo
,(39, '2025/01/20', '14:00', '16:00')  -- Asiste el 20 de marzo

-- Fundamentos de Electrónica (Jueves 9:00-11:00)
,(40, '2024/02/08', '09:00', '11:00')  -- Asiste el 8 de febrero
,(40, '2024/02/15', '09:00', '11:00')  -- Asiste el 15 de febrero
,(40, '2024/02/22', '09:00', '11:00')  -- Asiste el 22 de febrero
,(40, '2024/02/29', '09:00', '11:00')  -- Asiste el 29 de febrero
,(40, '2025/01/07', '00:00', '00:00')        -- Falta el 7 de marzo
,(40, '2025/01/14', '09:00', '11:00')  -- Asiste el 14 de marzo
,(40, '2025/01/21', '09:00', '11:00')  -- Asiste el 21 de marzo

-- Programación II (Jueves 14:00-16:00)
,(41, '2024/02/08', '14:00', '16:00')  -- Asiste el 8 de febrero
,(41, '2024/02/15', '00:00', '00:00')        -- Falta el 15 de febrero
,(41, '2024/02/22', '14:00', '16:00')  -- Asiste el 22 de febrero
,(41, '2024/02/29', '14:00', '16:00')  -- Asiste el 29 de febrero
,(41, '2024/03/07', '14:00', '16:00')  -- Asiste el 7 de marzo
,(41, '2024/03/14', '14:00', '16:00')  -- Asiste el 14 de marzo
,(41, '2025/01/21', '00:00', '00:00')        -- Falta el 21 de marzo
,(41, '2025/01/04', '00:00', '00:00')        -- Falta el 4 de abril
,(41, '2025/01/11', '14:00', '16:00')  -- Asiste el 11 de abril

-- Análisis Socioeconómico (Viernes 9:00-11:00)
,(42, '2024/02/09', '09:00', '11:00')  -- Asiste el 9 de febrero
,(42, '2024/02/16', '09:00', '11:00')  -- Asiste el 16 de febrero
,(42, '2024/02/23', '09:00', '11:00')  -- Asiste el 23 de febrero
,(42, '2024/03/01', '00:00', '00:00')        -- Falta el 1 de marzo
,(42, '2025/01/08', '09:00', '11:00')  -- Asiste el 8 de enero
,(42, '2025/01/15', '09:00', '11:00')  -- Asiste el 15 de enero
,(42, '2025/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero

-- Mate compu (Viernes 16:00-18:00)
,(43, '2024/02/09', '16:00', '18:00')  -- Asiste el 9 de febrero
,(43, '2024/02/16', '00:00', '00:00')        -- Falta el 16 de febrero
,(43, '2024/02/23', '16:00', '18:00')  -- Asiste el 23 de febrero
,(43, '2024/03/01', '16:00', '18:00')  -- Asiste el 1 de marzo
,(43, '2025/01/08', '16:00', '18:00')  -- Asiste el 8 de enero
,(43, '2025/01/15', '16:00', '18:00')  -- Asiste el 15 de enero
,(43, '2025/02/07', '00:00', '00:00')     -- Falta el 7 de febrero

-- Hector (IdInscripcion = 44 a 53)
-- Ecuaciones Diferenciales (Lunes 9:00-11:00)
,(44, '2024/02/05', '09:00', '11:00')  -- Asiste el 5 de febrero
,(44, '2024/02/12', '09:00', '11:00')  -- Asiste el 12 de febrero
,(44, '2024/02/19', '09:00', '11:00')  -- Asiste el 19 de febrero
,(44, '2024/02/26', '00:00', '00:00')        -- Falta el 26 de febrero
,(44, '2025/01/04', '09:00', '11:00')  -- Asiste el 4 de marzo
,(44, '2025/01/11', '09:00', '11:00')  -- Asiste el 11 de marzo
,(44, '2025/02/10', '09:00', '11:00')  -- Asiste el 18 de enero

-- Mate compu (Lunes 14:00-16:00)
,(45, '2024/02/05', '14:00', '16:00')  -- Asiste el 5 de febrero
,(45, '2024/02/12', '00:00', '00:00')        -- Falta el 12 de febrero
,(45, '2024/02/19', '14:00', '16:00')  -- Asiste el 19 de febrero
,(45, '2024/02/26', '14:00', '16:00')  -- Asiste el 26 de febrero
,(45, '2025/01/04', '14:00', '16:00')  -- Asiste el 4 de marzo
,(45, '2025/01/11', '14:00', '16:00')  -- Asiste el 11 de marzo
,(45, '2025/02/10', '00:00', '00:00')        -- Falta el 18 de enero

-- Fundamentos de Electrónica (Martes 9:00-11:00)
,(46, '2024/02/06', '09:00', '11:00')  -- Asiste el 6 de febrero
,(46, '2024/02/13', '09:00', '11:00')  -- Asiste el 13 de febrero
,(46, '2024/02/20', '00:00', '00:00')        -- Falta el 20 de febrero
,(46, '2024/02/27', '09:00', '11:00')  -- Asiste el 27 de febrero
,(46, '2025/01/05', '09:00', '11:00')  -- Asiste el 5 de marzo
,(46, '2025/01/12', '09:00', '11:00')  -- Asiste el 12 de marzo
,(46, '2025/01/19', '09:00', '11:00')  -- Asiste el 19 de marzo

-- Clubes (Martes 14:00-16:00)
,(47, '2024/02/06', '14:00', '16:00')  -- Asiste el 6 de febrero
,(47, '2024/02/13', '14:00', '16:00')  -- Asiste el 13 de febrero
,(47, '2024/02/20', '14:00', '16:00')  -- Asiste el 20 de febrero
,(47, '2024/02/27', '00:00', '00:00')        -- Falta el 27 de febrero
,(47, '2025/01/05', '14:00', '16:00')  -- Asiste el 5 de marzo
,(47, '2025/01/12', '14:00', '16:00')  -- Asiste el 12 de marzo
,(47, '2025/01/19', '14:00', '16:00')  -- Asiste el 19 de marzo

-- Ecuaciones Diferenciales (Miércoles 9:00-11:00)
,(48, '2024/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero
,(48, '2024/02/14', '00:00', '00:00')        -- Falta el 14 de febrero
,(48, '2024/02/21', '09:00', '11:00')  -- Asiste el 21 de febrero
,(48, '2024/02/28', '09:00', '11:00')  -- Asiste el 28 de febrero
,(48, '2024/03/06', '09:00', '11:00')  -- Asiste el 6 de marzo
,(48, '2024/03/13', '09:00', '11:00')  -- Asiste el 13 de marzo
,(48, '2025/01/20', '09:00', '11:00')  -- Asiste el 20 de marzo
,(48, '2025/01/03', '09:00', '10:00')  -- Sale temprano
,(48, '2025/02/10', '00:00', '00:00')        -- Falta el 10 de abril
-- Programación II (Miércoles 14:00-16:00)
,(49, '2024/02/07', '14:00', '16:00')  -- Asiste el 7 de febrero
,(49, '2024/02/14', '14:00', '16:00')  -- Asiste el 14 de febrero
,(49, '2024/02/21', '14:00', '16:00')  -- Asiste el 21 de febrero
,(49, '2024/02/28', '00:00', '00:00')        -- Falta el 28 de febrero
,(49, '2025/01/06', '14:00', '16:00')  -- Asiste el 6 de marzo
,(49, '2025/01/13', '14:00', '16:00')  -- Asiste el 13 de marzo
,(49, '2025/01/20', '14:00', '16:00')  -- Asiste el 20 de marzo

-- Fundamentos de Electrónica (Jueves 9:00-11:00)
,(50, '2024/02/08', '09:00', '11:00')  -- Asiste el 8 de febrero
,(50, '2024/02/15', '09:00', '11:00')  -- Asiste el 15 de febrero
,(50, '2024/02/22', '09:00', '11:00')  -- Asiste el 22 de febrero
,(50, '2024/02/29', '09:00', '11:00')  -- Asiste el 29 de febrero
,(50, '2025/01/07', '00:00', '00:00')        -- Falta el 7 de marzo
,(50, '2025/01/14', '09:00', '11:00')  -- Asiste el 14 de marzo
,(50, '2025/01/21', '09:00', '11:00')  -- Asiste el 21 de marzo

-- Programación II (Jueves 14:00-16:00)
,(51, '2024/02/08', '14:00', '16:00')  -- Asiste el 8 de febrero
,(51, '2024/02/15', '14:00', '16:00')  -- Asiste el 15 de febrero
,(51, '2024/02/22', '00:00', '00:00')        -- Falta el 22 de febrero
,(51, '2024/02/29', '14:00', '16:00')  -- Asiste el 29 de febrero
,(51, '2024/03/07', '14:00', '16:00')  -- Asiste el 7 de marzo
,(51, '2024/03/14', '14:00', '16:00')  -- Asiste el 14 de marzo
,(51, '2025/01/21', '14:00', '16:00')  -- Asiste el 21 de marzo
,(51, '2025/01/04', '14:00', '16:00')  -- Asiste el 4 de abril
,(51, '2025/01/11', '00:00', '00:00')        -- Falta el 11 de abril
-- Análisis Socioeconómico (Viernes 9:00-11:00)
,(52, '2024/02/09', '09:00', '11:00')  -- Asiste el 9 de febrero
,(52, '2024/02/16', '09:00', '11:00')  -- Asiste el 16 de febrero
,(52, '2024/02/23', '09:00', '11:00')  -- Asiste el 23 de febrero
,(52, '2024/03/01', '00:00', '00:00')        -- Falta el 1 de marzo
,(52, '2024/03/08', '09:00', '11:00')  -- Asiste el 8 de enero
,(52, '2024/03/15', '09:00', '11:00')  -- Asiste el 15 de enero
,(52, '2025/02/07', '09:00', '11:00')  -- Asiste el 7 de febrero
,(52, '2025/01/05', '00:00', '00:00')        -- Falta el 5 de abril
,(52, '2025/01/12', '09:00', '11:00') -- Asiste el 12 de abril
-- Mate compu (Viernes 16:00-18:00)
,(53, '2024/02/09', '16:00', '18:00')  -- Asiste el 9 de febrero
,(53, '2024/02/16', '16:00', '18:00')  -- Asiste el 16 de febrero
,(53, '2024/02/23', '00:00', '00:00')        -- Falta el 23 de febrero
,(53, '2024/03/01', '16:00', '18:00')  -- Asiste el 1 de marzo
,(53, '2025/01/08', '16:00', '18:00')  -- Asiste el 8 de enero
,(53, '2025/01/15', '16:00', '18:00')  -- Asiste el 15 de enero
,(53, '2025/02/07', '00:00', '00:00');       -- Falta el 7 de febrero