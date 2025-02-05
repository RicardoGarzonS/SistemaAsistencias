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

    public String getCorreoUsuario(String correoUsuario) throws Exception {
        return uDAO.getCorreo(correoUsuario);
    }

    public String getClaveUsuario(String nombreUsuario) throws Exception {
        return uDAO.getClaveUsuario(nombreUsuario);
    }

    public int getRolUsuario(String correoUsuario) throws Exception {
        return uDAO.getRolUsuario(correoUsuario);
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
