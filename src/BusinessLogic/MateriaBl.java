package BusinessLogic;

import java.util.List;

import DataAccess.DAO.MateriaDAO;
import DataAccess.DTO.MateriaDTO;


public class MateriaBl {
    private MateriaDTO mDTO; //cache
    private MateriaDAO mDAO = new MateriaDAO();

    
    public List<MateriaDTO> getAll() throws Exception {
        return mDAO.readAll();
    }
    
    public MateriaDTO getById(int idAsistencia) throws Exception {
        mDTO = mDAO.readBy(idAsistencia);
        return mDTO;
    }
    
    public boolean update(MateriaDTO Asistencia) throws Exception {
        return mDAO.update(Asistencia);
    }
    
    public boolean delete(int idAsistencia) throws Exception {
        return mDAO.delete(idAsistencia);
    }

    public int getIdMateria (String nombreMateria) throws Exception {
        return mDAO.getIdMateria(nombreMateria);
    }
    
}
