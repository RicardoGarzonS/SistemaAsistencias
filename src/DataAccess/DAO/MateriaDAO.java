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
import DataAccess.DTO.MateriaDTO;

public class MateriaDAO extends SQLiteDataHelper implements IDAO<MateriaDTO>{

    @Override
    public MateriaDTO readBy(Integer id) throws Exception {
        MateriaDTO materia = new MateriaDTO();
        String query = "SELECT IdMateria "
                     + " ,Nombre"        
                     + " ,Estado"
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Materia WHERE Estado = 'A' AND IdMateria = ?" + id.toString();

      try {
             Connection conn = openConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(query);
             while (rs.next()) {
                 materia = new MateriaDTO( 
                   rs.getString(1)
                 , rs.getString(2)
                 , rs.getString(3)
                 , rs.getString(4)
                 , rs.getString(5));
            }
        } catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
        }
        return materia;  
    }
    @Override
    public List<MateriaDTO> readAll() throws Exception {
        List<MateriaDTO> materias = new ArrayList<>();
        String query = "SELECT IdMateria "
                     + " ,Nombre"        
                     + " ,Estado"
                     + " ,FechaCreacion"
                     + " ,FechaModificacion"
                     + " FROM Materia WHERE Estado = 'A'";

      try {
             Connection conn = openConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(query);
             while (rs.next()) {
                 MateriaDTO materia = new MateriaDTO( 
                   rs.getString(1)
                 , rs.getString(2)
                 , rs.getString(3)
                 , rs.getString(4)
                 , rs.getString(5));
                 materias.add(materia);
            }
        } catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
        }
        return materias;  
        
    }

    @Override
    public boolean create(MateriaDTO entity) throws Exception {
        String query = "INSERT INTO Materia (Nombre) VALUES (?)";
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
    public boolean update(MateriaDTO entity) throws Exception {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Materia SET Nombre = ?, FechaModifica = ? WHERE IdMateria = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, now.format(formatter));
            pstmt.setString(3, entity.getIdMateria());
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
        }
        
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Materia SET Estado = ? WHERE IdMateria = ?";
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
