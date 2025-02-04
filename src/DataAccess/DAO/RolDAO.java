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
import DataAccess.DTO.RolDTO;

public class RolDAO extends SQLiteDataHelper implements IDAO<RolDTO>{

    @Override
    public RolDTO readBy(Integer id) throws Exception {
        RolDTO rol = new RolDTO();
        String query = "SELECT IdRol"
                     + " ,Nombre"
                     + " ,Estado"
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Rol WHERE Estado = 'A' AND IdRol = " + id.toString();

                    try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        rol = new RolDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
                return rol;  
    }

    @Override
    public List<RolDTO> readAll() throws Exception {
        List<RolDTO> roles = new ArrayList<RolDTO>();
        String query = "SELECT IdRol"
                     + " ,Nombre"
                     + " ,Estado"
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Rol WHERE Estado = 'A'";

                    try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        RolDTO rol = new RolDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5));
                        roles.add(rol);
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
                return roles;  
    }

    @Override
    public boolean create(RolDTO entity) throws Exception {
        String query = "INSERT INTO Rol (Nombre) VALUES (?)";
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
    public boolean update(RolDTO entity) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Rol SET Nombre = ? FechaModifica = ? WHERE IdRol = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, now.format(formatter));            
            pstmt.setString(3, entity.getIdRol());  
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Rol SET Estado = ? WHERE IdRol = ?";
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

