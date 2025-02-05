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
import DataAccess.DTO.InscripcionDTO;

public class InscripcionDAO extends SQLiteDataHelper implements IDAO<InscripcionDTO>{

    @Override
    public InscripcionDTO readBy(Integer id) throws Exception { 
     InscripcionDTO Isn = new InscripcionDTO();
     String query = "SELECT IdInscripcion"
                    + ",IdUsuario"
                    + ",IdClase"
                    + ",IdLector"
                    + ",Año"
                    + ",Estado"
                    + ",FechaCreacion"
                    + ",FechaModificacion"
                    + " FROM Inscripcion WHERE Estado = 'A' AND IdInscripcion = " + id.toString();

                    try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        Isn = new InscripcionDTO(
                              rs.getString(1)
                            , rs.getString(2)
                            , rs.getString(3)       
                            , rs.getString(4)       
                            , rs.getString(5)       
                            , rs.getString(6)       
                            , rs.getString(7)       
                            , rs.getString(8));      
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
        return Isn;
            
        
    }

    @Override
    public List<InscripcionDTO> readAll() throws Exception {
     List<InscripcionDTO> Isn = new ArrayList<>();
     String query = "SELECT IdInscripcion"
                    + ",IdUsuario"
                    + ",IdClase"
                    + ",IdLector"
                    + ",Año"
                    + ",Estado"
                    + ",FechaCreacion"
                    + ",FechaModificacion"
                    + " FROM Inscripcion WHERE Estado = 'A'"; 

                    try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        InscripcionDTO u = new InscripcionDTO(
                              rs.getString(1)
                            , rs.getString(2)
                            , rs.getString(3)       
                            , rs.getString(4)       
                            , rs.getString(5)       
                            , rs.getString(6)       
                            , rs.getString(7)       
                            , rs.getString(8));    
                        Isn.add(u);  
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
        return Isn;
    }

    @Override
    public boolean create(InscripcionDTO entity) throws Exception {
        String query = "INSERT INTO Inscripcion (IdUsuario, IdClase, IdLector, Año) VALUES (?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, entity.getIdUsuario());
            pstmt.setString(2, entity.getIdClase());
            pstmt.setString(3, entity.getIdLector());
            pstmt.setString(4, entity.getAño());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(InscripcionDTO entity) throws Exception {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Inscripcion SET IdUsuario = ?, IdClase = ?, IdLector = ?, Año = ?, FechaModifica = ? WHERE IdInscripcion = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getIdUsuario());
            pstmt.setString(2, entity.getIdClase());
            pstmt.setString(3, entity.getIdLector());
            pstmt.setString(4, entity.getAño());
            pstmt.setString(5, formatter.format(now).toString());
            pstmt.setString(6, entity.getIdInscripcion());
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
        throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
    }
}
    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Inscripcion SET Estado = ? WHERE IdInscripcion = ?";
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

    public String getFechaInscripcion (Integer idUsuario, Integer idMateria) throws Exception {
        String fecha = null;
        String query =  "SELECT i.FechaCreacion FROM Inscripcion i " + 
                        "JOIN Clase c on i.IDClase = c.IDClase " + 
                        "WHERE i.IdUsuario = ? AND c.IDMateria = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idMateria);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                fecha = rs.getString(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return fecha;
    }
}