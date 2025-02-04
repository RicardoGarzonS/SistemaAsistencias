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
import DataAccess.DTO.DiaDTO;

public class DiaDAO extends SQLiteDataHelper implements IDAO<DiaDTO>{

    @Override
    public DiaDTO readBy(Integer id) throws Exception {
        DiaDTO dia = new DiaDTO();
        String query = "SELECT IdDia"
                    + " ,Nombre"
                    + " ,Estado"
                    + " ,FechaCreacion"
                    + " ,FechaModificacion"
                    + " FROM Dia WHERE Estado = 'A' AND IdDia = " + id.toString();
                try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        dia = new DiaDTO( 
                          rs.getString (1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
                return dia; 
        
    }

    @Override
    public List<DiaDTO> readAll() throws Exception {
        List<DiaDTO> Dias = new ArrayList<DiaDTO>();
        String query = "SELECT IdDia"
                    + " ,Nombre"
                    + " ,Estado"
                    + " ,FechaCreacion"
                    + " ,FechaModificacion"
                    + " FROM Dia WHERE Estado = 'A'" ;
                try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        DiaDTO dia = new DiaDTO( 
                          rs.getString (1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                        Dias.add(dia);
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
                return Dias; 
        
    }

    @Override
    public boolean create(DiaDTO entity) throws Exception {
        String query = "INSERT INTO Dia (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(DiaDTO entity) throws Exception {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Dia SET Nombre = ?, FechaModifica = ? WHERE IdDia = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, now.format(formatter));
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Dia SET Estado = ? WHERE IdDia = ?";
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
