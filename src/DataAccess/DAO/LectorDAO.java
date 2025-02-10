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
import DataAccess.DTO.LectorDTO;

public class LectorDAO extends SQLiteDataHelper implements IDAO<LectorDTO>{

    @Override
    public LectorDTO readBy(Integer id) throws Exception {
        LectorDTO lector = new LectorDTO();
        String query = "SELECT IdLector"
                     + " ,CodigoAula"
                     + " ,Estado"  
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Lector WHERE Estado = 'A' AND IdLector = ?" + id.toString();

                try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        lector = new LectorDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                    }
                } catch (SQLException e) {
                    throw e;
                }
                return lector; 
    }

    @Override
    public List<LectorDTO> readAll() throws Exception {
        List<LectorDTO> lectores = new ArrayList<>();
        String query = "SELECT IdLector"
                     + " ,CodigoAula"
                     + " ,Estado"  
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Lector WHERE Estado = 'A'";

                try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        LectorDTO lector = new LectorDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                        lectores.add(lector);
                    }
                } catch (SQLException e) {
                    throw e;
                }
                return lectores; 
    }

    @Override
    public boolean create(LectorDTO entity) throws Exception {
         String query = "INSERT INTO Lector (iDLector, CodigoAula) VALUES (?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, entity.getIdLector());
            pstmt.setString(2, entity.getCodigoAula());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(LectorDTO entity) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Lector SET iDLector = ?, CodigoAula = ?, FechaModifica = ? WHERE IdLector = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getIdLector());
            pstmt.setString(2, entity.getCodigoAula());
            pstmt.setString(3, now.format(formatter));
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Lector SET Estado = ? WHERE IdLector = ?";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e;
        }

    }

}
