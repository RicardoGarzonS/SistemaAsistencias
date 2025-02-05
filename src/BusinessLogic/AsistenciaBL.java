package BusinessLogic;

import java.util.List;

import DataAccess.DAO.AsistenciaDAO;
import DataAccess.DTO.AsistenciaDTO; 

public class AsistenciaBL {
    private AsistenciaDTO Asistencia; //cache
    private AsistenciaDAO aDAO = new AsistenciaDAO();


    public boolean registrarAsistencia(AsistenciaDTO asistencia) throws Exception {
        if (asistencia.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de asistencia no puede ser nula.");
        }
        return aDAO.create(asistencia); 
    }
    
    public List<AsistenciaDTO> getAll() throws Exception {
        return aDAO.readAll();
    }
    
    public AsistenciaDTO getById(int idAsistencia) throws Exception {
        Asistencia = aDAO.readBy(idAsistencia);
        return Asistencia;
    }
    
    public boolean update(AsistenciaDTO Asistencia) throws Exception {
        return aDAO.update(Asistencia);
    }
    
    public boolean delete(int idAsistencia) throws Exception {
        return aDAO.delete(idAsistencia);
    }

    public Integer contarAsistenciasMateriaEspecifica (int idUsuario, String fechaActual,int idMaterial) throws Exception {
        return aDAO.contarAsistenciasMateriaEspecifica(idUsuario, fechaActual ,idMaterial);
    }

    public String [] contarAsistenciasTotalMaterias (Integer idUsuario, String fechaActual) throws Exception {
        return aDAO.contarAsistenciasTotalMaterias(idUsuario, fechaActual);
    }


    
}
    
