package DataAccess.DAO;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.IDAO;
import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.UsuarioDTO;
public class UsuarioDAO extends SQLiteDataHelper implements IDAO<UsuarioDTO>{

    @Override
    public UsuarioDTO readBy(Integer id) throws Exception {
     UsuarioDTO usuario = new UsuarioDTO();
     String query = "SELECT IdUsuario"
                    + ", IdRol"
                    + ", NombreUsuario"
                    + ", Clave"
                    + ", Cedula"     
                    + ", CorreoInstitucional"
                    + ", Estado"
                    + ", FechaCreacion"
                    + ", FechaModificacion"
                    + " FROM Usuario WHERE Estado = 'A' AND IdUsuario = " + id.toString();
                  try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                        usuario = new UsuarioDTO( 
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
                    throw e;
                }
        return usuario;
    }

    @Override
    public List<UsuarioDTO> readAll() throws Exception {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        String query = "SELECT IDUsuario"
                    + ", IdRol"
                    + ", NombreUsuario"
                    + ", Clave"
                    + ", Cedula"     
                    + ", CorreoInstitucional"
                    + ", Estado"
                    + ", FechaCreacion"
                    + ", FechaModificacion"
                    + " FROM Usuario WHERE Estado = 'A'";
                    
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            while (rs.next()) {
                UsuarioDTO u = new UsuarioDTO( 
                  rs.getString(1)
                , rs.getString(2)
                , rs.getString(3)
                , rs.getString(4)
                , rs.getString(5)
                , rs.getString(6)
                , rs.getString(7)
                , rs.getString(8)
                , rs.getString(9));
                usuarios.add(u);
            }
        } catch (SQLException e) {
            throw e;
        }
        return usuarios;
    }

    @Override
    public boolean create(UsuarioDTO entity) throws Exception {
        String query = "INSERT INTO Usuario (NomberUsuario, Clave, Cedula, CorreoInstitucional ) VALUES (?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, entity.getNombreUsuario());
            pstmt.setString(2, entity.getClave());
            pstmt.setString(3, entity.getCedula());
            pstmt.setString(4, entity.getCorreoInstitucional());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean update(UsuarioDTO entity) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Usuario SET NombreUsuario = ?, Cedula = ?, Clave = ?, CorreoInstitucional = ?, FechaModifica = ? WHERE IdUsuario = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getNombreUsuario());
            pstmt.setString(2, entity.getCedula());
            pstmt.setString(3, entity.getClave());
            pstmt.setString(4, entity.getCorreoInstitucional());
            pstmt.setString(5, formatter.format(now).toString());
            pstmt.setString(6, entity.getIdUsuario());
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Usuario SET Estado = ? WHERE IdUsuario = ?";
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

    public String getCorreo(String correo) throws Exception {
        String correoUsuario = null;
        String query = "SELECT CorreoInstitucional " + "FROM Usuario WHERE Estado = 'A' AND CorreoInstitucional = " + "'" + correo + "'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next()) {
                correoUsuario = rs.getString(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return correoUsuario;
    }

    public String getNombreUsuario (int idEstudiante) throws Exception{
        String nombreUsuario = null;
        String query = "SELECT NombreUsuario " + "FROM Usuario WHERE Estado = 'A' AND IdUsuario = " + idEstudiante;
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next()) {
                nombreUsuario = rs.getString(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return nombreUsuario;
    }

    public String getClaveUsuario(String clave) throws Exception {
        String claveUsuario = null;
        String query = "SELECT Clave " + "FROM Usuario WHERE Estado = 'A' AND Clave = " + "'" + clave + "'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next()) {
                claveUsuario = rs.getString(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return claveUsuario;
    }

    public int getRolUsuario (String correo) throws Exception {
        Integer rolUsuario = null;
        String query = "SELECT IdRol " + "FROM Usuario WHERE Estado = 'A' AND CorreoInstitucional = " + "'" + correo + "'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next()) {
                rolUsuario = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return rolUsuario;
    }

    public int getIDUsuarioPorCorreo (String correoUsuario) throws Exception{
        Integer idUsuario = null;
        String query = "SELECT IdUsuario " + "FROM Usuario WHERE Estado = 'A' AND CorreoInstitucional = " + "'" + correoUsuario + "'";
        try {
            Connection conn = openConnection();
            Statement  stmt = conn.createStatement();
            ResultSet  rs   = stmt.executeQuery(query);
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return idUsuario;
    }

}
