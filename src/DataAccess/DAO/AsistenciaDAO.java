package DataAccess.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
         String query = "INSERT INTO Asistencia (IdInscripcion, Fecha ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(2, entity.getIdInscripcion());
            pstmt.setString(3, entity.getFecha());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "create()");
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

}
