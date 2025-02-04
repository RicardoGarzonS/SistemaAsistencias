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
         String query = "INSERT INTO Asistencia (IdAsistencia, IdInscripcion, Fecha, HoraEntrada, HoraSalida ) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getIdAsistencia());
            pstmt.setString(2, entity.getIdInscripcion());
            pstmt.setString(3, entity.getFecha());
            pstmt.setString(4, entity.getHoraEntrada());
            pstmt.setString(5, entity.getHoraSalida());
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
       String query = "UPDATE Asistencia SET fecha = ?, HoraEntrada = ?, HoraSalida = ?, Justificacion = ?, FechaModifica = ? WHERE IdAsistencia = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getFecha());
            pstmt.setString(2, entity.getHoraEntrada());
            pstmt.setString(3, entity.getHoraSalida());
            pstmt.setString(4, entity.getJustificacion());
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
    
}
