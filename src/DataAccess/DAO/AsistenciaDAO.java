package DataAccess.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import BusinessLogic.InscripcionBL;
import BusinessLogic.MateriaBl;
import BusinessLogic.UsuarioBL;
import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.AsistenciaDTO;

public class AsistenciaDAO extends SQLiteDataHelper implements IDAO<AsistenciaDTO>{

    @Override
    public AsistenciaDTO readBy(Integer id) throws Exception {
        AsistenciaDTO Asis = new AsistenciaDTO();
        String query = "SELECT IdAsistencia"
                    + ", IdInscripcion"
                    + ", Fecha"
                    + ", HoraEntrada"
                    + ", HoraSalida"     
                    + ", Justificacion"
                    + ", Estado"
                    + ", FechaCreacion"
                    + ", FechaModificacion"
                    + " FROM Asistencia WHERE Estado = 'A' AND IdAsistencia = " + id.toString();
                  try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        Asis = new AsistenciaDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                        , rs.getString(6)
                        , rs.getString(7)
                        , rs.getString(8)
                        , rs.getString(9));
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
        return Asis;
        
    }

    @Override
    public List<AsistenciaDTO> readAll() throws Exception {
         List<AsistenciaDTO> Asis = new ArrayList<>();
         String query = "SELECT IdAsistencia"
                    + ", IdInscripcion"
                    + ", Fecha"
                    + ", HoraEntrada"
                    + ", HoraSalida"     
                    + ", Justificacion"
                    + ", Estado"
                    + ", FechaCreacion"
                    + ", FechaModificacion"
                    + " FROM Asistencia WHERE Estado = 'A'";
                  try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        AsistenciaDTO u = new AsistenciaDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                        , rs.getString(6)
                        , rs.getString(7)
                        , rs.getString(8)
                        , rs.getString(9));
                        Asis.add(u);
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
        return Asis;
    }

    @Override
    public boolean create(AsistenciaDTO entity) throws Exception {
        String query = "INSERT INTO Asistencia (IdInscripcion, Fecha) VALUES (?, ?)";
        try (Connection conn = openConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getIdInscripcion());
            pstmt.setString(2, entity.getFecha());
            pstmt.executeUpdate();
            return true; 
        } catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "create()");
        }
    }

    public boolean create(AsistenciaDTO entity, Connection conn) throws Exception {
        String query = "INSERT INTO Asistencia (IdInscripcion, Fecha) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, entity.getIdInscripcion());
            pstmt.setString(2, entity.getFecha());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e; //new Exception(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(AsistenciaDTO entity) throws Exception {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Asistencia SET HoraEntrada = ?, HoraSalida = ?, FechaModifica = ? WHERE IdAsistencia = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(2, entity.getHoraEntrada());
            pstmt.setString(3, entity.getHoraSalida());
            pstmt.setString(5, formatter.format(now).toString());
            pstmt.setString(6, entity.getIdAsistencia());
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Asistencia SET Estado = ? WHERE IdAsistencia = ?";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "delete()");
        }
    }
    
    public Integer contarAsistenciasMateriaEspecifica (Integer idUsuario ,String fechaActual,Integer idMateria) throws Exception {
        InscripcionBL iBL = new InscripcionBL();
        String fechaInscripcion = iBL.getFechaInscripcion(idUsuario , idMateria);
        int totalRegistros = 0;
        String query =  " SELECT COUNT(*) AS TotalReg " +
                        " FROM Asistencia a " +
                        " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                        " JOIN Clase c ON i.IdClase = c.IdClase " +
                        " WHERE i.IdUsuario = " + idUsuario.toString() +
                        " AND c.IdMateria = " + idMateria.toString() +
                        " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                totalRegistros = rs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw e;
        }
        return totalRegistros;
    }

    public Integer contarAsistenciasEstudianteEspecifico (String CorreoEstudiante, String fechaActual, String nombreMateria) throws Exception {
        MateriaBl mBl = new MateriaBl();
        InscripcionBL iBl = new InscripcionBL();
        UsuarioBL uBl = new UsuarioBL();
        int idMateria = mBl.getIdMateria(nombreMateria);
        int idUsuario = uBl.getIdUsuarioPorCorreo(CorreoEstudiante);
        String fechaInscripcion = iBl.getFechaInscripcion(idUsuario, idMateria);

        String query = " SELECT COUNT (*) AS TotalReg " +
                       " FROM Asistencia a " +
                       " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                       " JOIN Clase c ON i.IdClase = c.IdClase " +
                       " WHERE i.IdUsuario = " + idUsuario +
                       " AND c.IdMateria = " + idMateria +
                       " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')";

        int totalRegistros = 0;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                totalRegistros = rs.getInt("TotalReg");
            }
        } catch (SQLException e) {
            throw e;
        }
        return totalRegistros;
    }

    public List<AsistenciaDTO> buscarAsistenciaPorUsuarioFechaLector(Integer idUsuario, String fecha, Integer idLector) throws Exception {
        List<AsistenciaDTO> asistencias = new ArrayList<>();
        String query = "SELECT a.IdAsistencia, a.IdInscripcion, a.Fecha, a.HoraEntrada, a.HoraSalida, a.Justificacion, a.Estado, a.FechaCreacion, a.FechaModificacion " 
                       + "FROM Asistencia a " 
                       + "JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " 
                       + "WHERE i.IdUsuario = ? AND a.Fecha = ? AND i.IdLector = ? AND a.Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            pstmt.setString(2, fecha);
            pstmt.setInt(3, idLector);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AsistenciaDTO asistencia = new AsistenciaDTO(
                    rs.getString("IdAsistencia"),
                    rs.getString("IdInscripcion"),
                    rs.getString("Fecha"),
                    rs.getString("HoraEntrada"),
                    rs.getString("HoraSalida"),
                    rs.getString("Justificacion"),
                    rs.getString("Estado"),
                    rs.getString("FechaCreacion"),
                    rs.getString("FechaModificacion")
                );
                asistencias.add(asistencia);
            }
        } catch (SQLException e) {
            throw e;
        }
        return asistencias;
    }

    public boolean updateJustificacion(Integer idAsistencia, String justificacion) throws Exception {
        String query = "UPDATE Asistencia SET Justificacion = ? WHERE IdAsistencia = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, justificacion);
            pstmt.setInt(2, idAsistencia);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    

    public String [] contarAsistenciasTotalMaterias (Integer idUsuario, String fechaActual) throws Exception {
        InscripcionBL iBL = new InscripcionBL();
        MateriaBl mBl = new MateriaBl();
        String [] materias = iBL.getMateriaInscritas(idUsuario);
        int idMateria = mBl.getIdMateria(materias[0]);
        String fechaInscripcion = iBL.getFechaInscripcion(idUsuario , idMateria);
        String [] asistencias = new String [materias.length];
        String query =  " SELECT COUNT(*) AS TotalReg " +
                        " FROM Asistencia a " +
                        " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                        " JOIN Clase c ON i.IdClase = c.IdClase " +
                        " WHERE i.IdUsuario = " + idUsuario.toString() +
                        " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')" + 
                        " AND c.IdMateria = ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            for (int i = 0; i < materias.length; i++) {
                ResultSet rs = stmt.executeQuery(query + mBl.getIdMateria(materias[i]));
                if (rs.next()) {
                    asistencias[i] = rs.getString("TotalReg") + " - " + materias[i];
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return asistencias;
    }

    public String [] contarAsistenciasTotalEstudiantes (String nombreMateria, String fechaActual) throws Exception {
        MateriaBl mBl = new MateriaBl();
        InscripcionBL iBl = new InscripcionBL();
        int idMateria = mBl.getIdMateria(nombreMateria);
        String [] idEstudiantes = iBl.getIdEstudiantesPorMateria(idMateria);
        String [] correoEstudiantes = iBl.getCorreosEstudiantesPorMateria(idMateria); 
        int idEstReferenciaFecha = Integer.parseInt(idEstudiantes[0]);
        String fechaInscripcion = iBl.getFechaInscripcion(idEstReferenciaFecha, idMateria);
        String [] asistencias = new String [idEstudiantes.length];
        String query = " SELECT COUNT (*) AS TotalReg " +
                       " FROM Asistencia a " +
                       " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                       " JOIN Clase c ON i.IdClase = c.IdClase " +
                       " WHERE c.IdMateria = " + idMateria +
                       " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')" +
                       " AND i.IdUsuario = ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            for (int i = 0; i < idEstudiantes.length; i++) {
                ResultSet rs = stmt.executeQuery(query + idEstudiantes[i]);
                if (rs.next()) {
                    asistencias[i] = rs.getString("TotalReg") + " - " + correoEstudiantes[i];
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return asistencias;

    } 
    
    
    public String [][] tablaAsistenciasTotalMateriasE (int idEstudiante, String fechaActual) throws Exception{
        InscripcionBL iBL = new InscripcionBL();
        MateriaBl mBl = new MateriaBl();
        int temporal = 0;
        String [] materias = iBL.getMateriaInscritas(idEstudiante);
        String [] materiasSinRepeticion = eliminarRepeticion(materias);
        Integer [] idMaterias = new Integer [materiasSinRepeticion.length];
        String [] horaInicio = iBL.getHoraInicioTotalMaterias(idEstudiante);
        String [] horaFin = iBL.getHoraFinTotalMaterias(idEstudiante);
        String fechaInscripcion = iBL.getFechaInscripcion(idEstudiante, mBl.getIdMateria(materias[0]));
        for (int i = 0; i < materiasSinRepeticion.length; i++) {
            idMaterias[i] = mBl.getIdMateria(materiasSinRepeticion[i]);
        }
        int totalRegistros = contarRegistrosTotalMaterias(idEstudiante, idMaterias, fechaActual, fechaInscripcion);
        String [][] asistencias = new String [totalRegistros][5];
        String query = "SELECT a.IdAsistencia,a.Fecha, a.HoraEntrada, a.HoraSalida, m.Nombre" + 
                        " FROM Asistencia a " +
                        " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                        " JOIN Clase c ON i.IdClase = c.IdClase" +
                        " JOIN Materia m on c.IdMateria = m.IdMateria " +
                        " WHERE i.IdUsuario = " + idEstudiante +
                        " AND m.IdMateria = ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            for (int i = 0; i < materiasSinRepeticion.length; i++) {
                ResultSet rs = stmt.executeQuery(query + idMaterias[i]);
                int totalRegistrosMateria = contarRegistrosidMateria(idEstudiante, idMaterias[i], fechaActual, fechaInscripcion);

                for (int j = temporal; j<totalRegistrosMateria + temporal; j++){
                    if (rs.next()) {
                        int idAsistencia = rs.getInt("IdAsistencia");
                        asistencias[j][0] = rs.getString("Fecha");
                        asistencias[j][1] = rs.getString("HoraEntrada");
                        asistencias[j][2] = rs.getString("HoraSalida");
                        asistencias[j][3] = rs.getString("Nombre");
                        asistencias[j][4] = determinarTipoAsistencias(horaInicio[i], horaFin[1], idAsistencia);
                    }
                }
                temporal += totalRegistrosMateria;
            }
        } catch (SQLException e) {
            throw e;
        }
        return asistencias;
    }

    public int contarRegistrosTotalMaterias (int idEstudiante, Integer[] idMaterias, String fechaActual, String fechaInscripcion) throws Exception {
        int totalRegistros = 0;
        String query = " SELECT COUNT(*) AS TotalReg " +
                       " FROM Asistencia a " +
                       " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                       " JOIN Clase c ON i.IdClase = c.IdClase " +
                       " WHERE i.IdUsuario = " + idEstudiante +
                       " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')" +
                       " AND c.IdMateria = ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            for (int i = 0; i < idMaterias.length; i++) {
                ResultSet rs = stmt.executeQuery(query + idMaterias[i]);
                if (rs.next()) {
                    totalRegistros += rs.getInt("TotalReg");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return totalRegistros;
    }

    public int contarRegistrosidMateria (int idEstudiante, int idMaterias, String fechaActual, String fechaInscripcion) throws Exception {
        int totalRegistros = 0;
        String query = " SELECT COUNT(*) AS TotalReg " +
                       " FROM Asistencia a " +
                       " JOIN Inscripcion i ON a.IdInscripcion = i.IdInscripcion " +
                       " JOIN Clase c ON i.IdClase = c.IdClase " +
                       " WHERE i.IdUsuario = " + idEstudiante +
                       " AND DATE('" + fechaActual + "') >= DATE('" + fechaInscripcion + "')" +
                       " AND c.IdMateria = ";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query + idMaterias);
            if (rs.next()) {
                totalRegistros += rs.getInt("TotalReg");
            }
            
        } catch (SQLException e) {
            throw e;
        }
        return totalRegistros;
    }

    public String determinarTipoAsistencias (String horaInicio, String horaFin, int idAsistencia) throws Exception {
        String horaEntrada = "";
        String horaSalida = "";
        String query = " SELECT HoraEntrada, HoraSalida " +
                       " FROM Asistencia " +
                       " WHERE IdAsistencia = " + idAsistencia;
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                horaEntrada = rs.getString("HoraEntrada");
                horaSalida = rs.getString("HoraSalida");
            }
        } catch (SQLException e) {
            throw e;
        }

        int horaHoraInicio = Integer.parseInt(horaInicio.split(":")[0]);
        int horaHoraFin = Integer.parseInt(horaFin.split(":")[0]);
        int horaHoraEntrada = Integer.parseInt(horaEntrada.split(":")[0]);
        int minHoraEntrada = Integer.parseInt(horaEntrada.split(":")[1]);
        int horaHoraSalida = Integer.parseInt(horaSalida.split(":")[0]);
        int minHoraSalida = Integer.parseInt(horaSalida.split(":")[1]);

        if ((horaHoraEntrada == horaHoraInicio-1            || horaHoraEntrada == horaHoraInicio)           && 
            (minHoraEntrada >= 50 && minHoraEntrada < 60    || minHoraEntrada >= 0 && minHoraEntrada <= 15) && 
            (horaHoraSalida == horaHoraFin-1                || horaHoraSalida == horaHoraFin)               &&
            (minHoraSalida >= 50 && minHoraSalida < 60    || minHoraSalida >= 0 && minHoraSalida <= 15)) {
            return "2";
        } else if ((horaHoraEntrada == horaHoraInicio && (minHoraEntrada > 15 && minHoraEntrada < 60)) || 
                    (horaHoraSalida < horaHoraFin && (minHoraSalida >= 0 && minHoraSalida < 50))) {
            return "1";
        } else {
            return "0";
        }
        
    }

    public String [] eliminarRepeticion(String [] materias){
        HashSet<String> set = new HashSet<>();
        
        // Agregar palabras al set (automáticamente elimina los duplicados)
        for (String palabra : materias) {
            set.add(palabra);
        }
        
        // Convertir el set de vuelta a un arreglo
        return set.toArray(new String[0]);
    }
 
}
