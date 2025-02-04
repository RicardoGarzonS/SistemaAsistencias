package BusinessLogic;

import java.util.List;
import java.util.function.Supplier;

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

    public boolean create(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO == null) {
            throw new Exception("¡El objeto UsuarioDTO no puede ser nulo!");
        }
        
        String usuario = usuarioDTO.getUsuario();
        String contraseña = usuarioDTO.getContraseña();
        
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
            
            String usuario = usuarioDTO.getUsuario();
            String contraseña = usuarioDTO.getContraseña();
            
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
