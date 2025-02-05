package BusinessLogic;

import java.util.List;

import DataAccess.DAO.ClaseDAO;
import DataAccess.DTO.ClaseDTO;

public class ClaseBL {
    
    private ClaseDTO cDTO;
    private ClaseDAO cDAO = new ClaseDAO();

    public ClaseBL() {
    }

    public List<ClaseDTO> getAll() throws Exception{
        return cDAO.readAll();
    }

    public ClaseDTO getByIdCliente(int idCliente) throws Exception{
        cDTO = cDAO.readBy(idCliente);
        return cDTO;
    }

    public boolean create(ClaseDTO ClaseDTO) throws Exception{   
        return cDAO.create(ClaseDTO);
    }

    public boolean update(ClaseDTO ClaseDTO) throws Exception{
        return cDAO.update(ClaseDTO);
    }

    public boolean delete(int idCliente) throws Exception{
        return cDAO.delete(idCliente);
    }

    public Integer countDias (int idMateria) throws Exception {
        return cDAO.countDias(idMateria);
    }


}
