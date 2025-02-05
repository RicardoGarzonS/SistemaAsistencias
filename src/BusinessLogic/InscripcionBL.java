package BusinessLogic;

import java.util.List;

import DataAccess.DAO.InscripcionDAO;
import DataAccess.DTO.InscripcionDTO;

public class InscripcionBL {
    private InscripcionDTO iDTO; //cache
    private InscripcionDAO iDAO = new InscripcionDAO();


    public InscripcionBL() {
        iDAO = new InscripcionDAO();
    }

    public boolean registrarInscripcion(InscripcionDTO inscripcion) throws Exception {
        if (Integer.parseInt(inscripcion.getIdUsuario()) <= 0 || Integer.parseInt(inscripcion.getIdClase()) <= 0 || Integer.parseInt(inscripcion.getIdLector()) <= 0) 
        {
            throw new IllegalArgumentException("IDs de usuario, clase o lector inválidos");
        }
        return iDAO.create(inscripcion);
    }

    public List<InscripcionDTO> getAll() throws Exception {
        return iDAO.readAll();
    }

    public InscripcionDTO getById(int idInscripcion) throws Exception {
        iDTO = iDAO.readBy(idInscripcion);
        return iDTO;
    }

    public boolean update(InscripcionDTO idInscripcion) throws Exception {
        return iDAO.update(idInscripcion);
    }

    public boolean delete(int idInscripcion) throws Exception {
        return iDAO.delete(idInscripcion);
    }

    public String getFechaInscripcion (Integer idUsuario, Integer idMaterial) throws Exception {
        return iDAO.getFechaInscripcion(idUsuario, idMaterial);
    }

    public String[] getMateriaInscritas (Integer idUsuario) throws Exception {
        return iDAO.getMateriasInscritas(idUsuario);
    }
}

