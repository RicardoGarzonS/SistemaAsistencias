package BusinessLogic;

import java.util.List;

import DataAccess.DAO.AsistenciaDAO;
import DataAccess.DTO.AsistenciaDTO; 

public class AsistenciaBL {
    private AsistenciaDTO Asistencia; //cache
    private AsistenciaDAO aDAO = new AsistenciaDAO();

    /***
     * 
     * @param asistencia objeto de tipo AsistenciaDTO, sirve para modificar el reistro
     * @return true si se registro la asistencia, false si no se registro
     * @throws Exception
     */
    public boolean registrarAsistencia(AsistenciaDTO asistencia) throws Exception {
        if (asistencia.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de asistencia no puede ser nula.");
        }
        return aDAO.create(asistencia); 
    }

    /***
     * 
     * @return lista de todas las asistencias registradas
     * @throws Exception
     */
    public List<AsistenciaDTO> getAll() throws Exception {
        return aDAO.readAll();
    }
    
    /***
     * 
     * @param idAsistencia id del reigstro de la assitencia 
     * @return  retorna el registro de la asistencia
     * @throws Exception
     */
    public AsistenciaDTO getById(int idAsistencia) throws Exception {
        Asistencia = aDAO.readBy(idAsistencia);
        return Asistencia;
    }
    
    /***
     * 
     * @param Asistencia objeto de tipo AsistenciaDTO, sirve para modificar el registro
     * @return true si se actualizo la asistencia, false si no se actualizo
     * @throws Exception
     */
    public boolean update(AsistenciaDTO Asistencia) throws Exception {
        return aDAO.update(Asistencia);
    }

    /***
     * 
     * @param idAsistencia id del registro de la asistencia
     * @return boolean true si se elimino la asistencia, false si no se elimino
     * @throws Exception
     */
    public boolean delete(int idAsistencia) throws Exception {
        return aDAO.delete(idAsistencia);
    }
    
    /***
     * 
     * @param idUsuario id del usuario
     * @param fechaActual fecha de corte de las asistencias 
     * @param idMaterial id de la materia
     * @return integer con el conteo de las asistencias de una materia especifica
     * @throws Exception
     */
    public Integer contarAsistenciasMateriaEspecifica (int idUsuario, String fechaActual,int idMaterial) throws Exception {
        return aDAO.contarAsistenciasMateriaEspecifica(idUsuario, fechaActual ,idMaterial);
    }

    /***
     * 
     * @param idUsuario id del usuario
     * @param fechaActual fecha de corte de las asistencias
     * @return arreglo con el conteo de las asistencias de todas las materias inscritas por el estudiante
     * @throws Exception
     */
    public String [] contarAsistenciasTotalMaterias (Integer idUsuario, String fechaActual) throws Exception {
        return aDAO.contarAsistenciasTotalMaterias(idUsuario, fechaActual);
    }

    /***
     * 
     * @param correoEstudiante correo del estudainte
     * @param fechaActual fecha de corte de las asistencias
     * @param nobreMateria nombre de la mateira 
     * @return cuenta las asistencias de un estudiante especifico
     * @throws Exception
     */
    public Integer contarAsistenciasEstudianteEspecifico (String correoEstudiante, String fechaActual, String nobreMateria) throws Exception {
        return aDAO.contarAsistenciasEstudianteEspecifico(correoEstudiante, fechaActual, nobreMateria);
    }

    /***
     * 
     * @param nombreMateria nombre de la materia
     * @param fechaActual fecha de corte de las asistencias
     * @return cuenta de las asistenicas del estudiante por materia
     * @throws Exception
     */
    public String [] contarAsistenciasEstudiantesPorMateria (String nombreMateria, String fechaActual) throws Exception {
        return aDAO.contarAsistenciasTotalEstudiantes(nombreMateria, fechaActual);
    }

