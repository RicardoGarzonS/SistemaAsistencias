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

    public int obtenerUltimoIdInscripcion() throws Exception {
        String query = "SELECT last_insert_rowid()";
        try (Connection conn = openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new Exception("Error al obtener el último ID de inscripción: " + e.getMessage());
        }
    }

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

    public List<InscripcionDTO> readByIdUsuario(Integer idUsuario) throws Exception {
        List<InscripcionDTO> inscripciones = new ArrayList<>();
        String query = "SELECT IdInscripcion, IdUsuario, IdClase, IdLector, Año, Estado, FechaCreacion, FechaModificacion " 
                       + "FROM Inscripcion WHERE Estado = 'A' AND IdUsuario = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InscripcionDTO inscripcion = new InscripcionDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                );
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            throw e;
        }
        return inscripciones;
    }

    public String[] getMateriasInscritas(Integer idUsuario) throws Exception {
        List<String> materiasList = new ArrayList<>();
        String query = "SELECT m.Nombre FROM Materia m " + 
                   "JOIN Clase c ON m.IDMateria = c.IDMateria " + 
                   "JOIN Inscripcion i ON c.IDClase = i.IDClase " + 
                   "WHERE i.IdUsuario = ? AND i.Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            materiasList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return materiasList.toArray(new String[0]);
    }

    public String [] getIdUsuariosPorMateria (Integer idMateria) throws Exception{
        List<String> idUsuarios = new ArrayList<>();
        String query = "SELECT i.IdUsuario FROM Inscripcion i " + 
                       "JOIN Clase c ON i.IDClase = c.IDClase " + 
                       "WHERE c.IDMateria = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idMateria);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUsuarios.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idUsuarios.toArray(new String[0]);
    }

    public String [] getCorreoEstudiantesPorMateria (Integer idMateria) throws Exception{
        List<String> correos = new ArrayList<>();
        String query = "SELECT u.CorreoInstitucional FROM Usuario u " + 
                       "JOIN Inscripcion i ON u.IDUsuario = i.IDUsuario " + 
                       "JOIN Clase c ON i.IDClase = c.IDClase " + 
                       "WHERE c.IDMateria = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idMateria);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                correos.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return correos.toArray(new String[0]);
    }

    public String [] getHoraInicioTotalMaterias (Integer idEstudiante) throws Exception {
        List<String> horasInicio = new ArrayList<>();
        String query = "SELECT c.HoraInicio FROM Clase c " + 
                       "JOIN Inscripcion i ON c.IDClase = i.IDClase " +
                       "WHERE i.IDUsuario = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idEstudiante);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                horasInicio.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horasInicio.toArray(new String[0]);
    }

    public String [] getHoraFinTotalMaterias (Integer idEstudiante) throws Exception {
        List<String> horasInicio = new ArrayList<>();
        String query = "SELECT c.HoraFin FROM Clase c " + 
                       "JOIN Inscripcion i ON c.IDClase = i.IDClase " +
                       "WHERE i.IDUsuario = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idEstudiante);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                horasInicio.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horasInicio.toArray(new String[0]);
    }


    
}