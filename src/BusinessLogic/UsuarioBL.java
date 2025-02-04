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
        return uDAO.create(usuarioDTO);
    }

    public boolean update(UsuarioDTO usuarioDTO) throws Exception {
        return uDAO.update(usuarioDTO);
    }

    public boolean delete(int idUsuario) throws Exception {
        return uDAO.delete(idUsuario);
    }
}