    /***
     * 
     * @param idEstudiante id del estudiante
     * @param fechaActual fecha de corte de las asistencias
     * @return arreglo de las asistencias de todas las materias inscritas por el estudiante
     * @throws Exception
     */
    public String [][] tablaAsistenciasTotalMateriasE (int idEstudiante, String fechaActual) throws Exception {
        return aDAO.tablaAsistenciasTotalMateriasE(idEstudiante, fechaActual);
    }

    /***
     * 
     * @param idDocente id del docente
     * @param fechaActual fecha de corte de las asistencias
     * @return arreglo de laasistenicas totales del docente
     * @throws Exception
     */
    public String [][] tablaAsistenciasTotalMateriasD (int idDocente, String fechaActual) throws Exception {
        return aDAO.tablaAsistenciasTotalMateriasD(idDocente, fechaActual);
    }

    /***
     * 
     * @param idEstudiante id del estudiante
     * @param fechaActual fecha de corte de las asistencias
     * @return conteo de los tipo de asistencias del estudiante
     * @throws Exception
     */
    public String [][] tablaConteoTipoAsistencias (int idEstudiante, String fechaActual) throws Exception {
        return aDAO.tablaConteoTipoAsistenciasE(idEstudiante, fechaActual);
    }

    /***
     * 
     * @param idDocente id del docente
     * @param fechaActual fecha de corte de las asistencias
     * @return conteo de los tipos de asistencias del docente
     * @throws Exception
     */
    public String [][] tablaConteoTipoAsistenciasD (int idDocente, String fechaActual) throws Exception {
        return aDAO.tablaConteoTipoAsistenciasD(idDocente, fechaActual);
    }

    /***
     * 
     * @param idDocente id del docente
     * @param fechaActual fecha de corte de las asistencias
     * @return arreglo del conteo de las asitentias del total de estudiane por amtera del profesor 
     * @throws Exception
     */
    public String [][] tablaConteoAsistenciasTotalEYMProfesor (Integer idDocente, String fechaActual) throws Exception {
        return aDAO.conteoAsistenciasTotalEYMProfesor(idDocente, fechaActual);
    }

    /***
     * 
     * @param idDocente id del docente
     * @param fechaActual fecha de corte de las asistencias
     * @return arreglo del conteo de las asistencias del total de estudiane por amtera del profesor
     * @throws Exception
     */
    public String [][] tablaConteoTipoAsistenciasDME (int idDocente, String fechaActual) throws Exception {
        return aDAO.tablaConteoTipoAsistenciasDME(idDocente, fechaActual);
    }

    /***
     * 
     * @param entity objeto de tipo AsistenciaDTO, sirve para modificar el registro
     * @param horaEntrada hora de entrada del usuario
     * @param idAsistencia id del registro de la asistencia
     * @return true si se actualizo la hora de entrada, false si no se actualizo
     * @throws Exception
     */
    public boolean updateHoraEntrada (AsistenciaDTO entity, String horaEntrada, Integer idAsistencia) throws Exception {
        return aDAO.updateHoraEntrada(entity, horaEntrada, idAsistencia);
    }

    /***
     * 
     * @param entity objeto de tipo AsistenciaDTO, sirve para modificar el registro
     * @param horaSalida hora de salida del usuario
     * @param idAsistencia id del registro de la asistencia
     * @return true si se actualizo la hora de salida, false si no se actualizo
     * @throws Exception
     */
    public boolean updateHoraSalida (AsistenciaDTO entity, String horaSalida, Integer idAsistencia) throws Exception {
        return aDAO.updateHoraSalida(entity, horaSalida, idAsistencia);
    }

    /***
     * 
     * @param idUsuario id del usuario
     * @param fechaActual fecha de corte de las asistencias
     * @return  id del registro de la asistencia
     * @throws Exception
     */
    public Integer getIdAsistenciaByIdUsuarioYFecha (Integer idUsuario, String fechaActual) throws Exception {
        return aDAO.getIdAsistenciaByIdUsuarioYFecha(idUsuario, fechaActual);
    }
    
}
    
