package BusinessLogic;

import java.util.List;

import DataAccess.DTO.UsuarioDTO;
import DataAccess.DAO.UsuarioDAO;

public class UsuarioBL {
    private UsuarioDAO uDAO ;
    private UsuarioDTO Usuario; //cache

    public UsuarioBL() {
        uDAO = new UsuarioDAO();
    }

    public List<UsuarioDTO> getAll() throws Exception{
        return uDAO.readAll();
    } 

    public UsuarioDTO getByIdUsuario(int idUsuario) throws Exception {
        Usuario = uDAO.readBy(idUsuario);
        return Usuario;
    }

    /***
     * 
     * @param correoUsuario correo del usuario
     * @return devuelve el correo del usuario desde la base
     * @throws Exception
     */
    public String getCorreoUsuario(String correoUsuario) throws Exception {
        return uDAO.getCorreo(correoUsuario);
    }
    
    /***
     * 
     * @param idEstudiante id del estudiante
     * @return devuelve el nombre del usuario desde la base
     * @throws Exception
     */
    public String getNombreUsuario(int idEstudiante) throws Exception {
        return uDAO.getNombreUsuario(idEstudiante);
    }

    /***
     * 
     * @param nombreUsuario nombre del usuario
     * @return devuelve la clave del usuario desde la base
     * @throws Exception
     */
    public String getClaveUsuario(String nombreUsuario) throws Exception {
        return uDAO.getClaveUsuario(nombreUsuario);
    }

    /***
     * 
     * @param correoUsuario correo del usuario
     * @return devuelve el rol del usuario desde la base
     * @throws Exception
     */
    public int getRolUsuario(String correoUsuario) throws Exception {
        return uDAO.getRolUsuario(correoUsuario);
    }

    /***
     * 
     * @param correoUsuario correo del usuario
     * @return devuelve el id del usuario desde la base por medio del correo
     * @throws Exception
     */
    public int getIdUsuarioPorCorreo (String correoUsuario) throws Exception {
        return uDAO.getIDUsuarioPorCorreo(correoUsuario);
    }

    public boolean create(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO == null) {
            throw new Exception("¡El objeto UsuarioDTO no puede ser nulo!");
        }
        
        String usuario = usuarioDTO.getIdUsuario();
        String contraseña = usuarioDTO.getClave();
        
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new Exception("¡El nombre de usuario no puede estar vacío!");
        }
        
        if (contraseña == null || contraseña.trim().isEmpty()) {
            throw new Exception("¡La contraseña no puede estar vacía!");
        }
        
        return uDAO.create(usuarioDTO);
    }
        
    public boolean update(UsuarioDTO usuarioDTO) throws Exception {
            if (usuarioDTO == null) {
                throw new Exception("¡El objeto UsuarioDTO no puede ser nulo!");
            }
            
            String usuario = usuarioDTO.getIdUsuario();
            String contraseña = usuarioDTO.getClave();
            
            if (usuario == null || usuario.trim().isEmpty()) {
                throw new Exception("¡El nombre de usuario no puede estar vacío!");
            }
            
            if (contraseña == null || contraseña.trim().isEmpty()) {
                throw new Exception("¡La contraseña no puede estar vacía!");
            }
            
            return uDAO.update(usuarioDTO);
        }



    public boolean delete(int idUsuario) throws Exception {
        return uDAO.delete(idUsuario);
    }
}
