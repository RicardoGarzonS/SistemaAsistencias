package BusinessLogic;

import java.util.List;

import DataAccess.DAO.DiaDAO;
import DataAccess.DTO.DiaDTO;

public class DiaBL {
    
    private DiaDTO dDTO;
    private DiaDAO dDAO = new DiaDAO();

    public DiaBL() {
    }

    public List<DiaDTO> getAll() throws Exception{
        return dDAO.readAll();
    }

    public DiaDTO getByIdCliente(int idCliente) throws Exception{
        dDTO = dDAO.readBy(idCliente);
        return dDTO;
    }

    public boolean create(DiaDTO DiaDTO) throws Exception{   
        return dDAO.create(DiaDTO);
    }

    public boolean update(DiaDTO DiaDTO) throws Exception{
        return dDAO.update(DiaDTO);
    }

    public boolean delete(int idCliente) throws Exception{
        return dDAO.delete(idCliente);
    }

}
