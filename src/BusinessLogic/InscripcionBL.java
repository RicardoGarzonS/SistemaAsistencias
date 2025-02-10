package BusinessLogic;

import DataAccess.DAO.AsistenciaDAO;
import DataAccess.DAO.ClaseDAO;
import DataAccess.DAO.InscripcionDAO;
import DataAccess.DTO.AsistenciaDTO;
import DataAccess.DTO.InscripcionDTO;
import DataAccess.SQLiteDataHelper;
import Framework.ExceptionLogger;
import UserInterface.Style;
import java.sql.Connection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class InscripcionBL extends SQLiteDataHelper {
    private InscripcionDAO iDAO;
    private ClaseDAO claseDAO;
    private AsistenciaDAO asistenciaDAO;
    private ConfiguracionClase config;


    public InscripcionBL(InscripcionDAO iDAO, ClaseDAO claseDAO, AsistenciaDAO asistenciaDAO, ConfiguracionClase config) {
        this.iDAO = iDAO;
        this.claseDAO = claseDAO;
        this.asistenciaDAO = asistenciaDAO;
        this.config = config;
    }


    public InscripcionBL() {
        iDAO = new InscripcionDAO();
    }


    public boolean registrarInscripcion(InscripcionDTO inscripcion) throws Exception {
        Connection conn = null;
        try {
            conn = openConnection();
            conn.setAutoCommit(false); // Iniciar transacción

            // Validar IDs
            int idUsuario = Integer.parseInt(inscripcion.getIdUsuario());
            int idClase = Integer.parseInt(inscripcion.getIdClase());
            int idLector = Integer.parseInt(inscripcion.getIdLector());

            if (idUsuario <= 0 || idClase <= 0 || idLector <= 0) {
                throw new IllegalArgumentException("IDs inválidos");
            }

            // Crear inscripción
            if (!iDAO.create(inscripcion)) {
                throw new Exception("Error al crear inscripción");
            }

            int idInscripcion = iDAO.obtenerUltimoIdInscripcion();

            int idDia = claseDAO.obtenerIdDiaPorIdClase(idClase);

            generarAsistencias(idInscripcion, idDia, conn);

            conn.commit(); 
            return true;
        } catch (IllegalArgumentException e) {
            Style.showMsgError("Error de validación: " + e.getMessage());
            new ExceptionLogger(e.getMessage(), this.getClass().getName(), "registrarInscripcion");
            throw e;
        } catch (Exception e) {
            if (conn != null) conn.rollback(); 
            Style.showMsgError("Error al registrar inscripción: " + e.getMessage());
            new ExceptionLogger(e.getMessage(), this.getClass().getName(), "registrarInscripcion");
            throw e;
        } finally {
            if (conn != null) conn.close(); 
        }
    }


    private void generarAsistencias(int idInscripcion, int idDia, Connection conn) throws Exception {
        DayOfWeek diaClase = convertirIdDiaADiaSemana(idDia);
        LocalDate fechaClase = config.getFechaInicio().with(TemporalAdjusters.nextOrSame(diaClase));

        for (int i = 0; i < config.getSemanasDuracion(); i++) {
            String fechaAsistenciaStr = fechaClase.plusWeeks(i).toString(); // Formato yyyy-MM-dd
            AsistenciaDTO asistencia = new AsistenciaDTO(String.valueOf(idInscripcion), fechaAsistenciaStr);
            try {
                asistenciaDAO.create(asistencia, conn);
            } catch (Exception e) {
                new ExceptionLogger(e.getMessage(), this.getClass().getName(), "generarAsistencias");
                throw new Exception("Error al generar asistencias: " + e.getMessage());
            }
        }
    }

    private DayOfWeek convertirIdDiaADiaSemana(int idDia) {
        return switch (idDia) {
            case 1 -> DayOfWeek.MONDAY;      // Lunes
            case 2 -> DayOfWeek.TUESDAY;     // Martes
            case 3 -> DayOfWeek.WEDNESDAY;   // Miércoles
            case 4 -> DayOfWeek.THURSDAY;    // Jueves
            case 5 -> DayOfWeek.FRIDAY;      // Viernes
            case 6 -> DayOfWeek.SATURDAY;    // Sábado
            case 7 -> DayOfWeek.SUNDAY;      // Domingo
            default -> throw new IllegalArgumentException("ID día inválido: " + idDia);
        };
    }

    public List<InscripcionDTO> getAll() throws Exception {
        return iDAO.readAll();
    }

    public InscripcionDTO getById(int idInscripcion) throws Exception {
        return iDAO.readBy(idInscripcion);
    }

    public boolean update(InscripcionDTO inscripcion) throws Exception {
        return iDAO.update(inscripcion);
    }

    public boolean delete(int idInscripcion) throws Exception {
        return iDAO.delete(idInscripcion);
    }

    /***
     * 
     * @param idUsuario id del usario
     * @param idMaterial id de la materia
     * @return la fecha de inscripcion del usuario a la materia
     * @throws Exception
     */
    public String getFechaInscripcion(Integer idUsuario, Integer idMaterial) throws Exception {
        return iDAO.getFechaInscripcion(idUsuario, idMaterial);
    }

    /***
     * 
     * @param idUsuario id del usuario
     * @return arreglo de las materias inscritas por el usuario
     * @throws Exception
     */
    public String [] getMateriaInscritas (Integer idUsuario) throws Exception {
        return iDAO.getMateriasInscritas(idUsuario);
    }

    /***
     * 
     * @param idMateria id de la materia
     * @return arreglo de los id de los estudiantes inscritos en la materia
     * @throws Exception
     */
    public String [] getIdEstudiantesPorMateria (int idMateria) throws Exception {
        return iDAO.getIdUsuariosPorMateria(idMateria);
    }

    /***
     * 
     * @param idMateria id de la materia
     * @return arreglo de los correos de los estudiantes inscritos en la materia
     * @throws Exception
     */
    public String [] getCorreosEstudiantesPorMateria (int idMateria) throws Exception {
        return iDAO.getCorreoEstudiantesPorMateria(idMateria);
    }

    /***
     * 
     * @param idEstudiante id del estudiante
     * @param idMateria id de la materia
     * @return la hora de inicio de la materia
     * @throws Exception
     */
    public String getHoraInicioPorMateria (int idEstudiante, int idMateria) throws Exception {
        return iDAO.getHoraInicioPorMateria(idEstudiante, idMateria);
    }

    /***
     * 
     * @param idEstudiante id del estudiante
     * @param idMateria id de la materia
     * @return la hora de fin de la materia
     * @throws Exception
     */
    public String getHoraFinPorMateria (Integer idEstudiante, Integer idMateria) throws Exception {
        return iDAO.getHoraFinPorMateria(idEstudiante, idMateria);
    }

    /***
     * 
     * @param idEstudiante id del estudiante
     * @return arreglo de los id de estudiantes inscritos en la materia por el rol
     * @throws Exception
     */
    public Integer [] getIdEstudiantesPorMateriaRolE (int idEstudiante) throws Exception {
        return iDAO.getIdEstudiantesPorMateriaRolE(idEstudiante);
    }

    /***
     * 
     * @param idUsuario id del usuario
     * @return arreglo de las materias inscritas por el usuario (horario)
     * @throws Exception
     */
    public String [][] getHorario (Integer idUsuario) throws Exception {
        return iDAO.getHorarioById(idUsuario);
    }


}