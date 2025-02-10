package BusinessLogic.Entities;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import BusinessLogic.AsistenciaBL;
import BusinessLogic.InscripcionBL;

public class Docente {
    /***
     * 
     * @param correoEstudiante el correo del estudiante
     * @param nombreMateria el nombre de la materia (Maybe esto la jalamos con un textBox o un comboBox de la GUI)
     * @return retorna el numero de asistencias, aun no contemplo la posibilidad de que existan justificantes
     * @throws Exception
     */
    public int asistenciasEstudianteEspecifico (String correoEstudiante, String nombreMateria) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(aBl.contarAsistenciasEstudianteEspecifico(correoEstudiante, fechaActual, nombreMateria));
        return aBl.contarAsistenciasEstudianteEspecifico(correoEstudiante, fechaActual, nombreMateria);
        
    }

    /***
     * 
     * @param nombreMateria nombre de la materia de la cual se busca otener las asitencias 
     * @return  retorna un arreglo con el numero de asistencias de cada estudiante
     * @throws Exception
     */
    public String [] asistenciasTotalEstudiantes (String nombreMateria) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.contarAsistenciasEstudiantesPorMateria(nombreMateria, fechaActual)));
        return aBl.contarAsistenciasEstudiantesPorMateria(nombreMateria, fechaActual);
    }

    /***
     * 
     * @param idDocente el id del docente/profesor 
     * @return arreglo el cual es el conteo de asistenicas del total de estudiantes por cada matria del profesor
     * @throws Exception
     */
    public String [][] tablaConteoAsistenciasTotalEYMProfesor (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.tablaConteoAsistenciasTotalEYMProfesor(idDocente, fechaActual)));
        return aBl.tablaConteoAsistenciasTotalEYMProfesor(idDocente, fechaActual);
    }


    /***
     * 
     * @param idDocente id del docente/profesor
     * @return  arreglo con el conteo de asistencias de cada estudiante por cada materia del profesor
     * @throws Exception
     */
    public String [][] tablaConteoTipoAsistenciasDME (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        System.out.println(Arrays.toString(aBl.tablaConteoTipoAsistenciasDME(idDocente, fechaActual)));
        return aBl.tablaConteoTipoAsistenciasDME(idDocente, fechaActual);
    }


    /***
     * 
     * @param idDocente id del docente/profesor
     * @return arrelgo del total de asistenicas del profesor 
     * @throws Exception
     */
    public String [][] totalAsistenciasTotalMateriasD (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        return aBl.tablaAsistenciasTotalMateriasD(idDocente, fechaActual);
    }
    
    /***
     * 
     * @param idDocente id del docente/profesor
     * @return arreglo del conteo del tipo de asistencias del profesor
     * @throws Exception
     */
    public String [][] totalAsistenciasTipoD (Integer idDocente) throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate now = LocalDate.now();

        String fechaActual = dateFormat.format(java.sql.Date.valueOf(now)).replace("/", "-");

        AsistenciaBL aBl = new AsistenciaBL();
        return aBl.tablaConteoTipoAsistenciasD(idDocente, fechaActual);
    }

    /***
     * 
     * @param idDocente id del profesor
     * @return arreglo que hace referencia al horario del docente
     * @throws Exception
     */
    public String [][] tablaHorarioD (Integer idDocente) throws Exception {
        InscripcionBL iBl = new InscripcionBL();
        return iBl.getHorario(idDocente);
    }

}
