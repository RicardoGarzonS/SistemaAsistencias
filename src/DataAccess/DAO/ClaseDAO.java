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
import DataAccess.DTO.ClaseDTO;

public class ClaseDAO extends SQLiteDataHelper implements IDAO<ClaseDTO>{

    @Override
    public ClaseDTO readBy(Integer id) throws Exception {
     ClaseDTO Clase = new ClaseDTO();
     String query = "SELECT IdClase"
                  + " ,IdMateria"
                  + " ,IdDia"
                  + " ,HoraInicio"
                  + " ,HoraFin"
                  + " ,Estado"
                  + " ,FechaCreacion"
                  + " ,FechaModificacion"
                  + " FROM Clase WHERE Estado = 'A' AND IdClase = "+ id.toString
                  ();
                  try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                 Clase = new ClaseDTO( 
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
                return Clase;
    }

    @Override
    public List<ClaseDTO> readAll() throws Exception {
    List<ClaseDTO> Clases = new ArrayList<ClaseDTO>();
     String query = "SELECT IdClase"
                  + " ,IdMateria"
                  + " ,IdDia"
                  + " ,HoraInicio"
                  + " ,HoraFin"
                  + " ,Estado"
                  + " ,FechaCreacion"
                  + " ,FechaModificacion"
                  + " FROM Clase WHERE Estado = 'A'";

                  try {
                    Connection conn = openConnection();
                    Statement  stmt = conn.createStatement();
                    ResultSet  rs   = stmt.executeQuery(query);
                    while (rs.next()) {
                 ClaseDTO Clase = new ClaseDTO( 
                          rs.getString(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getString(4)
                        , rs.getString(5)
                        , rs.getString(6)
                        , rs.getString(7)
                        , rs.getString(8));
                        Clases.add(Clase);
                    }
                } catch (SQLException e) {
                    throw e;//new Exception( e.getMessage(), getClass().getName(), "readAll()");
                }
                return Clases;
    }

    @Override
    public boolean create(ClaseDTO entity) throws Exception {
        String query = "INSERT INTO Clase (IdClase, IdMateria, IdDia, HoraInicio, HoraFin) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, entity.getIdClase());
            pstmt.setString(2, entity.getIdMateria());
            pstmt.setString(3, entity.getIdDia());
            pstmt.setString(4, entity.getHoraInicio());
            pstmt.setString(5, entity.getHoraFin());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(ClaseDTO entity) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String query = "UPDATE Clase SET IdClase = ?, IdMateria = ?, IdDia = ?, HoraInicio = ?, HoraFin = ?, FechaModifica = ? WHERE IdClase = ?";
       try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, entity.getIdClase());
            pstmt.setString(2, entity.getIdMateria());
            pstmt.setString(3, entity.getIdDia());
            pstmt.setString(4, entity.getHoraInicio());
            pstmt.setString(5, entity.getHoraFin());
            pstmt.setString(6, now.format(formatter));
            pstmt.setString(7, entity.getIdClase());
            pstmt.executeUpdate();
            return true;
    }
    catch (SQLException e) {
            throw e;//new Exception( e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = "UPDATE Clase SET Estado = ? WHERE IdClase = ?";
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

    // Cantidad de dias de clase, voy a asumir que son cuatro semestres de clase, entonces 16 semanas
    public Integer countDias (Integer idMateria) throws Exception {
        String query =" SELECT COUNT(*) TotalReg FROM Clase"
                     +" WHERE IDMateria = " + idMateria.toString() + "AND Estado = 'A'";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }

    public int obtenerIdDiaPorIdClase(int idClase) throws Exception {
        String query = "SELECT idDia FROM Clase WHERE idClase = ?";
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idClase);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idDia");
                } else {
                    throw new Exception("Clase no encontrada con idClase = " + idClase);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener el idDia por idClase: " + e.getMessage(), e);
        }
    }
    

}
