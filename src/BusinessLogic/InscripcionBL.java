package BusinessLogic;

import java.util.List;

import DataAccess.DAO.InscripcionDAO;
import DataAccess.DTO.InscripcionDTO;

public class InscripcionBL {
    private InscripcionDAO iDao;


    public InscripcionBL() {
        iDao = new InscripcionDAO();
    }

    public boolean registrarInscripcion(InscripcionDTO inscripcion) throws Exception {
        if (Integer.parseInt(inscripcion.getIdUsuario()) <= 0 || Integer.parseInt(inscripcion.getIdClase()) <= 0 || Integer.parseInt(inscripcion.getIdLector()) <= 0) 
        {
            throw new IllegalArgumentException("IDs de usuario, clase o lector inválidos");
        }
        return iDao.create(inscripcion);
    }

    public List<InscripcionDTO> getAll() throws Exception {
        return iDao.readAll();
    }

    public InscripcionDTO getById(int idInscripcion) throws Exception {
        return iDao.readBy(idInscripcion);
    }

    public boolean update(InscripcionDTO idInscripcion) throws Exception {
        return iDao.update(idInscripcion);
    }

    public boolean delete(int idInscripcion) throws Exception {
        return iDao.delete(idInscripcion);
    }
}

